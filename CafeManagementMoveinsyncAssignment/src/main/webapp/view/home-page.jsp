<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.quantity_box {
	margin-left: 20px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Welcome in MoveInsync Cafe</h1>
		<hr>
		<form action="processorder" method="post">
			<table cellpadding="8px">
				<tr>
					<td><label for="name">Name :</label></td>
					<td><input type="text" name="userName" id="name" /></td>
				</tr>
				<tr>
					<td><label for="item">Items :</label></td>
					<td><input type="checkbox" id="c1" name="items"
						value="Sandwich"
						onmousedown="this.form.text1.disabled=this.checked" /> Sandwich <input
						type="text" id="text1" name="sandwich_Quantity"
						placeholder="Quantity" style="margin-left: 20px" required disabled />
						<br>
					<input type="checkbox" name="items" value="Coffee"
						onmousedown="this.form.text2.disabled=this.checked" /> Coffee <input
						type="text" id="text2" name="coffee_Quantity"
						placeholder="Quantity" style="margin-left: 40px" required disabled>
						<br>
					<input type="checkbox" name="items" value="Cereal"
						onmousedown="this.form.text3.disabled=this.checked" /> Cereal <input
						type="text" id="text3" name="cereal_Quantity"
						placeholder="Quantity" style="margin-left: 40px" required disabled>
						<br>
					<input type="checkbox" name="items" value="Pizza"
						onmousedown="this.form.text4.disabled=this.checked" /> Pizza <input
						type="text" id="text4" name="Pizza_Quantity"
						style="margin-left: 50px" placeholder="Quantity" required disabled>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Order Now" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>