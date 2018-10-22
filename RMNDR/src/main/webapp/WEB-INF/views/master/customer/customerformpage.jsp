<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" />
<!-- <link href="${pageContext.request.contextPath}/resources/css/cssreset.css" rel="stylesheet" /> -->

<!-- JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<title>Create User</title>

<style>
.error {
	color: #ff0000;
	font-size: 0.8em;
}
</style>

</head>
<body>
	<h1>${headerMessage}</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">CUSTOMER</div>
				</div>
			</div>
		</div>

		<table class="table table-striped">
			<tbody>
				<tr>
					<td colspan="1"><s:form modelAttribute="rcustomer"
							action="${pageContext.request.contextPath}/submitcustomerform.html"
							method="post" class="well form-horizontal">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label" for="customerName">Customer Name</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="customerName" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="customerName" id="customerName" placeholder="Customer Name" />
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-4 control-label" for="emailAddress">Email Address</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="emailAddress" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="emailAddress" id="emailAddress" placeholder="Email Address" />
										</div>
									</div>
								</div>								
								<div class="form-group">
									<label class="col-md-4 control-label"></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<input type="submit" value="Create" class="btn btn-primary" />
										</div>
									</div>
								</div>
							</fieldset>
						</s:form></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
