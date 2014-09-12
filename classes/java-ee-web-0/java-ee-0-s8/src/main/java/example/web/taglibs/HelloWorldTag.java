package example.web.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import example.web.forms.HelloWorldForm;

public class HelloWorldTag extends SimpleTagSupport {

	private String to;

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String localTo = "NONE";
		HelloWorldForm form = (HelloWorldForm) getJspContext().getAttribute(
				"helloWorldForm");
		if (form.getTo() != null) {
			localTo = form.getTo();
		}
		if (to != null) {
			localTo = to;
		}
		getJspContext().getOut().write("<h1>Hello World " + localTo + "</h1>");
	}
}
