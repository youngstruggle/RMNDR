<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/sidebar.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" />

</head>
<body>

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
	</div> <!-- End Wrapper -->

	<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>