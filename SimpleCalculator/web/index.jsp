<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="/index" method="get">
  <fieldset>
    <legend>Calculator</legend>
    <label>First operand: </label>
    <input type="text" name="first_operand">
    <br>
    <label>Operator: </label>
    <select name="operator">
      <option>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
    </select>
    <br>
    <label>Second operand: </label>
    <input type="text" name="second_operand">
    <br>
    <button type="submit">Calculate</button>
  </fieldset>
</form>
</body>
</html>
