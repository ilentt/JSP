package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.jsp.beans.Constants;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/redirect")
public class ServletRedirectBase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3011658611697275986L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (String)request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
		ServletOutputStream out = response.getOutputStream();
		out.println("<h1>Redirect Servlet</h1>");
		out.println(value);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
