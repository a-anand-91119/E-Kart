<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>E-Kart - ${title}</title>

<core:url var="bootstrapMinCss"
	value="/resources/vendor/bootstrap/css/bootstrap.min.css" />
<core:url var="bootstrapMinJs"
	value="/resources/vendor/bootstrap/js/bootstrap.min.js" />
<core:url var="bootstrapCss"
	value="/resources/vendor/bootstrap/css/bootstrap.css" />
<core:url var="pageCss" value="/resources/css/shop-homepage.css" />
<core:url var="registerCss" value="/resources/css/register.css" />
<core:url var="customJs" value="/resources/js/customJs.js" />
<core:url var="jqueryValidate"
	value="/resources/js/jquery.validate.js" />
<core:url var="fontAwesomeJs" value="/resources/js/font-awesome.js" />
<core:url var="jqueryDataTables"
	value="/resources/vendor/DataTables/jquery.dataTables.min.js" />
<core:url var="jqueryDataTablesCss"
	value="/resources/vendor/DataTables/jquery.dataTables.min.css" />
<core:url var="dataTablesBootstrapResponsiveCss"
	value="/resources/vendor/DataTables/dataTables.bootstrap4.min.css" />
<core:url var="dataTablesBootstrapResponsiveJs"
	value="/resources/vendor/DataTables/dataTables.bootstrap4.min.js" />
<core:url var="jQuery" value="/resources/vendor/jquery/jquery.min.js" />
<core:url var="bootstrapMinJs"
	value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />
<core:url var="urlSmartAlert"
	value="/resources/vendor/sweetalert2/sweetalert2.all.min.js" />
<core:url var="urlSmartAlertPolyfill"
	value="https://cdn.jsdelivr.net/npm/promise-polyfill" />

<link href="${bootstrapMinCss}" rel="stylesheet">
<link href="${bootstrapCss}" rel="stylesheet">
<link href="${pageCss}" rel="stylesheet">
<link href="${dataTablesBootstrapResponsiveCss}" rel="stylesheet">
<link href="${jqueryDataTablesCss}" rel="stylesheet">
<link href="${registerCss}" rel="stylesheet">

<script src="${urlSmartAlert}"></script>
<script src="${urlSmartAlertPolyfill}"></script>

<script type="text/javascript">
	window.menu = '${menu}';
</script>
</head>

<body>

	<div class="main-wrapper">

		<!-- Navigation -->
		<jsp:include page="flow-navigation-bar.jsp" />
		<!-- Navigation -->	