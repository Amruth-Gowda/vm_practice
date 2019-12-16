<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	<h2>Customer Web Application</h2> <br>
	<table>
		<tr>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
		</tr>
		<C:forEach var="tempCustomer" items="${customers}">
		<tr>
			<td>${tempCustomer.custFirstname}</td>
			<td>${tempCustomer.custLastname}</td>
			<td>${tempCustomer.custEmail}</td>
		</tr>
		</C:forEach>
	</table>
</body>
</html>