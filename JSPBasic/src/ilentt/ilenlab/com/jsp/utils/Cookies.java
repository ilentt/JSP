package ilentt.ilenlab.com.jsp.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class Cookies {

	public Cookies() {
		// constructor
	}
	
	public void userCookies(HttpServletRequest request, HttpServletResponse response,
			JspWriter out) throws IOException {
		
		boolean found = false;
		// get cookies list stored in user PC
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			String userName = null;
			String lastLoginDate = null;
			out.println("<h3>Cookies: </h3>");
			for(int i=0; i<cookies.length; i++) {
				out.println(cookies[i].getName() + ": " + cookies[i].getValue() + "<br/>");
				if(cookies[i].getName().equals("userName")) {
					userName = cookies[i].getValue();
				}else if(cookies[i].getName().equals("lastLoginDate")) {
					lastLoginDate = cookies[i].getValue();
				}
			}
			if(userName != null) {
				found = true;
				out.println("<h4>Last login infor: </h4>");
				out.println("User name: " + userName + "<br />");
				out.println("Last login date time: " + lastLoginDate);
			}
		}
		if(!found) {
			out.println("<h3>No cookies founds!, write some cookies into client computer</h3>");
			String userName = "ilentt";
			Cookie cookieUserName = new Cookie("userName", userName);
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date now = new Date();
			
			String lastLoginDate = dateformat.format(now);
			Cookie cookieLoginDate = new Cookie("lastLoginDate", lastLoginDate);
			
			// set cookie life time is five minute
			cookieUserName.setMaxAge(5*60);
			cookieLoginDate.setMaxAge(5*60);
			
			// write down
			response.addCookie(cookieUserName);
			response.addCookie(cookieLoginDate);
		}
	}
}
