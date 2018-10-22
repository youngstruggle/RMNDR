<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
<!-- <link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" /> -->

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Upload Menu</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary" style="margin-bottom: -0.3em;">
			<div class="panel-heading">UPLOAD FILE</div>
		</div>

		<div class="row">
		  <div class="col-md-12">
		  	  <label style="color: blue">${message}</label>
		  </div>
		</div>
		  	 	  
		<form method="POST" action="${pageContext.request.contextPath}/upload"
			enctype="multipart/form-data">
			<div class="form-group form-group-sm">
				<div class="col-sm-7">
					<input class="form-control input-lg pull-right" type="file"
						name="file"/> 
					<input style="margin-top: 5px;"
						class="btn btn btn-primary" type="submit" value="Submit" />
				</div>
			</div>
		</form>

	</div>

	<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>