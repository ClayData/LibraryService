<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book</title>
</head>
<body>
<form action="bookdel" method="post">
		<input type="submit" name="logout2" value="Log Out"/>
	</form>
	<%String user = request.getParameter("name");
	out.print(user);
	session.setAttribute("libname", user);
	%>
	<form action="book" method="post">
	Enter Book Title:<input type="text" name="addtitle"/><br />
	Enter Author Name:<input type="text" name="author" /><br />
	<input type="submit" value="submit" />
	</form>
	<br/>
	<a href="bookdel.jsp">Delete Books</a>
	<a href="bookcheck.jsp">Check In/Out Books</a>
</body>
</html>