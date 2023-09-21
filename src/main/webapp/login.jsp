<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="all_css.jsp"%>
<style type="text/css">
body {
	background-image: url(page1.jpg);
	width: 100%;
	background-repeat: no-repeat;
}

.container {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	width: 35%;
	
}

.container h2 {
	text-align: center;
}

.form-group {
margin: 10px;
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: bold;
}

.form-group input[type="email"], .form-group input[type="password"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-group input[type="submit"] {
	background-color: #007bff;
	border: none;
	padding: 10px 20px;
	border-radius: 10px;
	width: 100%;
}

.form-group input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@include file="HomeNavbar.jsp"%>

	<div class="container offset-md-4">
		<h2><i class="fa-solid fa-right-to-bracket"></i>&nbsp Login Page</h2>
		<form action="Login" method="post">
			<div class="form-group">
				<label for="username">Enter Email:</label> <input type="email"
					id="username" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Enter Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<input type="submit" value="Login">
			</div>
			
		</form>
	</div>
	
</body>
</html>