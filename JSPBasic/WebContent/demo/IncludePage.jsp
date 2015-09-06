<%@ page import="java.util.Random, java.text.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Include page</title>
</head>
<body>
	<%@ include file="../fragment/header.html" %>
	
	<h2>JSP tutorial for beginners</h2>
	Hi! this's JSP page
	
	<jsp:include page="../fragment/datetime.jsp" />
	
	<%@ include file="../fragment/footer.html" %>
</body>
</html>