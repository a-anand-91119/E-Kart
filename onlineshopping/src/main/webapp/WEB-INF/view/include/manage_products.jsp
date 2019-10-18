<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container register">
	<core:if test="${not empty message}">
		<script>
		Swal.fire({
			  type: 'success',
			  title: 'Product Successfully Saved!',
			  showConfirmButton: false,
			  timer: 3000,
			  footer: 'Your Product Is Now Visible To Million Of E-Kart Users'
			})
		</script>
	</core:if>
	<form:form modelAttribute="productData" action="save" method="POST">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Product Management</h3>
				<p>Here You Can Add, Edit, Delete Your Products</p>
				<!-- <input type="submit" name="" value="Login" /><br /> -->
			</div>
			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Add A New Product</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<form:input type="text" path="productName" class="form-control"
										name="productName" placeholder="Product Name*" value="" />
								</div>
								<div class="form-group">
									<form:input type="text" path="productSpecification"
										class="form-control" name="productSpecification"
										placeholder="Product Specification *" value="" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control"
										path="productBrand" name="productBrand"
										placeholder="Product Brand *" value="" />
								</div>
								<div class="form-group">
									<form:textarea rows="5" cols="5" minlength="100"
										path="productDescription" class="form-control"
										name="productDescription" placeholder="Product Description *"></form:textarea>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<form:input type="number" class="form-control"
										path="productUnitPrice" name="productUnitPrice"
										placeholder="Product Unit Price *" value="" />
								</div>
								<div class="form-group">
									<form:input type="number" path="productQuantity"
										class="form-control" name="productQuantity"
										placeholder="Quantity Available *" value="" />
								</div>
								<div class="form-group">
									<form:select class="form-control" path="productCategoryId"
										name="productCategory">
										 <form:option value="0" label="Please Choose A Category" disabled="true"/>
										<form:options items="${categories}" itemLabel="categoryName"
											itemValue="categoryId" />
									</form:select>
								</div>
								<form:hidden path="productPurchases" />
								<form:hidden path="productViews" />
								<form:hidden path="productRating1" />
								<form:hidden path="productRating2" />
								<form:hidden path="productRating3" />
								<form:hidden path="productRating4" />
								<form:hidden path="productRating5" />
								<form:hidden path="productPortraitUrl" />
								<form:hidden path="productLandscapeUrl" />
								<form:hidden path="productOverallrating" />
								<input type="submit" class="btnRegister" value="Save Product" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>