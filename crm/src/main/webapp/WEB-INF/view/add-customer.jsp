<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<h2></h2>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Web Application</h2>
		</div>
	</div>
	<div id="container">
		<form:form action="processForm" method="post"
			modelAttribute="customer">
			<form:hidden path="custId"/>
			<table>
				<tbody>
					<tr>
						<td><label>Firstname</label></td>
						<td><form:input path="custFirstname" /></td>
					</tr>
					<tr>
						<td><label>Lastname</label></td>
						<td><form:input path="custLastname" /></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="custEmail" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/customer/fetchCustomers">back
			to list</a>
	</div>
</body>
</html>