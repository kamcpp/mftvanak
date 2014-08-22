<%@page import="com.mftvanak.classes.jee.zero.controllers.LoginData"%>
<%@page
	import="com.mftvanak.classes.jee.zero.controllers.LoginControllerFactory"%>
<%@page
	import="com.mftvanak.classes.jee.zero.controllers.LoginController"%>
<%@page
	import="com.mftvanak.classes.jee.zero.controllers.DefaultLoginData"%>
<jsp:useBean id="loginData"
	class="com.mftvanak.classes.jee.zero.controllers.DefaultLoginData" />
<jsp:setProperty property="*" name="loginData" />
<%
	LoginController loginController = LoginControllerFactory.create();
	boolean result = loginController.login(loginData);

	if (result) {
		session.setAttribute("user", loginData.getUsername());
		response.sendRedirect("home.jsp");
	} else {
		response.sendRedirect("login.jsp?e=1");
	}
%>