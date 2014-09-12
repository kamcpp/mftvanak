package example.web.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BenchmarkFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("This is benchmark filter ...");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		long end = new Date().getTime();
		System.out.println((end - start) + " ms");
		System.out.println("We are leaving benchmark filter ...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
