<%@page import="Connect.DBConnect"%>
<%@page import="jobs.jobD"%>
<%@page import="model.Jobs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One View</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="UserNavbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<%
				int id = Integer.parseInt(request.getParameter("id"));
				jobD jd = new jobD(DBConnect.GetConnection());
				Jobs j = jd.getJobByID(id);
				%>
				<div class="card mt-5">
					<div class="card-body">
						<div class="text-center text-primary"></div>
						<h6><%=j.getTitle()%></h6>
						<p><%=j.getDescription()%></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=j.getLocation()%>" readonly />
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category <%=j.getCategory() %>" readonly />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>