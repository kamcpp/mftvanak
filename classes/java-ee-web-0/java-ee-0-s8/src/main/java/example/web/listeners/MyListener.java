package example.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Servlet context is about to be destroyed.");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Initializing the servlet context ...");
	}
}
