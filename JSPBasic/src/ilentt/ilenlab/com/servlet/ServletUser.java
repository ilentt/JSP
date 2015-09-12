package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.jsp.beans.Constants;
import ilentt.ilenlab.com.jsp.beans.UserInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userLogin")
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
		
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
		
		out.println("<html>");
		out.println("<head><title>Servlet User</title></head>");
		
		out.println("<body>");
		out.println("<h3>Servlet User</h3>");
		out.println("<p>Welcome to my servlet</p>");
		out.println("<p>User name: " + user.getUserName() + "</p>");
		out.println("<p>Post: " + user.getPost() + "</p>");
		out.println("<p>Country: " + user.getCountry() + "</p>");
		out.println("</body>");
		out.println("<html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
