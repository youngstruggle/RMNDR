<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Edit Email</title>

<style>
.error {
	color: #ff0000;
	font-size: 0.8em;
}
</style>

</head>
<body>

	<div class="custom-container">
		<div class="panel panel-primary">
			<div class="panel-heading">CREATE EMAIL</div>
		</div>

		<s:form class="form-horizontal" modelAttribute="remail"
			action="${pageContext.request.contextPath}/submiteditform.html"
			method="post">

			<div class="row">
				<div class="col-md-12">
					<label style="color: blue">${msg}</label>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
					<div class="col-md-8 inputGroupContainer">
						<div class="input-group">
							<s:hidden path="emailId" />
					 </div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="sender">Sender</label>
					<s:input autocomplete="off" class="form-control" path="sender"
						id="sender" />
					<s:errors path="sender" cssClass="error" />
				</div>

				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="recipients">Recipients</label>
					<s:input autocomplete="off" class="form-control" path="recipients"
						id="recipients" />
					<s:errors path="recipients" cssClass="error" />
				</div>

				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="subject">Subject</label>
					<s:input class="form-control" path="subject" id="subject" />
					<s:errors path="subject" cssClass="error" />
				</div>

				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="header">Header</label>
					<s:input class="form-control" path="header" id="header" />
					<s:errors path="header" cssClass="error" />
				</div>

				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="contents">Contents</label>
					<s:textarea class="form-control" path="contents" id="contents" />
					<s:errors path="contents" cssClass="error" />
				</div>

				<div class="col-xs-5 form-group" style="margin-left: 2em;">
					<label class="col-sm-2 control-label" for="footer">Footer</label>
					<s:input class="form-control" path="footer" id="footer" />
					<s:errors path="footer" cssClass="error" />
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<!-- Submit -->
					<div class="form-group form-group-sm" style="margin-left: 2em;">
						<div class="pull-left">
							 <input type="submit" value="Update" class="btn btn-primary" />
						</div>
					</div>
				</div>
			</div>
		</s:form>
	</div>

</body>
</html>
