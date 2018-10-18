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
		
		<div class="row">
		  <div class="col-md-12">
		  	  <label style="color: red">${msgdelete}</label>
		  	  <label style="color: blue">${msgcreate}</label>
		  </div>
		</div>
		  	  
		<div class="panel panel-primary">
			<div class="panel-heading">INVOICE LIST</div>
		</div>

		<table class="table" style="margin-top: -1.3em;">
			<thead style="background-color: #70a1cc;">
				<tr>
					<th style="color: white">Customer</th>
					<th style="color: white">Project</th>
					<th style="color: white">Marketing</th>
					<th style="color: white">No Invoice</th>
					<th style="color: white">Tgl Invoice</th>
					<th style="color: white">Tgl TT</th>
					<th style="color: white">Tgl Jatuh Tempo</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reportlist}" var="report">
					<tr>
						<td align="left">${report.customer}</td>
						<td align="left">${report.project}</td>
						<td align="center">${report.marketing}</td>
						<td align="center">${report.noInvoice}</td>

						<c:set value="${report.tanggalInvoice}" var="dateinvoice" />
						<fmt:parseDate value="${dateinvoice}" var="dateObjectInvoice" pattern="yyyy-MM-dd HH:mm:ss" />

						<c:set value="${report.tanggalTt}" var="datett" />
						<fmt:parseDate value="${datett}" var="dateObjectTt" pattern="yyyy-MM-dd HH:mm:ss" />

						<c:set value="${report.tanggalJthTempo}" var="datejthtempo" />
						<fmt:parseDate value="${datejthtempo}" var="dateObjectTempo" pattern="yyyy-MM-dd HH:mm:ss" />

						<td><fmt:formatDate value="${dateObjectInvoice}" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${dateObjectTt}" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${dateObjectTempo}" pattern="dd/MM/yyyy" /></td>

						<td><a class="btn btn-primary"
							href="${pageContext.request.contextPath}/reportsedit/${report.reportId}">Update</a></td>
						<td><a class="btn btn-danger"
							href="${pageContext.request.contextPath}/reportsdelete/${report.reportId}">Delete</a></td>
						<td><a class="btn btn-info" href="${pageContext.request.contextPath}/reminderreports/${report.reportId}">Reminder</a></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pull-left">
			<a href="${pageContext.request.contextPath}/createreportform.html"
				class="btn btn-primary">Create Invoice </a>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('.btn-danger').click(function(event) {
				event.preventDefault();
				if (confirm('Are you sure for delete this report?')) {
					window.location.href = this.getAttribute('href');
				} else {
					return false;
				}
			});
		});
	</script>

</body>
</html>
