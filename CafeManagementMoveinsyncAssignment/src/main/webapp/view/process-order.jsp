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
	<h3>
		Hii <span style="color: green">${orderInfo.userName}</span> Your Order
		has been placed at <span style="color: orange">${orderInfo.time}</span>
		your Order id is : <span style="color: red">${orderInfo.orderid}</span>
		It will take <span style="color: green">${time} Minutes</span> to
		prepare
	</h3>
	<h3>Items :</h3>
	<ul>
		<c:forEach var="h" items="${orderInfo.items}">
			<li>${h}</li>
		</c:forEach>
	</ul>
</body>
</html>