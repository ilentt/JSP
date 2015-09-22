package ilentt.ilenlab.com.servlet;

import ilentt.ilenlab.com.beans.Product;
import ilentt.ilenlab.com.utils.DBUtils;
import ilentt.ilenlab.com.utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/product"})
public class ProductList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2623101320729021612L;

	public ProductList() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String errormsg = null;
		List<Product> products = null;
		try {
			products = DBUtils.getProduct(conn);
		}catch(SQLException e) {
			e.printStackTrace();
			errormsg = e.getMessage();
		}
		
		request.setAttribute("errormsg", errormsg);
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/product.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
