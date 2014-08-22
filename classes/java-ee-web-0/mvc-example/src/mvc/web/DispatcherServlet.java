package mvc.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 6180124811119985598L;

	private String basePackage;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		basePackage = config.getServletContext()
				.getInitParameter("basePackage");
		System.out.println(basePackage);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(
				resp.getOutputStream()));
		try {
			Object controller = createControllerForRequest(req);
			Object result = invokeMethodOnControllerObject(controller, req);
			if (result instanceof String) {
				out.write((String) result);
			}
		} catch (ClassNotFoundException e) {
			resp.setStatus(404);
			out.write("<h1>404 Page Not Found.</h1>");
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			out.write("<h1>Internal Server Error.</h1>");
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected Object createControllerForRequest(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		String[] tokens = request.getRequestURI().split("/");
		String controllerName = tokens[2] + "Controller";
		String fullyQualifiedControllerName = basePackage + "."
				+ controllerName;
		Class<?> clazz = Class.forName(fullyQualifiedControllerName);
		return clazz.newInstance();
	}

	protected Object invokeMethodOnControllerObject(Object controller,
			HttpServletRequest request) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String[] tokens = request.getRequestURI().split("/");
		String methodName = tokens.length < 4 ? "root" : (tokens[3].trim()
				.length() == 0 ? "root" : tokens[3]);
		Class<?> clazz = controller.getClass();
		return clazz.getMethod(methodName).invoke(controller);
	}
}
