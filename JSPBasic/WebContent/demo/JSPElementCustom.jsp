<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
	<jsp:useBean id="emp" class="ilentt.ilenlab.com.jsp.beans.Employee">
		<jsp:setProperty name="emp" property="empNo" value="E001"/>
		<jsp:setProperty name="emp" property="empName" value="ILenTT"/>
		<employee <%= emp.getEmpNo() %>>
			<%= emp.getEmpName() %>
		</employee> 
	</jsp:useBean>
</data>