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
	href="${pageContext.request.contextPath}/resources/css/sidebarmenuexample.css"
	rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Sidebar Menu Example</title>

</head>
<body>
	<div class="sidenav">
		<a href="#about">About</a> <a href="#com.nana.services">Services</a> <a
			href="#clients">Clients</a> <a href="#contact">Contact</a>
		<button class="dropdown-btn">
			Dropdown <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a href="#">Link 1</a> 
			<a href="#">Link 2</a> 
			<a href="#">Link 3</a>
		</div>
		<a href="#contact">Search</a>
	</div>

	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>
</body>
</html>
