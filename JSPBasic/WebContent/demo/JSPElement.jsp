<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:element name="data">
	<h3>Please view source this page</h3>
	<!-- Create object Employee and set values for its field -->
	
	<jsp:useBean id="emp" class="ilentt.ilenlab.com.jsp.beans.Employee">
		<jsp:setProperty name ="emp" property="empNo" value="E001"/>
		<jsp:setProperty name ="emp" property="empName" value="Smith"/>
	</jsp:useBean>
	
	<jsp:element name="employee">
		<jsp:attribute name="empNo" trim="true">
			<jsp:getProperty name="emp" property="empNo" />
		</jsp:attribute>
		
		<jsp:body>
			<jsp:getProperty name="emp" property="empName" />
		</jsp:body>
	</jsp:element>
	
</jsp:element>