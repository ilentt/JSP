package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.beans.Account;
import ilentt.ilenlab.com.utils.DBUtils;
import ilentt.ilenlab.com.utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5455821213956808164L;

	public LoginAction() {
		// TODO Auto-generated constructor stub
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememerme");
		boolean remember = "Y".equalsIgnoreCase(rememberme);
		
		Account account = null;
		boolean error = false;
		String errormsg = null;
		if(username == null || password == null || username.length() == 0 || password.length() == 0) {
			error = true;
			errormsg = "Please enter username and password!";
		}
		else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				account = DBUtils.findUser(conn, username, password);
				if(account == null) {
					error = true;
					errormsg = "username or password does not exist";
				}
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				error = true;
				errormsg = e.getMessage();
			}
		}
		if(error) {
			account = new Account();
			account.setUsername(username);
			account.setPassword(password);
		}
	}
}
