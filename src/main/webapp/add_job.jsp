<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Job</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>
	<div class="contain p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<h2>
							<i class="fa-sharp fa-solid fa-plus"></i>
						</h2>
						<h3>Add Jobs</h3>
					</div>
					<form action="AddPost" method="post">
						<div class="form-group">
							<label>Enter Titel</label> <input type="text" name="title"
								required class="form-control" />
						</div>
						<div class="form-row">
							<div class="form-group col-ms-4">
								<label>Location</label> <select name="Location"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option selected>Choose...</option>
									<option value="Odisha">Odisha</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Gujurat">Gujurat</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
									<option value="Delhi">Delhi</option>
									<option value="Banglore">Banglore</option>
									<option value="Chennai">Chennai</option>
									<option value="Hydrabad">Hydrabad</option>
								</select>
							</div>
							<div class="form-group col-ms-4">
								<label>Category</label> <select name="Category"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option selected>Choose...</option>
									<option value="IT">IT</option>
									<option value="DevLoper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
							<div class="form-group col-ms-4">
								<label>Status</label> <select name="Status"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option class="Active" value="Active">Active</option>
									<option class="Inactive" value="Inactive">Inactive</option>
								</select>
							</div>
						</div>
						<div class="form-group">
						<label>Enter Description</label>
						<textarea required rows="6" cols="" name="desc"
							class="form-control"></textarea>
					</div>
					<button class="btn btn-success">Publish Job</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>