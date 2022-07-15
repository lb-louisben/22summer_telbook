<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function checkCateName() {
            let cateNameVal = $("#categoryName").val();
            if (cateNameVal === '') {
                $("#categoryNameMsg").html("<span style='color: red'>请输入一个新分组名字</span>")
                return false
            } else {
                return true;
            }
        }

        function existSame(input, callback) {
            $.get(
                "${pageContext.request.contextPath}/category/queryAllAjax"
                , function (res) { // ajax 异常通信 响应成功正确后 回调函数 res是响应后回来的js数组对象
                    // 遍历数组，往 分组下拉列表中 添加
                    for (let i = 0; i <= res.length; i++) {
                        if (input === res[i].categoryName) {
                            console.log(i + "yes")
                            callback(true);
                        }
                    }
                    callback(false)
                }
                , "json"
            )
        }

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
                        <h1>添加分组</h1>
                        <form onsubmit="return checkCateName()" action="${pageContext.request.contextPath}/category/reg"
                              method="post">
                            新分组的名称：<input id="categoryName" onblur="checkCateName()" name="categoryName"/><span
                                id="categoryNameMsg"></span><br/>
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