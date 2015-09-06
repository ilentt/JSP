<%@ page isErrorPage = "true" import = "java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<h1>Some error in this page</h1>
	Message: <%= exception.getMessage() %>
	
	<h3>StackTrace:</h3>
	<%
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		out.println("<pre>");
		out.println(stringWriter);
		out.println("</pre>");
		printWriter.close();
		stringWriter.close();
	%>
</body>
</html>