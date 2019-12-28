<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>VillageTaxation</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<meta name="viewport"
	content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=320, height=device-height, target-densitydpi=medium-dpi" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" id="bootstrap-css">
<link type="text/css" rel="stylesheet"
	href="/resources/assets/css/home.css">
<script src="/resources/assets/js/home.js"></script>
<script>
	function noBack() {
		window.history.forward(1);
	}
	noBack();
	window.onload = noBack;
	window.onpageshow = function(evt) {
		if (evt.persisted)
			noBack();
	}
	window.onunload = function() {
		void (0);
	}
	$(document).ready(function() {
		$('#addResp').html("");
		$("#addTax").click(function() {
			$.ajax({
				type : "POST",
				url : "./vtscontroller?action=add",
				data : $('form').serialize(),
				success : function(data) {
					//alert("Successfully added : " + data);
					$('#addResp').append(data);
					setTimeout(function() {
						$('#addTaxModal').modal('hide');
					}, 4000);
				},
				error : function(data) {
					$('#failedResp').append(data);
				},
				dataType : "text"
			});
			$('#addResp').html("");
		});
	});
</script>
<script>
	function googleTranslateElementInit() {
		new google.translate.TranslateElement({
			pageLanguage : 'en',
			includedLanguages : 'te',
			autoDisplay : false
		}, 'google_translate_element');
		var a = document.querySelector("#google_translate_element select");
		a.selectedIndex = 1;
		a.dispatchEvent(new Event('change'));
	}
</script>
<style type="text/css">
html, body {
	max-width: 100%;
	overflow-x: auto;
}

@media print {
	.no-print, .no-print * {
		display: none !important;
	}
}
</style>
</head>
<body onload="noBack()">


	<div id="google_translate_element"></div>

	<script
		src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>


	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div id="page-wrapper" class="no-print">
		<div class="container col-md-12">
			<!-- Page Heading -->
			<div class="row" id="main">
				<div class="col-sm-12 col-md-12 well" id="content">
					<div class="container">
						<div id="serachresult"
							class="responsive row justify-content-center align-items-center">

							<div class="col-sm-6">
								<table class="table borderless table-responsive">
									<thead>
										<th><h4>Tax Details For</h4></th>
									</thead>
									<tbody>
										<tr>
											<td class="col-sm-6"><h5>House Number</h5></td>
											<td class="col-sm-6"><h5>
													<b><c:out value="${taxDetails.hno}" /></b>
												</h5></td>
										</tr>
										<tr>
											<td class="col-sm-6"><h5>Owner Name</h5></td>
											<td class="col-sm-6"><h5>
													<b><c:out value="${taxDetails.ownerName}" /></b>
												</h5></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="col-sm-6">
								<div class="form-group col-sm-12">
									<input type="submit" name="submit"
										class="btn btn-primary col-sm-3" data-toggle="modal"
										data-target="#exampleModalCenter" value="Print Recepiet">
								</div>
								<div class="form-group 	col-sm-12">
									<input type="submit" name="submit"
										class="btn btn-primary col-sm-6" data-toggle="modal"
										data-target="#addTaxModal" value="Add Tax">
								</div>
							</div>
							<table class="table table-responsive">
								<thead>
									<tr>
										<th>House Tax</th>
										<th>Village Tax</th>
										<th>Water Tax</th>
										<th>Lighting Tax</th>
										<th>cleanliness Tax</th>
										<th>Total Tax Amount</th>
										<th>Tax Year</th>
										<th>Payment Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${taxDetails.taxDataList}" var="taxData">
										<tr>
											<td><c:out value="${taxData.ep}"></c:out></td>
											<td><c:out value="${taxData.gp}" /></td>
											<td><c:out value="${taxData.np}" /></td>
											<td><c:out value="${taxData.lp}" /></td>
											<td><c:out value="${taxData.pp}" /></td>
											<td><c:out value="${taxData.totalTaxAmount}" /></td>
											<td><c:out value="${taxData.taxYear}" /></td>
											<td><c:out value="${taxData.paymentStatus}" /></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header no-print">
					<!-- <h5 class="modal-title no-print" id="exampleModalCenterTitle">Tax
						Receipt</h5> -->
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p align="center">
						<b>Grama Panchayati, Noothpally<br>Mandal Nandipet, Dist.
							Nijamabad
						</b> <br> Tax Receipt
					</p>
					<table class="table table-responsive">
						<tr>
							<td>Receipt Number</td>
							<td>: <%=System.currentTimeMillis()%></td>
							<td></td>
							<td>Date</td>
							<td>: <c:out value="${taxDetails.date}" /></td>
						</tr>
						<tr>
							<td>Mrs/Mr</td>
							<td><c:out value="${taxDetails.ownerName}" /></td>
							<td>Father/Husband :</td>
							<td></td>
						</tr>
						<tr>
							<td>HouseNo.</td>
							<td><b><c:out value="${taxDetails.hno}" /></b></td>
							<td>Kulai No :</td>
							<td></td>
							<td>Year</td>
							<td>2018-2019</td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td>s.no</td>
							<td>Tax Details</td>
							<td>Dues</td>
							<td>Present</td>
							<td>Total</td>
						</tr>
						<tr>
							<td>1</td>
							<td>House Tax</td>
							<td><c:out value="${taxDetails.dueTaxData.ep}" /></td>
							<td><c:out value="${taxDetails.currentTaxData.ep}" /></td>
							<td><c:out
									value="${taxDetails.dueTaxData.ep+taxDetails.currentTaxData.ep}" /></td>
						</tr>
						<tr>
							<td>2</td>
							<td>Library Tax</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>3</td>
							<td>Lighting Tax</td>
							<td><c:out value="${taxDetails.dueTaxData.lp}" /></td>
							<td><c:out value="${taxDetails.currentTaxData.lp}" /></td>
							<td><c:out
									value="${taxDetails.dueTaxData.lp+taxDetails.currentTaxData.lp}" /></td>
						</tr>
						<tr>
							<td>4</td>
							<td>Drainage Tax</td>
							<td><c:out value="${taxDetails.dueTaxData.pp}" /></td>
							<td><c:out value="${taxDetails.currentTaxData.pp}" /></td>
							<td><c:out
									value="${taxDetails.dueTaxData.pp +taxDetails.currentTaxData.pp}" /></td>
						</tr>
						<tr>
							<td>5</td>
							<td>Water Tax</td>
							<td><c:out value="${taxDetails.dueTaxData.np}" /></td>
							<td><c:out value="${taxDetails.currentTaxData.np}" /></td>
							<td><c:out
									value="${taxDetails.dueTaxData.np+taxDetails.currentTaxData.np}" /></td>
						</tr>
						<tr>
							<td>6</td>
							<td>Kulai nela vari Fee</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>7</td>
							<td>Kulai Deposit</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>8</td>
							<td>License Fee</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>9</td>
							<td>House Construction Fee</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>10</td>
							<td>Dakala Fee</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>11</td>
							<td>Bandela Doddi</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>12</td>
							<td>Building Rents</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>13</td>
							<td>Others</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td>Total Amt</td>
							<td><c:out value="${taxDetails.dueTaxData.totalTaxAmount}" /></td>
							<td><c:out
									value="${taxDetails.currentTaxData.totalTaxAmount}" /></td>
							<td><c:out
									value="${taxDetails.dueTaxData.totalTaxAmount + taxDetails.currentTaxData.totalTaxAmount}"></c:out></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer no-print">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="window.print()">Print</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Adding Tax -->
	<div class="modal fade" id="addTaxModal" tabindex="-1" role="dialog"
		aria-labelledby="addTaxModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header no-print" align="center">
					<h4 class="modal-title no-print" id="addTaxModalTitle">Add Tax</h4>
					<!-- <button type="button" class="close" data-dismiss="modal"
						aria-label="Close"> 
						<span aria-hidden="true">&times;</span>
					</button>-->
				</div>
				<!-- <form id="addTaxForm"> -->
				<form id="addTaxForm" class="form"
					action="./addtaxdetails" method="post">
					<div class="modal-body">
						<div class="form-group">
							<input type="text" name="hno" id="hno" value="${taxDetails.hno}"
								hidden /> <input type="text" name="ownerName" id="ownerName"
								value="${taxDetails.ownerName}" hidden />
						</div>
						<div class="form-group">
							<label for="houseTax">House Tax</label> <input type="text"
								class="form-control" name="houseTax" id="houseTax" />
						</div>
						<div class="form-group">
							<label for="inputVillageTax">Village Tax</label> <input
								type="text" class="form-control" name="villageTax"
								id="villageTax" />
						</div>
						<div class="form-group">
							<label for="inputWaterTax">Water Tax</label> <input type="text"
								class="form-control" name="waterTax" id="waterTax" />
						</div>
						<div class="form-group">
							<label for="inputLightingTax">Lighting Tax</label> <input
								type="text" class="form-control" name="lightingTax"
								id="lightingTax" />
						</div>
						<div class="form-group">
							<label for="inputcleanlinessTax">Cleanliness Tax</label> <input
								type="text" class="form-control" name="cleanlinessTax"
								id="cleanlinessTax" />
						</div>
						<div class="form-group">
							<label for="inputcleanlinessTax">Tax Year</label> <input
								type="text" class="form-control" name="taxYear" id="taxYear" />
						</div>
						<div class="form-group">
							<label for="response" id="addResp" class="text-success">
							</label> <label for="response" id="failedResp" class="text-danger">
							</label>
						</div>
					</div>

				</form>

				<div class="modal-footer no-print">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" id="addTax" class="btn btn-primary">Save</button>

				</div>

			</div>
		</div>
	</div>
</body>
</html>