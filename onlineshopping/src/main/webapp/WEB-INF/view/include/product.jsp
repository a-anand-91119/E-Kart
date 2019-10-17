<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<core:url var="home" value="/home" />
<core:url  var = "categoryUrl" value="/category/${category.categoryId}/products"/>

<div class="container">

	<div class="row">

		<jsp:include page="sidebar.jsp"></jsp:include>

		<div class="col-lg-9">
		
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${home}">Home</a></li>
				<li class="breadcrumb-item"><a href = "${categoryUrl}">${category.categoryName}</a></li>
				<li class="breadcrumb-item active">${productInformation.productName}</li>
			</ol>
			
			<div class="card mt-4">

				<img class="card-img-top img-fluid"
					style="height: 300px; width: 100%;"
					src="${pageContext.request.contextPath}/resources/images/${productInformation.productLandscapeUrl}"
					alt="${productInformation.productName}"
					title="${productInformation.productName}">
				<div class="card-body">
					<h3 class="card-title">${productInformation.productName}</h3>
					<h4>&#x20b9; ${productInformation.productUnitPrice}</h4>

					<core:choose>
						<core:when test="${productInformation.productQuantity le 0}">
							<strong style="color: red;">Out Of Stock!!</strong><br>
							<br>
						</core:when>
						<core:when
							test="${productInformation.productQuantity gt 0 and productInformation.productQuantity le 5}">
							<strong style="color: brown;">Only
								${productInformation.productQuantity} Left In Stock</strong><br>
							<br>
						</core:when>
						<core:when test="${productInformation.productQuantity gt 5}">
							<strong style="color: green;">In Stock</strong><br>
							<br>
						</core:when>
					</core:choose>

					<p class="card-text">${productInformation.productDescription}</p>
					<core:choose>
						<core:when test="${productInformation.productOverallrating eq 0}">
							<span class="text-warning">&#9734; &#9734; &#9734; &#9734;
								&#9734;</span>
						</core:when>
						<core:when test="${productInformation.productOverallrating eq 1}">
							<span class="text-warning">&#9733; &#9734; &#9734; &#9734;
								&#9734;</span>
						</core:when>
						<core:when test="${productInformation.productOverallrating eq 2}">
							<span class="text-warning">&#9733; &#9733; &#9734; &#9734;
								&#9734;</span>
						</core:when>
						<core:when test="${productInformation.productOverallrating eq 3}">
							<span class="text-warning">&#9733; &#9733; &#9733; &#9734;
								&#9734;</span>
						</core:when>
						<core:when test="${productInformation.productOverallrating eq 4}">
							<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
								&#9734;</span>
						</core:when>
						<core:when test="${productInformation.productOverallrating eq 5}">
							<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
								&#9733;</span>
						</core:when>
					</core:choose>
					${productInformation.productOverallrating} stars &#160;&#160;
					<core:choose>
						<core:when test="${productInformation.productQuantity le 0}">
							<a href="javascript:void(0)" class="btn btn-success disabled"
								style="float: right;"> Add To Cart &#160; <i
								class="fa fa-cart-plus" aria-hidden="true"></i></a>
						</core:when>
						<core:when test="${productInformation.productQuantity gt 0}">
							<a href="#" class="btn btn-success" style="float: right;">
								Add To Cart &#160; <i class="fa fa-cart-plus" aria-hidden="true"></i>
							</a>
						</core:when>
					</core:choose>

				</div>
			</div>
			<!-- /.card -->

			<div class="card card-outline-secondary my-4">
				<div class="card-header">Product Reviews</div>
				<div class="card-body">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Omnis et enim aperiam inventore, similique necessitatibus neque
						non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
						Sequi mollitia, necessitatibus quae sint natus.</p>
					<small class="text-muted">Posted by Anonymous on 3/1/17</small>
					<hr>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Omnis et enim aperiam inventore, similique necessitatibus neque
						non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
						Sequi mollitia, necessitatibus quae sint natus.</p>
					<small class="text-muted">Posted by Anonymous on 3/1/17</small>
					<hr>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
						Omnis et enim aperiam inventore, similique necessitatibus neque
						non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
						Sequi mollitia, necessitatibus quae sint natus.</p>
					<small class="text-muted">Posted by Anonymous on 3/1/17</small>
					<hr>
					<a href="#" class="btn btn-success">Leave a Review</a>
				</div>
			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>