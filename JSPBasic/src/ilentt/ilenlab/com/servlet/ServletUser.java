package ilentt.ilenlab.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 101447555850236627L;
	
	public ServletUser() {
		// constructor
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Servlet User</title></head>");
		
		out.println("<body>");
		out.println("<h3>Servlet User</h3>");
		out.println("<p>Welcome to my servlet</p>");
		out.println("</body>");
		out.println("<html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
