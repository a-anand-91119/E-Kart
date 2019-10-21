<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="function"
	uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<core:url var="home" value="/home" />
<core:url var="addProduct" value="/manage/products/add" />
<core:url var="switchCss" value="/resources/css/switch.css" />

<link href="${switchCss}" rel="stylesheet">
<script>
	window.showUrl = '${pageContext.request.contextPath}/show/product/';
	window.imageUrl = '${pageContext.request.contextPath}/resources/images/';
	window.editUrl = '${pageContext.request.contextPath}/manage/product/';
</script>

<div class="container">
	<core:if test="${message eq 'insertSuccess'}">
		<script>
			Swal
					.fire({
						type : 'success',
						title : 'Product Successfully Saved!',
						showConfirmButton : false,
						timer : 2000,
						footer : 'Your Product Is Now Visible To Million Of E-Kart Users'
					})
		</script>
	</core:if>
	<core:if test="${message eq 'updateSuccess'}">
		<script>
			Swal
					.fire({
						type : 'success',
						title : 'Product Successfully Updated!',
						showConfirmButton : false,
						timer : 2000,
						footer : 'Your Product Is Now Visible To Million Of E-Kart Users'
					})
		</script>
	</core:if>
	<core:if test="${message eq 'categorySaveSuccess'}">
		<script>
			Swal.fire({
				type : 'success',
				title : 'Category Created Successfully!',
				showConfirmButton : false,
				timer : 1000,
				footer : 'You Can Now Add Products To The New Category'
			})
		</script>
	</core:if>
	<core:if test="${message eq 'categorySaveFailed'}">
		<script>
			Swal.fire({
				type : 'error',
				title : 'Failed To Create Category!',
				showConfirmButton : false,
				timer : 1000,
				footer : 'Please Try Again or Contact Admin'
			})
		</script>
	</core:if>
	<div class="row">

		<script>
			window.adminJsonUrl = '${pageContext.request.contextPath}/json/data/manage/products';
			window.activationUrl = '${pageContext.request.contextPath}/manage/products/';
		</script>

		<div class="row" style="margin-bottom: 20px;">
			<div class="col-lg-12" style="margin-bottom: 20px;">
				<span style="font-size: 40px;">Manage All Products</span>
				<div style="float: right; align-items: center; padding-top: 20px;">
					<button type="button" data-toggle="modal"
						data-target="#addCategoryModal" class="btn btn-warning">
						<strong>Add Category</strong>
					</button>
					<a href="${addProduct}"><button type="button"
							data-toggle="modal" data-target="#addCategoryModal"
							class="btn btn-warning">
							<strong>Add New Product</strong>
						</button></a>
				</div>
			</div>
			<div class="col-lg-12">
				<table id="adminProductsTable"
					class="table table-striped table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th>Id</th>
							<th>Image</th>
							<th>Product Code</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>4</td>
							<td><img src="' + imageUrl + data + '"
								style="text-align: center; align-content: center; width: 100%; height: 140px;"
								alt="OnePlus 7T PRO" /></td>
							<td>PRDOP7P53999</td>
							<td><strong>OnePlus 7T PRO</strong><br> <small>The
									all new OnePlus 7T Pro Powered by Qualcomm Snapdragon 855 Plus
									(Octa-core, 7nm, up to 2.96 GHz) with Qualcomm AI Engine.
									Equipped with 90hz Fluid display, a Triple Rear camera with
									Telephoto and Ultra wide angel lens, that can capture 4K video
									@ 30/60 FPS with modes like UltraShot, Nightscape, Portrait,
									Pro Mode, Panorama, HDR, AI Scene Detection, RAW Image. Face
									Unlock, HDR, Screen Flash, Face Retouching, In-built -
									Fingerprint.</small></td>
							<td>53999.00</td>
							<td>100</td>
							<td>
								<div class="toggle-btn active">
									<input type="checkbox" checked class="cb-value" /> <span
										class="round-btn"></span>
								</div>
							</td>
							<td><a href="javascript:void(0)" class="btn btn-success"><i
									class="fa fa-pencil" aria-hidden="true"></i> </a></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>Image</th>
							<th>Product Code</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<!-- /.row -->


	</div>
	<!-- /.row -->

	<!-- Add Category Modal -->
	<div class="modal fade" id="addCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="padding: 10px;">
				<div class="model-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 style="text-align: center;">Add New Category</h4>
				</div>
				<hr style="margin: 20px 0;" />
				<div class="modal-body">
					<form:form id="createNewCategory"
						modelAttribute="createNewCategory"
						action="${pageContext.request.contextPath}/manage/category/add"
						method="POST" class="form-horizontal"
						enctype="multipart/form-data">
						<div class="form-group">
							<form:input type="text" path="categoryName" class="form-control"
								name="categoryName" placeholder="Category Name*" value=""
								maxlength="100" required="true" minLength="5" />
						</div>
						<div class="form-group">
							<form:textarea rows="5" cols="5" minlength="100" required="true"
								path="categoryDescription" class="form-control"
								name="categoryDescription" placeholder="Category Description *"></form:textarea>
						</div>
						<div class="form-group">
							<form:input type="file" path="categoryThumbnail"
								class="form-control" name="categoryThumbnail" required="true"
								title="Select Category Thumbnail Image" value=""
								style="padding-bottom:45px;" />
						</div>
						<input type="submit" class="btnRegister" value="Create Category" />
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Add Category Modal -->
</div>
<!-- /.container -->