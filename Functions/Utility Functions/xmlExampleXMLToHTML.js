function xmlEscapeXMLToHTML(xmlData) {
    /*************************************************************************************
    Function:       xmlEscapeXMLToHTML

    author:         xwisdom@yahoo.com

    description:
        Encodes XML data for use in a web page

    ************************************************************************************/
    var gt;

    var str = xmlData;

    //replace & with &
    gt = -1;
    while (str.indexOf("&", gt + 1) > -1) {
        var gt = str.indexOf("&", gt + 1);
        var newStr = str.substr(0, gt);
        newStr += "&";
        newStr = newStr + str.substr(gt + 1, str.length);
        str = newStr;
    }

    //replace < with <
    gt = -1;
    while (str.indexOf("<", gt + 1) > -1) {
        var gt = str.indexOf("<", gt + 1);
        var newStr = str.substr(0, gt);
        newStr += "<";
        newStr = newStr + str.substr(gt + 1, str.length);
        str = newStr;
    }

    //replace > with >
    gt = -1;
    while (str.indexOf(">", gt + 1) > -1) {
        var gt = str.indexOf(">", gt + 1);
        var newStr = str.substr(0, gt);
        newStr += ">";
        newStr = newStr + str.substr(gt + 1, str.length);
        str = newStr;
    }

    //replace \n with <br>
    gt = -1;
    while (str.indexOf("\n", gt + 1) > -1) {
        var gt = str.indexOf("\n", gt + 1);
        var newStr = str.substr(0, gt);
        newStr += "<br>";
        newStr = newStr + str.substr(gt + 1, str.length);
        str = newStr;
    }

    return str

}  // end function xmlEscapeXMLToHTML


