package ilentt.ilenlab.com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 793665276827879784L;
	
	private String emailSupport1;
	
	public InitParamServlet() {
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// get servlet init parameter
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Init parameter in servlet</title></head>");
		out.println("<body>");
		out.println("<p>Email support 1: " + this.emailSupport1 + "</p>");
		out.println("<p>Email support 2: " + emailSupport2 + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
