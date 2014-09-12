package examples.struts.actions;

public class PerformSignupAction {

	private String name;
	private String family;
	private String username;
	private String password;
	private String passwordConfirmation;

	public String doSignup() {
		boolean validated = true;
		// TODO: Validation
		if (!validated) {
			// TODO Set errors in view
			return "signup-view";
		}
		// TODO: Save Entity using JPA
		return "signup-successful-view";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
