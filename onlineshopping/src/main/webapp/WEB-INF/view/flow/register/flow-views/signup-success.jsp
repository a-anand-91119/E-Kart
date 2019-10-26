<!-- Header -->
<jsp:include page="../include/flow-header.jsp" />
<!-- Header -->

<!-- Page Content -->
<div class="container" style="padding-top: 20px;">
	<jsp:include page="../include/flow-navigation-bar.jsp" />
	
	<div class="row">
		<div class="col-lg-12">
			<div class="text-center">
			<h3>Congratulation!!</h3>
			<h5>Your Account Was Created Successfully. You May Now Login Now.</h5>
				<a href="${pageContext.request.contextPath}/login"
					class="btn btn-success" style="margin-top: 2%;padding:10px;">Login Here</a>
			</div>
		</div>
	</div>
</div>
<!-- Page Content -->

<!-- Footer -->
<jsp:include page="../include/flow-footer.jsp" />
<!-- Footer -->