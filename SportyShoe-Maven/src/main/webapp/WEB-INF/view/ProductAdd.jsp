<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Manager</title>
<link rel="stylesheet" type="text/css" href="resources/css/registration.css">
</head>
<body>

	<header><h1>Add Products</h1></header>
	<div class="container">
		<form:form action="ProductAdd" modelAttribute="product"  method="post">
			Enter Product Name:<form:errors path="name"/><form:input path="name"/>
			Enter Category Name:<form:select path="category">
			<form:option value="Shirt">Shirt</form:option>
			<form:option value="Shoe">Shoe</form:option>
			<form:option value="Sandals">Sandals</form:option>
			<form:option value="Tshirt">Tshirt</form:option>
			<form:option value="Sports Item">Sports Item</form:option>
			</form:select>
			Enter Product Amount:<form:errors path="amount"/><form:input path="amount"/>
			<input type="submit" value="Add"/><br/>
		</form:form>
		<a href="showProductMenu">Back</a><br/>
	</div>
	<br><br>
	<%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>