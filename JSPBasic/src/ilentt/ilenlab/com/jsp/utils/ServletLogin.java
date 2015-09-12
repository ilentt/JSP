package ilentt.ilenlab.com.jsp.utils;

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

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5206556377867763173L;
	
	public ServletLogin() {
		// constructor
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		HttpSession session = request.getSession();
		UserInfo userInfor = new UserInfo("ilentt", 84, "Vietnam");
		session.setAttribute(Constants.SESSION_USER_KEY, userInfor);
		
		out.println("<html>");
		out.println("<head><title>Session Login</title></head>");
		out.println("<body>");
		out.println("<h3>You are logined!, infor stored in session</h3>");
		out.println("<a href='userLogin'>View user info</a>");
		out.println("</body>");
		out.println("<html>");
	}
}
