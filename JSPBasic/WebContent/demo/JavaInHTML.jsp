<%@ page 
	import="java.util.Random"
	import="java.text.*" 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java in HTML</title>
</head>
<body>
	<%
		Random random = new Random();
	
		// trả về ngẫu nhiên (0, 1 hoặc 2)
		int number = random.nextInt(3);
		if(number == 0) {	
			
	%>
	<h1>Random value: = <%= number %></h1>
	<%
		} else if(number == 1) {
			
	%>
	<h2>Random value: = <%= number %></h2>
	<%
		} else {
	%>
	<h3>Random value: = <%= number %></h3>
	<%
		}
	%>
	
	<a href="<%= request.getRequestURI()%>">Try again</a>
</body>
</html>