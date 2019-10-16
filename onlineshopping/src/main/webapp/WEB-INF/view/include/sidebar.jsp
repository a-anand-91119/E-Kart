<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-3">

	<h1 class="my-4">Departments</h1>
	<div class="list-group">
		
		<core:forEach items = "${categorySidebarData}" var = "category">
			<core:url  var = "categoryUrl" value="/category/${category.categoryId}/products"/>
			<a href="${contextRoot}${categoryUrl}" class="list-group-item" id="side_${category.categoryName}">${category.categoryName}</a> 
		</core:forEach>
	</div>

</div>
<!-- /.col-lg-3 -->