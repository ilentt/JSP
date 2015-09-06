<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
</head>
<body>
	<h3>Parameter value</h3>
	<%
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String[] address = request.getParameterValues("address");
	%>
	
	User Name: <%=username %><br/>
	PassWord: <%= password %><br/>
	First Name: <%= firstname %><br/>
	Last Name: <%= lastname %><br/>
	Gender: <%= gender %><br/>
	Address: 
	<%
		if(address!=null) {
			for(String ads : address) {
	%>
				<%= ads %> <br/>
	<%
			}
		}
	%>
</body>
</html>