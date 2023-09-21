<%@page import="model.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="Connect.DBConnect"%>
<%@page import="jobs.jobD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Job</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="HomeNavbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center text-primary m-3">All Jobs</h3>
				<%
				jobD jd = new jobD(DBConnect.GetConnection());
				List<Jobs> list = jd.getAllJobs();

				for (Jobs j : list) {
				%>
				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<h2>
								<i class="fa-light fa-note"></i>
							</h2>
						</div>
						<h6><%=j.getTitle() %></h6>
						<p><%=j.getDescription() %></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control from-control-sm"
									value="Location: <%=j.getLocation() %>" readonly />
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control from-control-sm"
									value="Category: <%=j.getCategory() %>" readonly />
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control from-control-sm"
									value="Status: <%=j.getStatus() %>" readonly />
							</div>
						</div>
						<div class="text-center">
							<a href="edit_job.jsp?id=<%=j.getId() %>" class="btn btn-sm bg-success text-white">Edit</a> <a
								href="DeleteJob?id=<%=j.getId() %>" class="btn btn-sm bg-success text-white">Delete</a>
						</div>
					</div>
				</div>
				<%
				}
				%>


			</div>
		</div>

	</div>

</body>
</html>