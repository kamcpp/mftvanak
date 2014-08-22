<%@page import="com.mftvanak.classes.jee.zero.controllers.SignUpData"%>
<%@page import="com.mftvanak.classes.jee.zero.encoding.EncoderFactory"%>
<%@page import="com.mftvanak.classes.jee.zero.encoding.Encoder"%>
<%@page
	import="com.mftvanak.classes.jee.zero.encoding.SerializerFactory"%>
<%@page import="com.mftvanak.classes.jee.zero.encoding.Serializer"%>
<%@page
	import="com.mftvanak.classes.jee.zero.validation.ValidationResult"%>
<%@page
	import="com.mftvanak.classes.jee.zero.controllers.SignUpControllerFactory"%>
<%@page
	import="com.mftvanak.classes.jee.zero.controllers.SignUpController"%>
<%@page
	import="com.mftvanak.classes.jee.zero.validation.SignUpRequestValidatorFactory"%>
<%@page
	import="com.mftvanak.classes.jee.zero.validation.SignUpRequestValidator"%>
<%@page import="com.mftvanak.classes.jee.zero.controllers.DefaultSignUpData"%>
<jsp:useBean id="signUpData" class="com.mftvanak.classes.jee.zero.controllers.DefaultSignUpData"/>
<jsp:setProperty property="*" name="signUpData" />

<%
	SignUpRequestValidator validator = SignUpRequestValidatorFactory
			.create();
	ValidationResult result = validator.validate(signUpData);

	if (result.hasError()) {
		Encoder encoder = EncoderFactory.createEncoder();
		Serializer<ValidationResult> serializer = SerializerFactory
				.createForValidationResult();

		String encodedValidationResult = encoder.encode(serializer
				.serialize(result));
		response.sendRedirect("signup.jsp?e=" + encodedValidationResult);
		return;
	}

	SignUpController mainControoler = SignUpControllerFactory.create();
	mainControoler.signUp(signUpData);
	response.sendRedirect("login.jsp");
%>