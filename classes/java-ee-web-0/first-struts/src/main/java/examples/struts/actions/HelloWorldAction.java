package examples.struts.actions;

public class HelloWorldAction {

	private String name;

	public HelloWorldAction() {
		name = "Teacher";
	}

	public String execute() {
		return "hello-world-view";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
