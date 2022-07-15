<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="rightheader">

    <c:choose>
        <c:when test="${sessionScope.user  != null }">
            <p>
                欢迎:${sessionScope.user.realName} <a href="${pageContext.request.contextPath}/user/logout">退出</a>
                <br/>
            </p>
        </c:when>
        <c:otherwise>
            <p>
                还没登录，先去<a href="${pageContext.request.contextPath}/login.jsp">登录</a>吧
                <br/>
            </p>
        </c:otherwise>
    </c:choose>

</div>
<div id="topheader">
    <h1 id="title">
        <a href="#">通讯录管理系统</a>
    </h1>
</div>
<div id="navigation">
</div>