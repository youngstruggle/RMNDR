<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/sidebarmenuexample.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

</head>
<body>

	<div class="sidenav">
		<button class="dropdown-btn"> Master Data <i class="fa fa-caret-down"></i></button>
		<div class="dropdown-container">
			<a href="${pageContext.request.contextPath}/userlist.html">User</a> 
			<a href="${pageContext.request.contextPath}/customerlist.html">Customer</a> 
			<a href="${pageContext.request.contextPath}/divisionlist.html">Division</a>
			<a href="${pageContext.request.contextPath}/emailslist.html">Email</a>
		</div>
		<a href="${pageContext.request.contextPath}/reportlist.html">Invoice</a> 
		<a href="${pageContext.request.contextPath}/uploadfile.html">Upload</a> 
		<a href="${pageContext.request.contextPath}/sendingemail.html">Reminder</a> 
		<a href="${pageContext.request.contextPath}/scheduler.html">Scheduler</a>
	</div>

	<!--  
	<div class="wrapper">
		<div class="sidebar-menu">
			<div class="side-in">
				<figure class="logo"> <img src="" alt="image view" class="img-responsive"> Logo </figure> 
				
				<div class="side-menu">
					<ul>
						<li><a href="${pageContext.request.contextPath}/userlist.html">User Master</a></li>
						<li><a href="${pageContext.request.contextPath}/customerlist.html">Customer Master</a></li>
						<li><a href="${pageContext.request.contextPath}/divisionlist.html">Division Master</a></li>
						<li><a href="${pageContext.request.contextPath}/emailslist.html">Email Master</a></li>
						<li><a href="${pageContext.request.contextPath}/reportlist.html">Invoice Menu</a></li>
						<li><a href="${pageContext.request.contextPath}/uploadfile.html">Upload File Menu</a></li>
						<li><a href="${pageContext.request.contextPath}/sendingemail.html">Reminder Menu</a></li>
						<li><a href="${pageContext.request.contextPath}/scheduler.html">Scheduler</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>  End Wrapper -->
	
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