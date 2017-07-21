<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


	<title>Book add</title>
	</head>
	<body>
<form action="AddBookservlet">
Name:<input type="text"name="name"required autofocus>
Price:<input type="number"name="price"required>
PublishedDate:<input type="date"name="publisheddate" required>
<button type="submit">Book add</button>


</form>






</body>
</html>