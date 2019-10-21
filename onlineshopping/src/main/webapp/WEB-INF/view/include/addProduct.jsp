<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<core:url value="/resources/images/logo.png" var="logo" />

<div class="container register">
	
	<form:form modelAttribute="productData" action="save" method="POST"
		enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="${logo}" alt="" width="100" height="100"
					style="width: auto;" />
				<h3 style="color: #FFF;">Product Management</h3>
				<p style="color: #FFF;">Here You Can Add, Edit, Delete Your
					Products</p>
				<!-- <input type="submit" name="" value="Login" /><br /> -->
			</div>
			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading" style="color: #FFF;">Add A New
							Product</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<div class="form-group">
									<form:input type="text" path="productName" class="form-control"
										name="productName" placeholder="Product Name*" value=""
										maxlength="100" />
									<form:errors path="productName" cssClass="error-tip"
										element="div" />
								</div>
								<div class="form-group">
									<form:input type="text" path="productSpecification"
										class="form-control" name="productSpecification"
										placeholder="Product Specification" value="" maxlength="2000" />
									<form:errors path="productSpecification" cssClass="error-tip"
										element="div" />
								</div>
								<div class="form-group">
									<form:input type="text" class="form-control"
										path="productBrand" name="productBrand"
										placeholder="Product Brand *" value="" maxlength="50" />
									<form:errors path="productBrand" cssClass="error-tip"
										element="div" />
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
									<form:errors path="productUnitPrice" cssClass="error-tip"
										element="div" />
								</div>
								<div class="form-group">
									<form:input type="number" path="productQuantity"
										class="form-control" name="productQuantity"
										placeholder="Quantity Available (0)" value="" />
								</div>

								<div class="form-group">
									<form:input type="file" path="productLandscapeImage"
										class="form-control" name="productLandscapeImage"
										title="Select A Landscape Image" value=""
										style="padding-bottom:45px;" />
									<form:errors path="productLandscapeImage" cssClass="error-tip"
										element="div" />
								</div>

								<div class="form-group">
									<form:input type="file" path="productPortraitImage"
										class="form-control" name="productPortraitImage"
										title="Select A Portrait Image" value=""
										style="padding-bottom:45px;" />
									<form:errors path="productPortraitImage" cssClass="error-tip"
										element="div" />
								</div>

								<div class="form-group">
									<form:select class="form-control" path="productCategoryId"
										name="productCategory">
										<form:option value="0" label="Please Choose A Category *"
											disabled="true" selected="true" />
										<form:options items="${categories}" itemLabel="categoryName"
											itemValue="categoryId" />
									</form:select>
									<form:errors path="productCategoryId" cssClass="error-tip"
										element="div" />
								</div>

								<form:hidden path="productId" />
								<form:hidden path="productSupplierId" />
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