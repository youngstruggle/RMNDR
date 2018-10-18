<%-- 
    Document   : newjsp
    Created on : Sep 5, 2018, 9:31:12 AM
    Author     : DEVELOPER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Begin Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Report</title>
</head>

<body>

	<div class="custom-container">
		<div class="panel panel-primary">
			<div class="panel-heading">SCHEDULER</div>
		</div>
		<div class="pull-left">
			<a href="${pageContext.request.contextPath}/triggerscheduler.html"
				class="btn btn-primary">Trigger </a>
		</div>
	</div>

</body>
</html>
