<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<!-- product list page -->
	<h3>Product List</h3>
	
	<p style="color:red;">$errormsg</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<!--  unknow tag -->
		<c:forEach item="${products}" var="p">
			<tr>
				<td>${p.code }</td>
				<td>${p.name }</td>
				<td>${p.price }</td>
				<td><a href="edit?code=${p.code}">edit</a></td>
				<td><a href="delete?code=${p.code}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="create">Create</a>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>