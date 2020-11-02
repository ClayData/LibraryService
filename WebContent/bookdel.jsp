<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Delete</title>
</head>
<body>
	<button><a href="login.jsp">Log Out</a></button>
	<% String user = (String)session.getAttribute("libname");
	out.print(user);
	%>
	<form action="bookdel" method="post">
	Enter Book Title:<input type="text" name="deltitle"/><br />
	<input type="submit" value="submit" />
	</form>
	<br/>
	<a href="book.jsp">Add Books</a>
</body>
</html>