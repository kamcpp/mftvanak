<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mytags" uri="WEB-INF/mytags.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="helloWorldForm"
	class="example.web.forms.HelloWorldForm" />
<jsp:setProperty property="*" name="helloWorldForm" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<mytags:sayHello />
	<mytags:sayHello to="Teacher" />

	<c:forEach var="i" begin="1" end="10">
		<mytags:sayHello to="xyz" />
		<h1>
			<c:out value="${helloWolrForm.to}" />
		</h1>
	</c:forEach>

	<c:forEach var="i" begin="1" end="10">
		<%
			out.write("Bye.");
		%>
	</c:forEach>
</body>
</html>
