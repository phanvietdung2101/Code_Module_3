<html>
<head>
  <title>$Title$</title>
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
  <div id="data">
    <form method="post" action="/calculator">
      <label>Product Description: </label>
      <br>
      <input name="description">
      <br>
      <label>Price: </label>
      <br>
      <input name="price">
      <br>
      <label>Discount Rate: </label>
      <br>
      <input name="discount_rate">
      <br>
      <button type="submit">Calculate</button>
    </form>
  </div>
</div>
</body>
</html>
