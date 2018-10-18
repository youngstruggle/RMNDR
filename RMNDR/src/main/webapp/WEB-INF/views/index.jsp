<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/login.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cssreset.css"
	rel="stylesheet" />

<title>Login</title>
</head>
<body id="LoginForm">
	<div class="container">
		<h1 class="form-heading"></h1>

		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>LOGIN</h2>
					<p style="color: red">${error}</p>
				</div>

				<s:form method="post" commandName="ruser" action="login.html"
					id="Login">
					<div class="form-group">
						<label>Username</label>
						<s:input autocomplete="off" path="username" class="form-control" />
					</div>
					<div class="form-group">
						<label>Password</label>
						<s:password path="password" class="form-control" />
					</div>
					<div>
						<label>Remember Me</label> <input type="checkbox" name="remember"
							value="true" />
					</div>
					<input type="submit" value="Login" class="btn btn-primary" />
				</s:form>

			</div>
			<!-- End main-div -->
		</div>
		<!-- End login-form -->

	</div>

	<script
		src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>