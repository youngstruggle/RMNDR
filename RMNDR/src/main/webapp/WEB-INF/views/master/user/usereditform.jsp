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
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/cssreset.css"
	rel="stylesheet" />

<!-- JQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<style>
.error {
	color: #ff0000;
	font-size: 0.8em;
}
</style>

<title>Edit User</title>

</head>
<body>
	<div class="custom-container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">UPDATE USER</div>
				</div>
			</div>
		</div>

		<table class="table table-striped">
			<tbody>
				<tr>
					<td colspan="1"><s:form class="well form-horizontal"
							method="post" modelAttribute="ruser"
							action="${pageContext.request.contextPath}/editsave">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:hidden path="userId" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="username">Username</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="username" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="username" id="username" placeholder="Username" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="firstName">First Name</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="firstName" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="firstName" id="firstName" placeholder="firstName" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="lastName">Last Name</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="lastName" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="lastName" id="lastName" placeholder="lastName" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="emailAddress">Email</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:errors path="emailAddress" cssClass="error" />
										</div>
										<div class="input-group">
											<s:input autocomplete="off" class="form-control" path="emailAddress"
												id="ememailAddressail" placeholder="Email" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="division">Division</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:input autocomplete="off" class="form-control"
												path="division" id="division" placeholder="Division" />
											<s:errors path="division" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Role</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:checkbox path="role" value="Y" />
											<s:errors path="role" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<input type="submit" value="Update" class="btn btn-primary" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="password"></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<s:hidden path="password" />
										</div>
									</div>
								</div>
							</fieldset>
						</s:form></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script
		src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
