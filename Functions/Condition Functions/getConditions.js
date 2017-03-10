function getConditions(pType,pStatus,pDesc,pImpact) // optional capID
{
	var conditions = getCAPConditions(pType,pStatus,pDesc,pImpact);
	var addressConditions = getAddressConditions(pType,pStatus,pDesc,pImpact);
	if(addressConditions)
	{
		for( var i=0;i<addressConditions.length;i++ )
		{
			conditions.push(addressConditions[i]);
		}
	}
	
	var parcelConditions = getParcelConditions(pType,pStatus,pDesc,pImpact);
	if(parcelConditions)
	{
		for( var i=0;i<parcelConditions.length;i++)
		{
			conditions.push(parcelConditions[i]);
		}
	}
	
	var licenseConditions = getLicenseConditions(pType,pStatus,pDesc,pImpact);
	if(licenseConditions)
	{
		for( var i=0;i<licenseConditions.length;i++)
		{
			conditions.push(licenseConditions[i]);
		}
	}
	
	var contactConditons = getContactConditions(pType,pStatus,pDesc,pImpact);
	if(contactConditons)
	{
		for( var i=0;i<contactConditons.length;i++)
		{
			conditions.push(contactConditons[i]);
		}
	}
	
	return conditions;
} 

