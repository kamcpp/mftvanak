package example.web.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request destroyed.");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("Request initialized ...");
	}
}
