<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>
<header>
Registration Page
</header>
    <div class="container">
		<form:form action="RegistrationAdd" modelAttribute="user" method="post">
			Enter username:<form:errors path="username" cssClass="error"/><form:input path="username"/><br/>
			Enter password:<form:errors path="password" cssClass="error"/><form:input path="password"/><br/>
			<input type="submit" value="submit"/><br/>
		</form:form>
    <a href="Registrationback">back</a><br/>
    </div>
    <br><br>
    <%
    String message=(String)request.getAttribute("message");
    if(message!=null)
    {
    out.println(message);
    }
    %>
</body>
</html>