<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script src="/resources/assets/js/enroll.js"></script>

<title>VillageTaxation</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div id="page-wrapper" style="margin-top: 85px;">
		<div class="container-fluid">
			<!-- Page Heading -->
			<form>
				<div class="form-group">
					<label for="InputOwnerName">OwnerName</label> <input
						type="ownerName" class="form-control" id="Input ownerName"
						aria-describedby="ownerHelp" placeholder="Enter ownerName ">
				</div>
				<div class="form-group">
					<label for="InputHno">Hno</label> <input
						type="hno" class="form-control" id="InputHno"
						placeholder="hno">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck">
					<label class="form-check-label" for="exampleCheck">Check
						me out</label>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->
</body>
</html>