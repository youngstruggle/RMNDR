<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Report</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" />
<!-- <link
	href="${pageContext.request.contextPath}/resources/css/cssreset.css"
	rel="stylesheet" /> -->

<!-- JQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<script>
	$(document).ready(function() {
		$(function() {
			$("#tanggalInvoice").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	});

	$(document).ready(function() {
		$(function() {
			$("#tanggalTt").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	});

	$(document).ready(function() {
		$(function() {
			$("#tanggalJthTempo").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	});

	$(document).ready(function() {
		$(function() {
			$("#tanggalLunas").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	});
</script>

<!-- Css -->
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>
	<h1>${headerMessage}</h1>
	<!-- <s:errors path="reports.*" /> -->

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">CREATE INVOICE</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div>
					<div style="color: red" class="col-sm-5">${msg}</div>
				</div>
			</div>
		</div>
		<table class="table table-striped">
			<tbody>
				<tr>
					<s:form class="form-horizontal" modelAttribute="reports"
						action="${pageContext.request.contextPath}/submitreportform.html"
						method="post">
						<td colspan="1"><div class="form-horizontal">
								<!-- <s:errors path="*" cssClass="errorblock" element="div" /> -->
								<fieldset>
									<div class="form-group">
										<label class="col-md-4 control-label" for="customer">Customer</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="customer" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="customer" id="customer" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="remarks">Remarks</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="remarks" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="remarks" id="remarks" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="marketing">Marketing</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="marketing" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="marketing" id="marketing" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="nomorPajak">No
											Pajak</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="nomorPajak" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="nomorPajak" id="nomorPajak" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="tanggalTt">Tanggal
											TT</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="tanggalTt" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="tanggalTt" id="tanggalTt" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="tanggalJthTempo">Tanggal
											Jatuh Tempo</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="tanggalJthTempo" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="tanggalJthTempo" id="tanggalJthTempo" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="dpp">DPP</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="dpp" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control" path="dpp"
													id="dpp" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="pph">PPH</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="pph" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control" path="pph"
													id="pph" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="tanggalLunas">Tanggal
											Lunas</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="tanggalLunas" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="tanggalLunas" id="tanggalLunas" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label"></label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<a href="${pageContext.request.contextPath}/reportlist.html"
													class="btn btn btn-warning">Back</a> <input type="submit"
													value="Create" class="btn btn-primary" />
											</div>
										</div>
									</div>
								</fieldset>
							</div></td>
						<td colspan="1"><div class="form-horizontal">
								<fieldset>
									<div class="form-group">
										<label class="col-md-4 control-label" for="project">Project</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="project" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="project" id="project" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="noPo">No Po</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="noPo" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control" path="noPo"
													id="noPo" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="noInvoice">No
											Invoice</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="noInvoice" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="noInvoice" id="noInvoice" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="tanggalInvoice">Tanggal
											Invoice</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="tanggalInvoice" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="tanggalInvoice" id="tanggalInvoice" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="term">Term</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="term" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control" path="term"
													id="term" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="piutangUsaha">Piutang
											Usaha</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="piutangUsaha" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="piutangUsaha" id="piutangUsaha" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label" for="ppn">PPN</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="ppn" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control" path="ppn"
													id="ppn" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label" for="uangMasuk">Uang
											Masuk</label>
										<div class="col-md-8 inputGroupContainer">
											<div class="input-group">
												<s:errors path="uangMasuk" />
											</div>
											<div class="input-group">
												<s:input autocomplete="off" class="form-control"
													path="uangMasuk" id="uangMasuk" />
											</div>
										</div>
									</div>
								</fieldset>
							</div></td>
					</s:form>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
