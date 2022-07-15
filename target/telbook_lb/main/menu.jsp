<%@ page pageEncoding="UTF-8" %>

<table>
    <tr>
        <td><a href="${pageContext.request.contextPath}/main/main.jsp">回首页</a></td>
    </tr>
    <tr>
        <%--<td><a href="${pageContext.request.contextPath}/person/queryAll">联系人管理</a></td>--%>
        <td><a href="${pageContext.request.contextPath}/person/queryByPage?currentPage=1">联系人管理</a></td>
    </tr>
    <tr>
        <td><a href="${pageContext.request.contextPath}/category/queryAll">分组管理</a></td>
    </tr>
    <tr>
        <td><a href="#">用户中心</a></td>
    </tr>
</table>