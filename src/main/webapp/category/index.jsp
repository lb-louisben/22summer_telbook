<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function delConfirm(id) {
            if (confirm("确定删除联系人吗？")){
                location.href = "${pageContext.request.contextPath}/person/delete/?id=" + id;
            }
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
                        <h1>分组管理</h1>
                        <a href="add.jsp">添加分组</a>
                        <table class="table" style="background: url(../img/tableheader-bg.gif) no-repeat left top;">
                            <tr class="table_header">
                                <td>id</td>
                                <td>分类</td>
                            </tr>
                            <c:forEach items="${requestScope.list}" var="cate">
                                <tr class="row1">
                                    <td>${cate.categoryId}</td>
                                    <td>${cate.categoryName}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%--当前第${requestScope.currentPage}页 共${requestScope.totalPage}页
                        <c:if test="${requestScope.currentPage <= 1}">
                            首页 上页
                        </c:if>
                        <c:if test="${requestScope.currentPage > 1}">
                            <a href="${pageContext.request.contextPath}/person/queryByPage?currentPage=1">首页</a>
                            <a href="${pageContext.request.contextPath}/person/queryByPage?currentPage=${requestScope.currentPage - 1}">上页</a>
                        </c:if>

                        <c:if test="${requestScope.currentPage == requestScope.totalPage}">
                            下页 尾页
                        </c:if>
                        <c:if test="${requestScope.currentPage < requestScope.totalPage}">
                            <a href="${pageContext.request.contextPath}/person/queryByPage?currentPage=${requestScope.currentPage+1}">下页</a>
                            <a href="${pageContext.request.contextPath}/person/queryByPage?currentPage=${requestScope.totalPage}">尾页</a>
                        </c:if>--%>
                    </td>
                </tr>
            </table>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
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