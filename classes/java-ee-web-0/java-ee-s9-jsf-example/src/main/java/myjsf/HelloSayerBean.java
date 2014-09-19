package myjsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "helloSayerBean")
public class HelloSayerBean implements Serializable {

	private String text;

	public HelloSayerBean() {
		System.out.println("Hello sayer bean is created.");
	}

	public String sayHello(String text) {
		System.out.println("Say hello method is called.");
		return "HELLO " + text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
