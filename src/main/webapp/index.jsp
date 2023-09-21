<%@page import="java.sql.Connection"%>
<%@page import="Connect.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
<style type="text/css">
body {
	background-image: url(page1.jpg);
	width: 100%;	
	background-repeat: no-repeat;
}
</style>

</head>
<body>
	<%@include file="HomeNavbar.jsp"%>
	<% Connection conn = DBConnect.GetConnection(); %>



</body>
</html>