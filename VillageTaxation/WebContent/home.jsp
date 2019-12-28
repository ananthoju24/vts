<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" rel="stylesheet" href="../assets/css/home.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script src="../assets/js/home.js"></script>

<title>VillageTaxation</title>
</head>
<body>

	<jsp:include page="../header.jsp" />
	<div id="page-wrapper">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content">
					<div class="container">
						<div id="serach"
							class="row justify-content-center align-items-center">
							<div id="search-column" class="col-md-3">
								
									<form id="search-form" class="form" action="./vtscontroller?action=search"
										method="post">
										<h5 class="text-left text-info">Search Tax Details</h5>
										<div class="form-group" >
											<label for="hno" class="text-info">House No :</label><br>
											<input type="text" name="houseno" id="houseno"
												class="form-control">
										</div>

										<div class="form-group">
											<label for="hno" class="text-danger"> <%
												 	String errorMsg = (String) session.getAttribute("errorMsg");
												 	if (null != errorMsg) {
												 		out.print(errorMsg);
												 	}
												 %>
											</label><br>
										</div>
										<div class="form-group">
											<input type="submit" name="submit"
												class="btn btn-primary" value="Search">
										</div>
									</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
	<!-- /#wrapper -->
</body>
</html>