function checkName() {
    var nameVal = $("#name").val();
    console.log(nameVal)
    if (nameVal === '') {
        $("#nameMsg").html("<span style='color: red'>姓名必填<span/>");
        return false;
    } else {
        $("#nameMsg").html("");
        return true;
    }
}

function checkMobile() {
    let mobileVal = $("#mobile").val();
    if (mobileVal.length !== 11 || isNaN(mobileVal)) {
        $("#mobileMsg").html("<span style='color: red'>电话号码必须是11位<span/>");
        return false;
    } else {
        $("#mobileMsg").html("");
        return true;
    }
}

//检查座机
function checkTelphone() {
    let telphoneVal = $("#telphone").val();
    let telIndex = telphoneVal.indexOf("-");
    let beforePart = telphoneVal.substring(0, telIndex);
    let afterPart = telphoneVal.substring(telIndex + 1);
    if (telIndex === -1 || isNaN(beforePart) || isNaN(afterPart) || !(beforePart.length === 3 || beforePart.length === 4) || !(afterPart.length === 7 || afterPart.length === 8)) {
        $("#telphoneMsg").html("<span style='color: red'>座机格式必须是3或4位区号-7号或8位的电话号码</span>");
        return false;
    } else {
        $("#telphoneMsg").html("");
        return true;
    }
}

//检查邮箱
function checkEmail() {
    let emailVal = $("#email").val();
    if (emailVal.indexOf("@") === -1) {
        $("#emailMsg").html("<span style='color: red'>邮箱格式不正确</span>");
        return false;
    } else {
        $("#emailMsg").html("");
        return true;
    }
}

function checkForm() {
    console.log(checkTelphone())
    if (checkMobile() === false | checkName() === false | checkTelphone() === false || checkEmail() === false) {
        return false;
    } else {
        return true;
    }
}