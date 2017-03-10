function scheduleAllPendingInspections(daysAhead) 
{

	if ( arguments.length == 2 )
	{
		itemCap = arguments[1];
	} else {
		var itemCap = capId;
	}
        var inspResultObj = aa.inspection.getInspections(itemCap);
        if (inspResultObj.getSuccess()) {
                var inspList = inspResultObj.getOutput();
                for (xx in inspList) {
                        inspObj = inspList[xx];
                        if (inspObj.getDocumentDescription().equals("Insp Pending") && inspObj.getAuditStatus().equals("A") ) {
                                inspModel = inspObj.getInspection();
                                actModel = inspModel.getActivity();
				if ( actModel.getRequiredInspection().equals("Y") ) {
                                	if (daysAhead == null || daysAhead == "")
                                   	     actModel.setActivityDate(aa.util.now());   
                                	else {
                                  	   	newDate = dateAdd(null, parseInt(daysAhead));
                                    	  	newAADate = aa.util.parseDate(newDate);
                               	   		actModel.setActivityDate(newAADate);
                                	}
                                	inspModel.setActivity(actModel);
                                	systemUserObj = aa.person.getUser("ADMIN").getOutput();  
                                	aa.inspection.scheduleInspection(inspModel, systemUserObj);
				}
                        }
                }
        }
}
