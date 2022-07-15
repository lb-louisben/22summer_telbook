<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        // 发 Ajax 请求，所有分组的信息
        $(function () {
            $.get(
                "${pageContext.request.contextPath}/cate/queryAllAjax"
                , function (res) { // ajax 异常通信 响应成功正确后 回调函数 res是响应后回来的js数组对象
                    // 遍历数组，往 分组下拉列表中 添加
                    for (let i = 0; i <= res.length; i++) {
                        // res[i].categoryId    res[i].categoryName
                        $("#selCategory").append("<option value='" + res[i].categoryId + "'>" + res[i].categoryName + "</option>")
                    }
                }
                , "json"
            )
        });
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
                        <h1>添加联系人</h1>
                        <form action="${pageContext.request.contextPath}/person/register" method="post">
                            姓名：<input name="name"/><br/>
                            手机：<input name="mobile"/><br/>
                            座机：<input name="telphone"/><br/>
                            邮箱：<input name="email"/><br/>
                            城市：<input name="city"/><br/>
                            生日：<input type="date" name="birthday"/><br/>
                            分组：<select name="category.categoryId" id="selCategory"></select><br/><br/>
                            <input type="submit" value="添加"/>
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