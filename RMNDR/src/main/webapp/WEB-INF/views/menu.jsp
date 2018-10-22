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
						<li><a href="${pageContext.request.contextPath}/userlist.html">User</a></li>
						<li><a href="${pageContext.request.contextPath}/customerlist.html">Customer</a></li>
						<li><a href="${pageContext.request.contextPath}/divisionlist.html">Division</a></li>
						<li><a href="${pageContext.request.contextPath}/emailslist.html">Email</a></li>
						<li><a href="${pageContext.request.contextPath}/reportlist.html"><span>Invoice</span></a></li>
						<li><a href="${pageContext.request.contextPath}/uploadfile.html"><span>Upload</span></a></li>
						<li><a href="${pageContext.request.contextPath}/sendingemail.html"><span>Reminder</span></a></li>
						<li><a href="${pageContext.request.contextPath}/scheduler.html"><span>Scheduler</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div> <!-- End Wrapper -->


</body>
</html>