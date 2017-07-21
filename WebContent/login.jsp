<!DOCTYPE HTML>
<html>
<head>
	<title>Bookapp_register</title>
</head>
<body>

	<h3>BookApplication</h3>
	<h3>Login</h3>
<form action="LoginServlet">
<%String errormessage=(String)request.getAttribute("errormessage");
if(errormessage!=null);
{
out.println(errormessage);
}
%>
Email:<input type="email"name="email"required autofocus>
PassWord:<input type="password"name="password"required>
<button type="submit">login</button>
</form>
<a href="register.html">create account</a>
</body>
</html>