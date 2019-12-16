<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	<h4>
		This student is confirmed: ${student.firstName} ${student.lastName} <br> <hr> 
		Country: ${student.country} <br> <hr>
		Favourite Language: ${student.favouriteLanguage } <br> <hr> 
		Operating Systems: <br>
		<C:forEach var="temp" items="${student.operatingSystems }">
			<li>${temp}</li>
		</C:forEach>
	</h4>
</body>
</html>