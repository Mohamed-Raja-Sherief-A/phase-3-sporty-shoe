<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.demo.model.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/cart.css">
</head>
<body>
<header><h1>Order Summary</h1></header>
<div class="container">
<%

List<Order>orders=(List<Order>) request.getAttribute("orders");


for(Order order:orders)
{
	SimpleDateFormat formatter=new SimpleDateFormat(
		      "dd/MM/yyyy");
	out.print("<div class='subcontainer'>");
	out.print("Date:"+formatter.format(order.getDateofpurchase())+"   Product:"+order.getProduct().getName()+"   Category:"+order.getProduct().getCategory());
	out.print("</div>");
}
%>

</div>
<br><br>
<a href="UserForm" class="back">Back</a>
<br><br>
<%String message=(String)request.getAttribute("message");
		if(message!=null){out.println(message);}		  
				  
				  %>
</body>
</html>