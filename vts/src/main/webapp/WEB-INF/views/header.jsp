<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<div id="google_translate_element"></div>

<script
	src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>


<div id="throbber" style="display: none; min-height: 120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper container">
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<!-- <p class="text-center text-info pt-5" style="padding-left:10px"> -->
			<a class="navbar-brand" href="#"
				style="padding-left: 10px; padding-top: 10px">Village Taxation</a>

			<!-- <a class="navbar-brand" href="#"> <img
					src="http://placehold.it/200x50&text=LOGO" alt="LOGO"> 
				</a> -->
			<!-- 				 -->
		</div>

		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li><a href="#" data-placement="bottom" data-toggle="tooltip"
				href="#" data-original-title="user"><i class=".icon .icon-user"></i>
			</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">${userName}
				<%-- <%=session.getAttribute("username")%> --%> <b
					class="fa fa-angle-down"></b></a>
				<ul class="dropdown-menu">
					<!-- <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit
								Profile</a></li>
						<li><a href="#"><i class="fa fa-fw fa-cog"></i> Change
								Password</a></li> -->
					<li class="divider"></li>
					<li><a href="./logout"><i class="fa fa-fw fa-power-off"></i>
							Logout</a></li>
				</ul></li>
		</ul>
		<!-- /.navbar-collapse -->
	</nav>
</div>