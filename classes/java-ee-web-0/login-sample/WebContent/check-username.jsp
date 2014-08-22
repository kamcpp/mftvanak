<%@page import="com.mftvanak.classes.jee.zero.dao.UserDaoFactory"%>
<%@page import="com.mftvanak.classes.jee.zero.dao.UserDao"%>
<%@ page language="java"
	contentType="application/json; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String username = request.getParameter("u");
	if (username == null) {
		out.print("{\"result\": \"error\", \"message\": \"Username is not provided.\"}");
		return;
	}
		
	UserDao userDao = UserDaoFactory.createSingleton();
	boolean exists = userDao.getUserByUsername(username) != null;
	
	if(exists) {
		out.print("{\"result\": \"yes\", \"message\": \"Username exists.\"}");
	} else {
		out.print("{\"result\": \"no\", \"message\": \"Username does not exist.\"}");
	}
%>