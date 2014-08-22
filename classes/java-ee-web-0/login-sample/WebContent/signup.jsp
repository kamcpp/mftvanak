<%@page import="com.mftvanak.classes.jee.zero.encoding.Encoder"%>
<%@page import="com.mftvanak.classes.jee.zero.encoding.EncoderFactory"%>
<%@page
	import="com.mftvanak.classes.jee.zero.encoding.SerializerFactory"%>
<%@page
	import="com.mftvanak.classes.jee.zero.validation.ValidationResult"%>
<%@page import="com.mftvanak.classes.jee.zero.encoding.Serializer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String errorMessage = request.getParameter("e");
	ValidationResult result = new ValidationResult();
	if (errorMessage != null) {
		Serializer<ValidationResult> serializer = SerializerFactory
				.createForValidationResult();
		Encoder encoder = EncoderFactory.createEncoder();
		result = serializer.deserialize(encoder.decode(errorMessage));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="scripts/main.js"></script>
<style>
.error {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ثبت نام</title>
</head>
<body>
	<form id="signup-form" action="do-signup.jsp" method="post">
		Name <input id="signup-name" type="text" name="name" value="" />
		<%
			if (result.hasErrorForField("name")) {
		%>
		<span class="error"><%=result.getMessage("name")%></span>
		<%
			}
		%>
		<br /> Family <input id='signup-family' type="text" name="family"
			value="" />
		<%
			if (result.hasErrorForField("family")) {
		%>
		<span class="error"><%=result.getMessage("family")%></span>
		<%
			}
		%>
		<br /> Username <input id='signup-username' type="text"
			name="username" value="" /> <br /> Password <input
			type="password" name="password" value="" /> <br /> Password
		Conf. <input type="password" name="passwordConfirmation" value="" /> <br />
	</form>
	<button id='signup-submit'>Create Account</button>
</body>
</html>