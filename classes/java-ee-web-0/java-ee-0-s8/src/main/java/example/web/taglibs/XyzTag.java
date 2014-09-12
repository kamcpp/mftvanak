package example.web.taglibs;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.tag.rt.core.ForEachTag;

public class XyzTag extends ForEachTag {

	@Override
	public int doStartTag() throws JspException {
		System.out.println("Hello ...");
		return super.doStartTag();
	}
}
