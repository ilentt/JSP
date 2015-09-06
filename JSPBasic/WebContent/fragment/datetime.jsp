<%@ page import="java.util.Date, java.text.*" %>
<%
	Date now = new Date();
	DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSS");
%>
	<h4>Current time: <%=dateformat.format(now) %></h4>