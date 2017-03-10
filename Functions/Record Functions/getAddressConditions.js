function getAddressConditions(pType,pStatus,pDesc,pImpact) // optional capID
{
	var resultArray = new Array();
	var lang= "ar_AE";
	
	if (arguments.length > 4)
		var itemCap = arguments[4]; // use cap ID specified in args
	else
		var itemCap = capId;
	////////////////////////////////////////
	// Check Address
	////////////////////////////////////////
	
	var addrResult = aa.address.getAddressByCapId(itemCap);
	if (!addrResult.getSuccess())
		{
		logDebug("**WARNING: getting CAP addresses: "+addrResult.getErrorMessage());
		var addrArray = new Array();
		}
	else
		{
		var addrArray = addrResult.getOutput();
		if (!addrArray) addrArray = new Array();
		}
		
	for (var thisAddr in addrArray)
		if (addrArray[thisAddr].getRefAddressId())
			{
			addCondResult = aa.addressCondition.getAddressConditions(addrArray[thisAddr].getRefAddressId())
			if (!addCondResult.getSuccess())
				{
				logDebug("**WARNING: getting Address Conditions : "+addCondResult.getErrorMessage());
				var addrCondArray = new Array();
				}
			else
				{
				var addrCondArray = addCondResult.getOutput();
				}
			
			for (var thisAddrCond in addrCondArray)
				{
				var thisCond = addrCondArray[thisAddrCond];
				var cType = thisCond.getConditionType();
				var cStatus = thisCond.getConditionStatus();
				var cDesc = thisCond.getConditionDescription();
				var cImpact = thisCond.getImpactCode();
				var cType = thisCond.getConditionType();
				var cComment = thisCond.getConditionComment();
				var cExpireDate = thisCond.getExpireDate();

				if (cType == null)
					cType = " ";
				if (cStatus==null)
					cStatus = " ";
				if (cDesc==null)
					cDesc = " ";
				if (cImpact==null)
					cImpact = " ";

				if ( (pType==null || pType.toUpperCase().equals(cType.toUpperCase())) && (pStatus==null || pStatus.toUpperCase().equals(cStatus.toUpperCase())) && (pDesc==null || pDesc.toUpperCase().equals(cDesc.toUpperCase())) && (pImpact==null || pImpact.toUpperCase().equals(cImpact.toUpperCase())))
					{
					var r = new condMatchObj;
					r.objType = "Address";
					r.addressObj = addrArray[thisAddr];
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
			}

	return resultArray;
}
