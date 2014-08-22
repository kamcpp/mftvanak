package mftv.springexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloSayer {

	public class Person {
		private String name;
		private String family;
		private int age;

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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String root() {
		return "<h1>ROOT</h1>";
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String rootOnPost() {
		return "<h1>ROOT ON POST</h1>";
	}

	@RequestMapping("/say")
	public @ResponseBody String doSay() {
		return "<h1>HELLO WORLD ...</h1>";
	}

	@RequestMapping("/person")
	public Person getPerson() {
		Person p = new Person();
		p.setName("John");
		p.setFamily("Alex");
		p.setAge(22);
		return p;
	}
}
