<%@ page import="ilentt.ilenlab.com.jsp.utils.Cookies" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookies demo</title>
</head>
<body>
	<%
		Cookies cookies = new Cookies();
		cookies.userCookies(request, response, out);
	%>
	<a href="#">Try agian!!!</a>
</body>
</html>