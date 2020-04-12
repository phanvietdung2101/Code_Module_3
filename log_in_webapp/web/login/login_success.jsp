<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 12/04/2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome
<%
    if(session.getAttribute("username") != null){
%>
<p><%=session.getAttribute("username") %></p>
<%} %>
</body>
</html>
