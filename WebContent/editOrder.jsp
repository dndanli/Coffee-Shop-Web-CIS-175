<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an order</title>
</head>
<body>
	<form action = "editOrderServlet" method="post">
		Coffee Bean: <input type ="text" name = "beanName" value="${orderToEdit.beanName}">
		Quantity: <input type = "text" name = "orderQuantity" value= "${orderToEdit.quantityToOrder}">
		Packages in Stock: <input type = "text" name = "packagesStock" value= "${orderToEdit.packagesInStock}">
		Supplier Name: <input type = "text" name = "supplierName" value= "${orderToEdit.supplier}">
		<input type = "hidden" name = "id" value="${orderToEdit.id}">
		<input type = "submit" value="Save Edited order">
	</form>
</body>
</html>