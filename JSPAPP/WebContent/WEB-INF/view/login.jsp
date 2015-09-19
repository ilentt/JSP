<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Login page</h3>
	<p style="color:red;">@errormsg</p>
	<form method="post" action="LoginAction">
		<table border="0">
			<tr>
				<td>User Name</td>
				<td><input type = "text" name="username" value="${account.username}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type = "password" name="username" value="${account.password}" /></td>
			</tr>
			<tr>
				<td>Remember me</td>
				<td><input type = "checkbox" name="username" value="${account.username}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type = "submit" name="username" value="Submit" />
					<a href="${pageContext.request.contextPath}">Cancel</a>
				</td>
			</tr>
		</table>	
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>