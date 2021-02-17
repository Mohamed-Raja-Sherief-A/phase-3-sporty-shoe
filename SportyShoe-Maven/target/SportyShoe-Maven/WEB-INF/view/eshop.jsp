<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.demo.model.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E Shop</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/eshop.css">
</head>
<body>
<header><h1>Sporty Shoe E-shop</h1></header>
<div class="mainheader">
<a href="LogOut" class="logout">Log Out</a>
<a href="CheckCart" class="checkout">Cart</a>
</div>
<div class="container">
<%
	ArrayList<Product> products=(ArrayList<Product>)request.getAttribute("products");
for(Product product:products)
{
	if(product.getStatus().equals("Active"))
	{
	out.print("<div class='subcontainer'>");
	
	out.print("<span style='font-weight:Bold'>ProductName: </span>"+product.getName());
	out.print("<br> <br>");
	out.print("<span style='font-weight:Bold'>Product Category: </span>"+product.getCategory());
	out.print("<br> <br>");
	out.print("<a href='AddToCart?id="+product.getPid()+"' class='cart'>Add to Cart</a>");
	out.print("</div>");
	}
}
%>
</div>
<br><br>
 <%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>