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
	<div id="page-wrapper" style="margin-top: 85px;">
		<div class="container-fluid">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content">
					<div class="container">
						<div id="serach"
							class="row justify-content-center align-items-center">
							<div id="search-column" class="col-md-3">

								<form id="search-form" class="form"
									action="./fetchTax" method="post">
									<h5 class="text-left text-info">Search Tax Details</h5>
									<div class="form-group">
										<label for="hno" class="text-info">House No :</label><br>
										<input type="text" name="houseno" id="houseno"
											class="form-control">
									</div>

									<div class="form-group">
										<label for="hno" class="text-danger"> ${searchErrMsg}
										</label><br>
									</div>
									<div class="form-group">
										<input type="submit" name="submit" class="btn btn-primary"
											value="Search">
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