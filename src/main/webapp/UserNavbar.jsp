<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><i class="fa-solid fa-house-user"></i> <span
						class="sr-only">(current)</span></a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<a href="index.jsp" class="btn btn-light"><i
					class="fa-solid fa-right-to-bracket"></i>&nbsp Logout</a>&nbsp <a
					href="#" class="btn btn-light"><i class="fa-solid fa-user-tie"></i>&nbsp
					User</a>
			</form>
		</div>
	</nav>
</body>
</html>