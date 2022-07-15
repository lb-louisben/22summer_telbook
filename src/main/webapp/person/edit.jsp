<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
    <script type="text/javascript">
        $(function () {
            $.get(
                "${pageContext.request.contextPath}/category/queryAllAjax"
                , function (res) {
                    for (let i = 0; i < res.length; i++) {
                        // 判断是否是当前联系人所选择的
                        if (${requestScope.person.category.categoryId} === res[i].categoryId) {
                            $("#selCategory").append("<option value=" + res[i].categoryId + " selected>" + res[i].categoryName + "</option>");
                        } else {
                            $("#selCategory").append("<option value=" + res[i].categoryId + ">" + res[i].categoryName + "</option>");
                        }
                    }
                }
                , "json")
        })
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <jsp:include page="/main/head.jsp"></jsp:include>
        </div>
        <div id="content">
            <table border="0" width="100%">
                <tr>
                    <td width="15%" valign="top">
                        <p id="whereami"></p>
                        <jsp:include page="/main/menu.jsp"></jsp:include>
                    </td>
                    <td>
                        <p id="whereami"></p>
                        <h1>修改联系人</h1>
                        <form onsubmit="return checkForm()" action="${pageContext.request.contextPath}/person/modifySave" method="post">
                            <input type="hidden" name="id" value="${requestScope.person.id}">
                            姓名：<input id="name" onblur="checkName()" name="name" value="${requestScope.person.name}"/><span id="nameMsg"></span><br/>
                            手机：<input id="mobile" onblur="checkMobile()" name="mobile" value="${requestScope.person.mobile}"/><span id="mobileMsg"></span><br/>
                            座机：<input id="telphone" onblur="checkTelphone()" name="telphone" value="${requestScope.person.telphone}"/><span id="telphoneMsg"></span><br/>
                            邮箱：<input id="email" onblur="checkEmail()" name="email" value="${requestScope.person.email}"/><span id="emailMsg"></span><br/>
                            城市：<input name="city" value="${requestScope.person.city}"/><br/>
                            生日：<input name="birthday"
                                      value="<fmt:formatDate value='${requestScope.person.birthday}' pattern='yyyy-MM-dd'/>"/>
                            <br/>
                            分组：<select name="category.categoryId" id="selCategory"></select><br/><br/>
                            <input type="submit" value="修改"/>
                            <input type="reset" value="重置"/>
                        </form>
                    </td>
                </tr>
            </table>

        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>