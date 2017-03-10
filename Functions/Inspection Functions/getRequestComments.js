
function getRequestComments(fromId) {
	
	itemCap = capId;
    var inspResultObj = aa.inspection.getInspection(itemCap, fromId);
    if (inspResultObj.getSuccess()) {
            var inspObj = inspResultObj.getOutput();
            inspModel = inspObj.getInspection();
            if (inspModel != null) {
            	reqCommentModel = inspModel.getRequestComment();
            	if (reqCommentModel != null) {
            		return reqCommentModel.getText();
            	}		
            }
    }	
}

