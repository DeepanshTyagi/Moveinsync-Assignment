<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Processed</title>
</head>
<body>
	<div align="center">
		<h1>MoveInSync Cafee</h1>
		<hr>
	</div>
	<h3>Order id ${orderid} has Prepared</h3>
	<h2>Want to place another order</h2>
	<form action="waiter" method="post">
		<input type="submit" value="Place Order">
	</form>
</body>
</html>