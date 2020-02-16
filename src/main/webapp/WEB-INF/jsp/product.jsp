<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

<link rel="stylesheet" href="../css/view.css"/>

<title>
Bala Chandran
</title>
</head>

<body>

<div id="header">

<h2>PRODUCT DETAILS</h2>

</div>

<div>

<form method="POST" action="product/insert">
<input type="submit" name="Insert">
</form>

<form action="product/delete">
<input type="submit">
</form>

</div>

<div>
<label for="products">Group By:</label>

<select id="products">
  <option value="name">Name</option>
  <option value="brand">Brand</option>
  <option value="size">Size</option>
  <option value="seller">Seller</option>
</select>
</div>


<div id="tableDetails">

<table>

<tr>
<th>Name</th>
<th>Brand</th>
<th>Size</th>
<th>Seller</th>
</tr>

<c:forEach var= "tempDetails" items="${productDetails}">

<tr>
<td> ${tempDetails.name}</td>
<td> ${tempDetails.brand}</td>
<td> ${tempDetails.size}</td>
<td> ${tempDetails.seller}</td>
</tr>

</c:forEach>

</table>

</div>



</body>

</html>