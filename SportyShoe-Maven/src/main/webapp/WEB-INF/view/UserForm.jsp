<%@page import="com.demo.model.UserCredentials"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Generator</title>

<link rel="stylesheet" type="text/css" href="resources/css/assign.css">

</head>
<body>
<%--session management 
<%
	String user=(String)session.getAttribute("user");
	if(user==null)
	{%>
	<jsp:forward page="index.jsp"></jsp:forward>	
	<%}
	%>--%>
<header><h1>Report Generator</h1></header>
	<div class="container">
	<form action="ReportGenerator" method="post">
		Select User:<select name="userid">
		<option value="current">Select</option>
		<%--Display all Users --%>
		<%	
		
		ArrayList<UserCredentials>users=(ArrayList<UserCredentials>)request.getAttribute("users");
		for(UserCredentials user:users)
		{
			if(!user.getUsername().equals("Admin"))
			{
			out.print("<option value="+user.getUid()+">"+user.getUsername()+"</option>");
			}
		}
		%>
		</select><br/>
		<input type="submit" value="Search"/><br/>
	</form>
	<a class="delete" href="ShowMainMenu">Back</a><br/>
	</div>
	<br><br>
		<%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  %>
</body>
</html>