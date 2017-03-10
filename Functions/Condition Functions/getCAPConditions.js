function getCAPConditions(pType,pStatus,pDesc,pImpact) // optional capID
{
	var resultArray = new Array();
	var lang= "ar_AE";
	
	if (arguments.length > 4)
		var itemCap = arguments[4]; // use cap ID specified in args
	else
		var itemCap = capId;

	////////////////////////////////////////
	// Check Records
	////////////////////////////////////////
	
	if (pType==null)
		var condResult = aa.capCondition.getCapConditions(itemCap);
	else
		var condResult = aa.capCondition.getCapConditions(itemCap,pType);
		
	if (condResult.getSuccess())
		var capConds = condResult.getOutput();
	else
		{ 
		var capConds = new Array();
		logDebug("**WARNING: getting cap conditions: " + condResult.getErrorMessage());
		}
	
	var cStatus;
	var cDesc;
	var cImpact;
	
	for (cc in capConds)
		{
		var thisCond = capConds[cc];
		var cStatus = thisCond.getConditionStatus();
		var cDesc = thisCond.getConditionDescription();
		var cImpact = thisCond.getImpactCode();
		var cType = thisCond.getConditionType();
		var cComment = thisCond.getConditionComment();
		var cExpireDate = thisCond.getExpireDate();
		
		if (cStatus==null)
			cStatus = " ";
		if (cDesc==null)
			cDesc = " ";
		if (cImpact==null)
			cImpact = " ";
		//Look for matching condition
		
		if ( (pStatus==null || pStatus.toUpperCase().equals(cStatus.toUpperCase())) && (pDesc==null || pDesc.toUpperCase().equals(cDesc.toUpperCase())) && (pImpact==null || pImpact.toUpperCase().equals(cImpact.toUpperCase())))
			{
			var r = new condMatchObj;
			r.objType = "Record";
			r.object = thisCond;
			r.status = cStatus;
			r.type = cType;
			r.impact = cImpact;
			r.description = cDesc;
			r.comment = cComment;
			r.expireDate = cExpireDate;

			var langCond = aa.condition.getCondition(thisCond, lang).getOutput();
			
			r.arObject = langCond;
			r.arDescription = langCond.getResConditionDescription();
			r.arComment = langCond.getResConditionComment();
			
			resultArray.push(r);
			}
		}

		return resultArray;
}
