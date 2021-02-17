<%@page import="com.demo.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link rel="stylesheet" type="text/css" href="resources/css/cart.css"><!-- css call -->
</head>
<body>
<header><h1>Cart</h1></header>
<div class="container">
<%
ArrayList<Product> products=(ArrayList<Product>)session.getAttribute("cart");//Cart call from session
for(Product product:products)
{
	out.print("<div class='subcontainer'>");
	out.print("Product:"+product.getName()+" Category:"+product.getCategory()+"   <a href='DeleteCart?id="+product.getPid()+"'class='delete'>Delete</a>");
	out.print("</div>");
}
%>
</div>
<br><br>
<a href="CheckOut" class="checkout">CheckOut</a><br><br>
<a href="Eshop" class="back">Back</a>
<br><br>
<%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>