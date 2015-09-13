package ilentt.ilenlab.com.utils;

import ilentt.ilenlab.com.beans.Account;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION ="ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_USER_NAME = "ATTRIBE_FOR_STORE_USER_NAME_IN_COOKIE";
	
	public MyUtils() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Lưu trữ Connection vào một thuộc tính cùa request
	 * Thông tin lưu trữ chỉ tồn tại trong thời gian yêu cầu(request)
	 * cho tới khi dữ liệu được trả về trình duyệt người dùng
	 */
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	
	// Lấp đối tượng Connection đã được lưu trữ trong một thuộc tính request
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	// Lưu trữ thông tin người dùng đã login vào session
	public static void storeLoginedUser(HttpSession session, Account account) {
		session.setAttribute("loginUser", account);
	}
	
	// Lấy thông tin người dùng đã login trong session
	public static Account getLoginedUser(HttpSession session) {
		Account account = (Account)session.getAttribute("loginUser");
		return account;
	}
	
	// Lưu thông tin người dùng vào cookie
	public static void storeUserCookie(HttpServletResponse response, Account account) {
		System.out.println("Store user cookie");
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, account.getUsername());
		// 15 phút đổi ra giây
		cookie.setMaxAge(15*60);
		response.addCookie(cookie);
	}
	
	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(ATT_NAME_USER_NAME.equalsIgnoreCase(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	// Xoá cookies người dùng
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(ATT_NAME_USER_NAME, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
