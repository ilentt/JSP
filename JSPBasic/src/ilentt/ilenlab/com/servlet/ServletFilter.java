package ilentt.ilenlab.com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ServletFilter implements Filter {

	public ServletFilter() {
		// constructor
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Log filter detroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String serverPath = req.getServletPath();
		System.out.println("#INFO " + new Date() + 
			" - servlet path: " + serverPath + ", URL = " + req.getRequestURL());
		
		// pass filter continue process
		filter.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Log filter init");
	}

}
