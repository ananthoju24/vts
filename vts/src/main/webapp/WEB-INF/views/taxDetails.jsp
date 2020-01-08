<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script src="/resources/assets/js/home.js"></script>

<title>VillageTaxation</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp" />
	<!-- Begin page content -->
	<div id="container "
		style="margin-top: 85px;">
		<div class=" container-fluid ">
			<form id="search-form"
				class="form-horizontal border border-light p-5 col-md-4"
				action="./fetchTax" method="post" >
				<h5 class="text-left text-info">Search Tax Details</h5>
				<div class="form-group">
					<label for="hno" class="text-info">House No :</label><br> <input
						type="text" name="houseno" id="houseno" class="form-control">
				</div>

				<div class="form-group">
					<label for="searchErrorMsg" class="text-danger">
						${searchErrMsg} </label><br>
				</div>
				<div class="form-group">
					<input type="submit" name="submit" class="btn btn-primary"
						value="Fetch tax">
				</div>
			</form>

		</div>
	</div>
</body>
</html>