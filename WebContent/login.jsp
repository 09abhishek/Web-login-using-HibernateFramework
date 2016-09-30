<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="logout.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<%@taglib uri="/WEB-INF/mytaglib.tld" prefix="servion" %>

</head>
<body>
<form action="login.do" method="post">
<servion:getText key="username"/><input type="text" name="uname">
<servion:getText key="password"/><input type="password" name="upass">
<input type="hidden" name="id" value="login">
<input type="submit" value="login">
</form>
</body>
</html>