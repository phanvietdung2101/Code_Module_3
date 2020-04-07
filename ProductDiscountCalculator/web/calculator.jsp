<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 07/04/2020
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        #content {
            border: 2px solid black;
            margin: 0 auto;
            padding: 0px 20px 20px;
            width: 450px;
        }
    </style>
</head>
<body>
<div id="content">
    <h1>Product Discount Calculator</h1>
    <label>Product Description: </label>
    <%=request.getParameter("description")%>
    <br>
    <label>Price: </label>
    <%=request.getParameter("price")%>
    <br>
    <label>Discount percent: </label>
    <%=request.getParameter("discount_rate")%>
    <br>
    <label>Discount price: </label>
    <%=request.getAttribute("discount_price")%>
</div>

</body>
</html>
