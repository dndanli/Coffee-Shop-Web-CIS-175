<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View orders placed</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items="${requestScope.allOrders}" var="currentorder">
				<tr>
			 		<td><input type="radio" name="id" value="${currentorder.id}"></td>
		 			<td> Bean Name: ${currentorder.beanName} | </td>
		 			<td>Quantity to order: ${currentorder.quantityToOrder} | </td>
		 			<td>Packages in stock ${currentorder.packagesInStock} | </td>
		 			<td>Supplier: ${currentorder.supplier} | </td>
	 			</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name="doThisToOrder">
		<input type = "submit" value = "delete" name="doThisToOrder">
		<input type="submit" value = "add" name = "doThisToOrder">
	</form>
</body>
</html>