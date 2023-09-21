<%@page import="java.awt.dnd.DropTargetDragEvent"%>
<%@page import="org.apache.el.lang.ELArithmetic"%>
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
<title>User : View Jobs</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="UserNavbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center text-primary">Active Jobs</h3>
				<%
				jobD ud = new jobD(DBConnect.GetConnection());
				List<Jobs> list = ud.getAllJobsForUser();
				for (Jobs j : list) {
				%>
				<div class="card mt-2 ">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="fa-light fa-note"></i>
						</div>
						<h6><%=j.getTitle()%></h6>
						<%
						if (j.getDescription().length() > 0 && j.getDescription().length() < 120) {
						%>
						<p><%=j.getDescription()%></p>

						<%
						} else {
						%>

						<p><%=j.getDescription().substring(0, 120)%>...
						</p>
						<%
						}
						%>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=j.getLocation()%> readonly" />
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=j.getCategory()%> readonly" />
							</div>
						</div>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
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