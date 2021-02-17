
<%@page import="com.demo.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product view</title>
<link rel="stylesheet" type="text/css" href="resources/css/ProductView.css">
</head>
<body>
<header><h1>Product View</h1></header>
<div class="container">
<%
	ArrayList<Product> products=(ArrayList<Product>)request.getAttribute("products");//Gets Products from request object
for(Product product:products)
{
	out.print("<div class='subcontainer'>");
	out.print("<span style='font-weight:Bold'>ProductName: </span>"+product.getName());
	out.print("<br> <br>");
	out.print("<span style='font-weight:Bold'>Product Category: </span>"+product.getCategory());		
	out.print("<br> <br>");
	out.print("<span style='font-weight:Bold'>Product Amount: </span>"+product.getAmount());		
	out.print("<br> <br>");
	out.print("<span style='font-weight:Bold'>Product Status: </span>"+product.getStatus());
	out.print("<br>");
	out.print("<a href='ProductUpdate?id="+product.getPid()+"&status=Active' class='enable'>Enable</a>");
	out.print("<a href='ProductUpdate?id="+product.getPid()+"&status=Inactive' class='disable'>Disable</a>");
	out.print("</div>");
}
%>
</div>
<br>
<a href="showProductMenu">Back</a>
<br><br>
 <%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>