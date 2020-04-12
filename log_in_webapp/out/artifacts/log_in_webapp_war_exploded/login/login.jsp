<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 12/04/2020
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post">
    Username :
    <input name="username" type="text"><br>
    Password :
    <input name="password" type="password"><br>
    <button type="submit">Login</button>
</form>
<c:if test="${requestScope['msg'] != null}">
    <span>${requestScope['msg']}</span>
</c:if>
</body>
</html>
