<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Manager</title>
<link rel="stylesheet" type="text/css" href="resources/css/registration.css">
</head>
<body>

	<header><h1>Change Password</h1></header>
	<div class="container">
		<form:form action="ChangePassword" modelAttribute="user"  method="post">
			Enter New Password:<form:errors path="password"/><form:input path="password"/>
			<input type="submit" value="Change"/><br/>
		</form:form>
		<a href="ShowMainMenu">Back</a><br/>
	</div>
	<br><br>
	<%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>