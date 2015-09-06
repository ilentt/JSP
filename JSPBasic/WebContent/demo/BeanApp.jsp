<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Bean</title>
</head>
<body>
	<jsp:useBean id="myBean"
		class="ilentt.ilenlab.com.jsp.beans.HelloBeans"/>
	<h3>Say Hello: </h3>
	<jsp:getProperty property="hello" name="myBean"/>
	
	<!-- set property name for helloBean -->
	<jsp:setProperty property="name" name="myBean" value="ILENTT"/>
	<h3>Say hello after set name</h3>
	<jsp:getProperty property="hello" name="myBean"/>
	
</body>
</html>