<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<h2></h2>
	<div id="wrapper">
		<div id="header">
			<h2>Kalinga Web Application</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<!-- button to add customers -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormToAdd'; return false; "
				class="add-customer" />
			<table>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<C:forEach var="tempCustomer" items="${customers}">
					<!-- update link for the customer -->
					<C:url var="updateCustomerLink" value="/customer/showUpdateForm">
						<C:param name="customerId" value="${tempCustomer.custId}"></C:param>
					</C:url>
					<!-- delete link for the customer -->
					<C:url var="deleteCustomerLink" value="/customer/delete">
						<C:param name="customerId" value="${tempCustomer.custId}"></C:param>
					</C:url>
					<tr>
						<td>${tempCustomer.custFirstname}</td>
						<td>${tempCustomer.custLastname}</td>
						<td>${tempCustomer.custEmail}</td>
						<td><a href="${updateCustomerLink}">Update</a>| <a
							href="${deleteCustomerLink}" onclick="if(!(confirm('Are you sure you want to delete this user?'))) return false;">Delete</a></td>
					</tr>
				</C:forEach>
			</table>
		</div>
	</div>
	<div id="container">
		<a href="${pageContext.request.contextPath}">back to home</a>
	</div>
</body>
</html>