package ilentt.ilenlab.com.filter;

import ilentt.ilenlab.com.conn.ConnectionUtils;
import ilentt.ilenlab.com.utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"} )
public class JDBCFilter implements Filter{

	public JDBCFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		
		/*
		 * Chỉ mở connect đến các request là servlet hoặc jsp
		 * không mở connect đến các request thông thường như image, css, javascript,...
		 */
		
		if(needJDBC(req)) {
			System.out.println("Open connection for: " + req.getServletPath());
			Connection conn = null;
			try {
				// tạo đối tượng kết nối database
				conn = ConnectionUtils.getConnection();
				
				// set tự động commit = false để dễ chủ động điều khiển
				conn.setAutoCommit(false);
				
				// lưu trữ vào attribute của request
				MyUtils.storeConnection(request, conn);
				
				// cho phép request đi tiếp
				filter.doFilter(request, response);
				
				// gọi commit để giao dịch với database
				conn.commit();
			} catch(Exception e) {
				e.printStackTrace();
				ConnectionUtils.rollbackQuietly(conn);
				throw new ServletException();
			} finally {
				ConnectionUtils.closeQuietly(conn);
			}
		} else {
			/* 
			 * đối với các request thông thường css, image,...
			 * không cần mở connection, cho tiếp tục
			 */
			filter.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	// Kiểm tra request hiện tại có phải là một servlet hay không
	private boolean needJDBC(HttpServletRequest request) {
		System.out.println("JDBC Filter");
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String urlPattern = servletPath;
		
		if(pathInfo != null) {
			urlPattern = servletPath + "/*";
		}
		
		// Key: servletName
		// Value: ServletRegistration
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
		
		// Tập hợp tất cả Servlet trong WebApp
		Collection<? extends ServletRegistration> values = servletRegistrations.values();
		for(ServletRegistration sr : values) {
			Collection<String> mappings = sr.getMappings();
			if(mappings.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}
}
