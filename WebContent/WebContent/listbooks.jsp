<!DOCTYPE HTML>
<%@page import="com.revature.com.UserClass"%>
<%@page import="com.revature.com.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.com.BookDao"%>


<html>
	<head>
		<title>List Books</title>
		</head>
		<body>
		<%UserClass user =(UserClass)session.getAttribute("Logged_in_user");
		%>
		welcome<%=user.getName()
		%>
		</body>
		<%
			BookDao bookDAo=new BookDao();
			List<Book>bookList=bookDAo.listBooks();
			//out.println("Book:"+bookList);
		%>
		<table border="1">
		<thead>
		<tr><th>Id</th><th>Name</th><th>Price</th><th>Published date</th></tr>
		</thead>
	</head>
	<%
		for(Book b:bookList){
			out.println("<tr>");
			out.println("<td>"+b.getId()+"</td>");
			out.println("<td>"+b.getName()+"</td>");
			out.println("<td>"+b.getPrice()+"</td>");
			out.println("<td>"+b.getDate()+"</td>");
			out.println("<tr>");
		}
	%>
	<body>
		<h3>List Books</h3>
		
<!-- <tbody>
		<tr>
		<td>1</td>
		<td>Core_java</td>
		<td>Rs.200</td>
		<td>2017-04-20</td>
		</tr>
<tr>
		<td>2</td>
		<td>My_sql</td>
		<td>Rs.300</td>
		<td>2017-06-14</td>
		</tr>
</tbody>
</table>
 -->	</body>
	
	
</html>