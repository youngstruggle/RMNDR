<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/welcome.css"
	rel="stylesheet" />

<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>

<style type="text/css">
.body-content {
	float: left; 
	padding: 10px; 
	width: 80%; border-left: 1px solid pink;
	margin-top: 3em;
}

</style>

</head>
<body>

	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div style="float: left; padding: 10px; width: 15%;">
		<tiles:insertAttribute name="menu" />
	</div>
	<div class="body-content">
		<tiles:insertAttribute name="body" />
	</div>
	<div style="clear: both">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>