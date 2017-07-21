<%@page import="com.revature.com.UserClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Order Books</h2>
<form action="OrderServlet">
<%		UserClass user =(UserClass)session.getAttribute("Logged_in_user");
 %>
 welcome<%=user.getName() %>
 
User id:<input type="text" name="userid" value="<%=user.getId() %>"autofocus required></br>
Select book;
<select name="bookid"required></br>
<option value="1">c</option>
<option value="2">c++</option>
</select>
</br>
Quantity:<input type="number" name="quantity"required>
<button type="submit">submit</button>
</form>


</body>
</html>