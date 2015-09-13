package ilentt.ilenlab.com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class Home extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008773295305953346L;

	public Home() {
		// TODO Auto-generated constructor stub
		super();
	}
	// forward đến trang /WEB-INF/Views/home.jsp
	// người dùng không bao giờ truy cập được trực tiếp vào các trang jsp đặt trong /WEB-INF/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
