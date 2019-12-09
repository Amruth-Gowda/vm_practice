<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Page</title>
</head>
<body>
	<h3>Student Registration Page</h3>
	<br>
	<hr>
	<form:form action="processForm" modelAttribute="student">
		Firstname: <form:input path="firstName" />
		<br>
		<br>
		Lastname: <form:input path="lastName" />
		<br>
		<br>
		Country: <form:select path="country">
			<form:options items="${student.countryList}" />
		</form:select>
		<br>
		<br>
		Favourite Language: <br> 
		Java <form:radiobutton path="favouriteLanguage" value="Java" /> 
		C <form:radiobutton path="favouriteLanguage" value="C" /> 
		C++ <form:radiobutton path="favouriteLanguage" value="C++" /> 
		C# <form:radiobutton path="favouriteLanguage" value="C#" /> 
		Python <form:radiobutton path="favouriteLanguage" value="Python" />
		<br>
		Favourite Operating Systems: Linux <form:checkbox
			path="operatingSystems" value="linux" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		Ubuntu <form:checkbox path="operatingSystems" value="Ubuntu" />
		<br>
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>