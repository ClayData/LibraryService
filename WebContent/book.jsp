<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addbook" method="post">
	Enter Book Title:<input type="text" name="addtitle"/><br />
	Enter Author Name:<input type="text" name="author" /><br />
	<input type="submit" value="submit" />
	</form>
	<br/>
	<form action="deletebook" method="post">
	Enter Title of Book to be deleted:<input type="text" name="deltitle" />
	<input type="submit" value="submit" />
	</form>
	
</body>
</html>