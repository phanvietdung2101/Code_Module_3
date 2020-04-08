<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 08/04/2020
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Result</h1>
<p>
    <%=request.getParameter("first_operand")%>
    <%=request.getParameter("operator")%>
    <%=request.getParameter("second_operand")%>
    =
    <%=request.getAttribute("result")%>
</p>
</body>
</html>
