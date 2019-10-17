<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored = "false" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>

<core:url var = "home" value = "/home"/>
<script>
window.showUrl= '${pageContext.request.contextPath}/show/product/';
window.cartUrl= '${pageContext.request.contextPath}/cart/add/';
window.imageUrl = '${pageContext.request.contextPath}/resources/images/';
</script>
<div class="container">

	<div class="row">

		<jsp:include page="sidebar.jsp"></jsp:include>

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">

					<core:set var="counter" value="0" scope="page" />
					<core:set var="flag" value="true" />
					<core:forEach items="${topProducts}" var="topProductData">
						<li data-target="#carouselExampleIndicators"
							data-slide-to="${counter}"
							<core:if test="${flag == true}">class="active"</core:if>></li>
						<core:set var="counter" value="${counter + 1}" scope="page" />
						<core:if test="${flag == true}">
							<core:set var="flag" value="false" />
						</core:if>
					</core:forEach>
				</ol>

				<div class="carousel-inner" role="listbox">
					<core:set var="flag" value="true" />
					<core:forEach items="${topProducts}" var="topProductData">
						<div
							class="carousel-item <core:if test="${flag == true}">active</core:if>">
							<core:if test="${flag == true}">
								<core:set var="flag" value="false" />
							</core:if>
							<a href="/show/product/${topProductData.productCode}"><img
								class="d-block img-fluid" style="height: 300px; width: 100%;"
								src="${pageContext.request.contextPath}/resources/images/${topProductData.productImageUrl}"
								alt="${topProductData.productName}"
								title="${topProductData.productName}"> </a>
						</div>
					</core:forEach>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<core:if test="${userClickedOption eq 'allProducts'}">
				<script>
					window.jsonUrl = '${pageContext.request.contextPath}/json/data/allProducts';
				</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${home}">Home</a></li>
					<li class="breadcrumb-item active">All Products</li>
				</ol>
			</core:if>
 
			<core:if test="${userClickedOption eq 'category'}">
				<script>
					window.jsonUrl = '${pageContext.request.contextPath}/json/data/category/${category.categoryId}/products';
				</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${home}">Home</a></li>
					<li class="breadcrumb-item">Category</li>
					<li class="breadcrumb-item active">${category.categoryName}</li>
				</ol>
			</core:if>

			<div class="row" style = "margin-bottom: 20px;">
				<div class="col-lg-12">
					<table id="productListTable"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Rating</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Image</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Rating</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->