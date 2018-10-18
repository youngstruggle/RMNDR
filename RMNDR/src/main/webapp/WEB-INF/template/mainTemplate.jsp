<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/welcome.css" rel="stylesheet" />

<title>
	<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>

</head>
<body>
	
	<div style="margin-top: 4em">
		<table>
			<tr>
				<td colspan="2" align="center">
					<tiles:insertAttribute name="header"></tiles:insertAttribute>
				</td>
			</tr>
			<tr>
				<td><tiles:insertAttribute name="menu"></tiles:insertAttribute></td>
				<td><tiles:insertAttribute name="body"></tiles:insertAttribute></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<tiles:insertAttribute name="footer"> </tiles:insertAttribute>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>