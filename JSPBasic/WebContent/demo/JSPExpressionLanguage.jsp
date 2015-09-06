<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="ilentt.ilenlab.com.jsp.beans.Employee">
	<jsp:setProperty name="emp" property="empNo" value="E0011"/>
	<jsp:setProperty name="emp" property="empName" value="Tran Thanh I len"/>
</jsp:useBean>

<p>
	<span>Employee Number: </span> <input type="text" value="${emp.empNo}"/>
</p>
<p>
	<span>Employee Name: </span> <input type="text" value="${emp.empName}"/>
</p>
