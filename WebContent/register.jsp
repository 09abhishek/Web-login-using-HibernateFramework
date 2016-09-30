<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
</head>
<body>
	<h1>register Here</h1>
	<form action="login.do" method="post">
AnyId<input type="text" name="uid">	
Username<input type="text" name="uname">
Passsword<input type="password" name="upass">

<input type="hidden" name="id" value="register">

<input type="submit" value="submit">
	</form>
</body>
</html>