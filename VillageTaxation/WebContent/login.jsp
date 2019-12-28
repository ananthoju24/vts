<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>VillageTaxation</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="./assets/css/main.css">

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
</script>

<!------ Include the above in your HEAD tag ---------->
</head>
<body onload="noBack()">
	<div id="login">
		<h3 class="text-center .text-muted pt-5" >Village Taxation</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="./loginrequest" method="post">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
									<label for="hno" class="text-danger"> 
											    <%
												 	String errorMsg = (String) request.getAttribute("errorMsg");
												 	if (null != errorMsg) {
												 		out.print(errorMsg);
												 	}
												 %>
											</label>
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"><span>Remember me</span> 
								<span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> 
								<input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
							</div>
							
							<!-- <div id="register-link" class="text-right">
								<a href="#" class="text-info">Register here</a>
							</div> -->
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>