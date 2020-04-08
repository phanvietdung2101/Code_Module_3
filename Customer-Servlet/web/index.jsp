<%@ page import="java.util.ArrayList" %>
<%@ page import="object.Customer" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%
  ArrayList<object.Customer> customers = new ArrayList<>();
  Customer c1 = new Customer("A","21-01-96","HaNoi","imgSrc");
  Customer c2 = new Customer("B","21-01-96","HaNoi","imgSrc");
  Customer c3 = new Customer("C","21-01-96","HaNoi","imgSrc");
  Customer c4 = new Customer("D","21-01-96","HaNoi","imgSrc");
  customers.add(c1);
  customers.add(c2);
  customers.add(c3);
  customers.add(c4);
%>
<c:set var="customer" scope="session" value="<%=customers%>"></c:set>
  <table>
  <tr>
  <th>Tên</th>
  <th>Ngày sinh</th>
  <th>Địa chỉ</th>
  <th>Ảnh</th>
  </tr>
  <c:forEach var="i" begin="0" end="${customer.size()-1}">
    <tr>
      <td><c:out value="${customer.get(i).name}"></c:out></td>
      <td><c:out value="${customer.get(i).bod}"></c:out></td>
      <td><c:out value="${customer.get(i).address}"></c:out></td>
      <td><c:out value="${customer.get(i).picture}"></c:out></td>
    </tr>
  </c:forEach>
  </table>
  </body>
</html>
