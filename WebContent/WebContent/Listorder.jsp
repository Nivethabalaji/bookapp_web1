<%@page import="com.revature.com.BookOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.com.BookorderDAo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Order</title>
</head>
<body>



		<title>List Books</title>
		<%
			BookorderDAo bookDAo=new BookorderDAo();
			List<BookOrder>orderList=bookDAo.login();
			out.println("BookOrder:"+orderList);
		%>
		<table border="1">
		<thead>
		<tr><th>Id</th><th>UserClassId</th><th>status</th><th>quantity</th></tr>
		</thead>
		<tbody>
			<%
		for(BookOrder b:orderList){
			out.println("<tr>");
			out.println("<td>"+b.getUserClassId()+"</td>");
			out.println("<td>"+b.getBookId ()+"</td>");
			out.println("<td>"+b.getQuantity()+"</td>");
			//out.println("<td>"+b.getOrderDate()+"</td>");
			out.println("<td>"+b.getStatus()+"</td>");
			out.println("<tr>");
		}
			
	%>
		</tbody>
	

	<body>
	


</html>