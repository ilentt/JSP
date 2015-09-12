package ilentt.ilenlab.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/runRedirect")
public class ServletRedirect extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3011658611697275986L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = request.getParameter("redirect");
		if("true".equalsIgnoreCase(redirect)) {
			System.out.println("Redirect to show redirect base");
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/other/redirect");
			return;
		}
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of redirect demo</h3>");
		out.println(" - servlet path = " + request.getServletPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
