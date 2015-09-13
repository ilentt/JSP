package ilentt.ilenlab.com.filter;

import ilentt.ilenlab.com.beans.Account;
import ilentt.ilenlab.com.utils.DBUtils;
import ilentt.ilenlab.com.utils.MyUtils;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

	public CookieFilter() {
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
		HttpSession session = req.getSession();
		Account account = MyUtils.getLoginedUser(session);
		// đang login
		if(account !=null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			filter.doFilter(request, response);
			return;
		}
		
		// đã được tạo trong JDBC Filter
		Connection conn = MyUtils.getStoredConnection(request);
		
		// có cần kiểm tra cookie không
		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if(checked == null && conn != null) {
			String userName = MyUtils.getUserNameInCookie(req);
			try {
				Account user = DBUtils.findUser(conn, userName);
				MyUtils.storeLoginedUser(session, user);
			}catch(Exception e) {
				e.printStackTrace();
			}
			// đã kiểm tra cookie
			session.setAttribute("COOKIE_CHECKED", 	"CHECKED");
		}
		filter.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
