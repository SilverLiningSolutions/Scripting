
function removeFeesBySchedule(feeSch) {
	getFeeResult = aa.fee.getFeeItems(capId);
	if (getFeeResult.getSuccess()) {
		var feeObjArr = getFeeResult.getOutput();
		for (ff in feeObjArr) {
			if (feeObjArr[ff].getFeeitemStatus().equals("NEW") && feeSch.equals(feeObjArr[ff].getF4FeeItemModel().getFeeSchudle()) ) {
				var feeSeq = feeObjArr[ff].getFeeSeqNbr();
				var editResult = aa.finance.removeFeeItem(capId, feeSeq);
			}
		}
	}
}

