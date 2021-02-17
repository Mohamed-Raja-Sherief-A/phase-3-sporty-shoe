<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Control</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">

</head>
<body>

	 <header>
	  Sporty Shoes<br/>
	  Login Page
	 </header>
	 <div class="container">
		 <form:form action="LoginCheck" modelAttribute="user" method="post"><%--Login credential form --%>
			 <h3>Login Form</h3>
			 Enter username:<form:errors path="username"/> <form:input path="username" cssClass="input"/><br/>
			 Enter password:<form:errors path="password"/> <form:input path="password" cssClass="input"/><br/>
			  <input type="submit" value="submit"/><br/>
		</form:form>
		  <a href="RegistrationShowForm">New User Register here..</a><%--link for new registration --%>
	 </div>
	 <br><br>
	 <%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>