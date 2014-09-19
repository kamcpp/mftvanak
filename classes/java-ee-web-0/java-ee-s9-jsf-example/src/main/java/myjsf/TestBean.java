package myjsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "myBean")
public class TestBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestBean() {
		name = "DEFAULT";
		System.out.println("Bean is created.");
	}

	public String getAction() {
		System.out.println("Test methd is called.");
		return "home";
	}
}
