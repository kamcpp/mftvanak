<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>صفحه ورود</title>
</head>
<body>
	<a href="signup.jsp">Create an account</a>
	<%
		if (request.getParameter("e") != null) {
	%>
	<h6 style='color: red;'>Username or password is wrong!</h6>
	<%
		}
	%>
	<form action="do-login.jsp" method="post">
		Username <input type="text" name="username" value="" /> <br />
		Password <input type="password" name="password" value="" /> <br />
		<input type="submit" value="ورود" />
	</form>
</body>
</html>