<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">
<style>
#google_translate_element, .skiptranslate {
	display: none;
}

body {
	top: 0 !important;
}
</style>
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
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#"> VTS </a>
		<button class="navbar-toggler collapsed" type="button"
			data-toggle="collapse" data-target="#navbarCollapse"
			aria-controls="navbarCollapse" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-collapse collapse" id="navbarCollapse" style="">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<!-- 	<li class="nav-item"><a class="nav-link"
					href="#">Link</a>
				</li>
				<li class="nav-item"><a class="nav-link disabled"
					href="#">Disabled</a>
				</li> -->
			</ul>
			<!-- <form class="form-inline mt-2 mt-md-0">
					<a class="nav-link disabled" href="/logout">Logout</a>
			</form> -->
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" data-toggle="dropdown">Admin</a>
					<div class="dropdown-menu dropdown-menu-right">
						<a href="#" class="dropdown-item">Home</a> 
						<div class="dropdown-divider"></div>
						<a href="/logout" class="dropdown-item">Logout</a>
					</div></li>
			</ul>
		</div>
	</nav>
</header>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>