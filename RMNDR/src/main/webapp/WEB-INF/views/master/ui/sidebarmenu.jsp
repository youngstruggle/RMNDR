<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/sidebarmenu.css"
	rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Sidebar Menu</title>

</head>
<body>
	<div id='cssmenu'>
		<ul>
			<li><a href='#'><span>Home</span></a></li>
			<li class='active has-sub'><a href='#'><span>Products</span></a>
				<ul>
					<li class='has-sub'><a href='#'><span>Product 1</span></a>
						<ul>
							<li><a href='#'><span>Sub Product</span></a></li>
							<li class='last'><a href='#'><span>Sub Product</span></a></li>
						</ul></li>
					<li class='has-sub'><a href='#'><span>Product 2</span></a>
						<ul>
							<li><a href='#'><span>Sub Product</span></a></li>
							<li class='last'><a href='#'><span>Sub Product</span></a></li>
						</ul></li>
				</ul></li>
			<li><a href='#'><span>About</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
</body>
</html>
