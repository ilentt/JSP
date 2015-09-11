package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.jsp.beans.Constants;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/forward")
public class ServletForward extends HttpServlet {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -1523914964243276862L;
	private static final long serialVersionUID = 1L;
	
	public ServletForward() {
		// constructor
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = request.getParameter("action");
		if("true".equalsIgnoreCase(forward)) {
			System.out.println("Forward Servlet");
			
			// send data to other page
			request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "Hi, this is forward servlet page");
			//RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/showForward");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forwardPage");
			dispatcher.forward(request, response);
			return;
		}
		
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Servler Forward</title></head>");
		out.println("<body>");
		out.println("<h3>Text of forward servlet: </h3>");
		out.println("<p>- servlet Path = " + request.getServletPath() + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
