// EXPRESSION BUILDER SCRIPT TO DO GIS LOOKUPS

//STOCK STUFF THAT COMES WITH EVERY EXPRESSION BUILDER SCRIPT; DISCARD IF YOU DON'T WANT IT.
var toPrecision = function (value) {
	var multiplier = 10000;
	return Math.round(value * multiplier) / multiplier;
}
function addDate(iDate, nDays) {
	if (isNaN(nDays)) {
		throw ("Day is a invalid number!");
	}
	return expression.addDate(iDate, parseInt(nDays));
}

function diffDate(iDate1, iDate2) {
	return expression.diffDate(iDate1, iDate2);
}

function parseDate(dateString) {
	return expression.parseDate(dateString);
}

function formatDate(dateString, pattern) {
	if (dateString == null || dateString == '') {
		return '';
	}
	return expression.formatDate(dateString, pattern);
}

//MY STUFF I WROTE

//EXPRESSION BUILDER DOESN'T KNOW ABOUT aa.cap or aa.parcel or anything else. This line fixes that.
var aa = expression.getScriptRoot();

//I WANTED THIS SCRIPTED AGAINST ENTERING A PARCEL NUMBER, SO LETS GRAB THAT INFO.
var servProvCode = expression.getValue("$$servProvCode$$").value;
var parcel = expression.getValue("PAR::parcel");
var parcelNum = expression.getValue("PAR::parcelNo");

//THIS IS THE ASI I WANT TO SET BASED ON GIS LOOKUP
var asiFloodReview = expression.getValue("ASI::GROUP_A::Flood Review Required");

//THIS WAS PART OF MY STANDARD TEMPLATE ... SO THERE IT IS.
var totalRowCount = expression.getTotalRowCount();

//THIS IS A CALL TO THE GIS FUNCTION DOWN BELOW THAT RETRIEVES THE DATA.
//HARDCODED VALUES FOR TESTING PURPOSES.

var gisLookupResult = getGISInfoByParcel("AGIS_VC", "East-West Inspection Areas", "INSP_AREA", parcelNum.value, -1);
//var gisLookupResult = getGISInfoByParcel("AGIS_VC", "Floodplains", "FLDZONE", parcelNum, -1);

//FOR TESTING PURPOSES, IT JUST PUTS A MESSAGE NEXT TO THE ASI IN QUESTION, RATHER THAN ACTUALLY SET IT.
asiFloodReview.message = "Result for parcel " + parcelNum.value + ": " + gisLookupResult;

//SAVING THE ASI FIELD.
expression.setReturn(asiFloodReview);


// THIS IS THE GIS LOOKUP, STRAIGHT OUT OF THE MASTER SCRIPTS (OR YOUR CUSTOM SCRIPTS). THIS ONE IS A CUSTOM ONE I BUILT AND MODIFIED FOR THIS PURPOSE.
// REMEMBER TO REPLACE THINGS LIKE "logDebug" and "logMessage" WITH APPROPRIATE HANDLING CODE, SINCE THEY AREN'T INCLUDED HERE.
// IN MY CASE, I REPLACED LOGDEBUG BY UPDATING THE ASI MESSAGE VALUE WITH THE DEBUG MESSAGE (see retValue)
function getGISInfoByParcel(param_svc, param_layer, param_attributename, param_parcelToLookup, param_distance) {
	//SHOULD ADD INPUT VALIDATION CHECKS HERE. 
	
	var gisSVC = param_svc;
	var gisLayer = param_layer;
	var gisAttribute = param_attributename;
	var actionString = "attribute";
	var targetParcel = param_parcelToLookup;
	if (targetParcel.length != 10) {
		retValue = "WARNING: getGISInfoByParcel parcel number length is not 10 digits";
	}

	var gisDistance = 0;
	if (arguments.length >= 6) {
		gisDistance = arguments[5];
	}

	var gisDistanceUnit = "feet";

	var retValue = null;

	//GET GIS BUFFER AND GIS OBJECT
	var bufferTargetResult = aa.gis.getGISType(gisSVC, gisLayer); // get the buffer target

	if (bufferTargetResult.getSuccess()) {
		var buf = bufferTargetResult.getOutput();
		if (gisAttribute != null) {
			buf.addAttributeName(gisAttribute);
		}
	} else {
		retValue  = "**WARNING: Getting GIS Type for Buffer Target.  Reason is: " + bufferTargetResult.getErrorType() + ":" + bufferTargetResult.getErrorMessage();
		return retValue;
	}

	var gisObjResult = aa.gis.getParcelGISObjects(targetParcel); // get gis objects on the parcel number
	if (gisObjResult.getSuccess())
		var fGisObj = gisObjResult.getOutput();
	else {
		retValue = "**WARNING: Getting GIS objects for Cap.  Reason is: " + gisObjResult.getErrorType() + ":" + gisObjResult.getErrorMessage();
		return retValue;
	}

	for (a1 in fGisObj) // for each GIS object related to the parcel
	{
		var bufchk = aa.gis.getBufferByRadius(fGisObj[a1], gisDistance, gisDistanceUnit, buf);

		if (bufchk.getSuccess()) {
			var proxArr = bufchk.getOutput();
		} else {
			retValue = "**WARNING: Retrieving Buffer Check Results.  Reason is: " + bufchk.getErrorType() + ":" + bufchk.getErrorMessage();
			return retValue;
		}

		for (a2 in proxArr) {
			var proxObj = proxArr[a2].getGISObjects(); // if there are GIS Objects here, get the relevant data and return it

			if (proxObj.length >= 2) {
				retValue = "WARNING: Within getGISInfoByParcel, multiple GIS objects were found while looking for a single attribute. Consider retrieving and parsing the array of data.";
			}
			for (z1 in proxObj) {
				var v = proxObj[z1].getAttributeValues();
				retValue = v[0];
			}
		}
	}
	return retValue;
	//RETURN A BOOL, STRING, OR ARRAY AS APPROPRIATE
}
