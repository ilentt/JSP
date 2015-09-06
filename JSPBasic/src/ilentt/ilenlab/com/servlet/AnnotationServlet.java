package ilentt.ilenlab.com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// create multiple access URL
@WebServlet(urlPatterns = {"/ano1", "/ano2"}, 
		initParams = {
		@WebInitParam(name = "emailSupport1", value = "ilentt@ilenlab.com"),
		@WebInitParam(name = "emailSupport2", value = "admin@ilenlab.com")
})

public class AnnotationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3343273838046065371L;
	
	private String emailSupport1;
	
	public AnnotationServlet() {
		// constructor
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Annotation Servlet</title></head>");
		out.println("<body>");
		out.println("<p>Annotation Email support 1: " + this.emailSupport1 + "</p>");
		out.println("<p>Annotaion Email support 2: " + emailSupport2 + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
