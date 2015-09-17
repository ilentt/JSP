package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.beans.Account;
import ilentt.ilenlab.com.utils.MyUtils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3306405933760065495L;

	public UserInfo() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account account = MyUtils.getLoginedUser(session);
		
		if(account == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		//request.setAttribute("account", account);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfo.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
