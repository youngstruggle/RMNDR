<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/welcome.css"
	rel="stylesheet" />

<title>Welcome</title>

</head>
<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!--  <a class="navbar-brand" href="#">Project name</a> -->
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<!-- <ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
			</ul>  -->
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a class="logout" href="${pageContext.request.contextPath}/account/logout.html">${sessionScope.username}</a></li> -->
				<li><a class="logout" href="${pageContext.request.contextPath}/logout.html">${sessionScope.username}</a></li>
			</ul>
		</div>
	</div>
	</nav>
</body>
</html>