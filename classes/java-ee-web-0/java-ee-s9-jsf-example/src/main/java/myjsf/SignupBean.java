package myjsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;

@ManagedBean(name = "signupBean")
public class SignupBean {

	@NotNull
	private String name;
	private String family;
	private String username;
	private String password;
	private String passwordConfirmation;

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

	public String doSignup() {
		System.out.println("Name: " + name);
		System.out.println("Family: " + family);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Password Confirmation: " + passwordConfirmation);
		return "signup";
	}
}
