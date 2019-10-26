<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="../include/flow-header.jsp" />
<!-- Header -->
<core:url var="logo" value="/resources/images/address.png" />
<!-- Page Content -->
<div class="container">

	<jsp:include page="../include/flow-navigation-bar.jsp" />

	<div class="container register">
		<form:form modelAttribute="billingAddress" method="POST">
			<div class="row" style="padding-top: 5%; padding-bottom: 5%;">
				<div class="col-md-3 register-left">
					<img src="${logo}" alt="" width="100" height="100"
						style="width: auto;" />
					<h3 style="color: #FFF;">Billing Address</h3>
					<p style="color: #FFF;">Please Enter Your Billing Address</p>
				</div>
				<div class="col-md-9 register-right">
					<div class="tab-content" id="myTabContent">
						<!-- User -->
						<div class="tab-pane fade show active" id="userRegisterTab"
							role="tabpanel" aria-labelledby="user-tab">
							<h3 class="register-heading" style="color: #FFF;">Enter Your
								Billing Address</h3>
							<div class="row register-form">
								<div class="col-md-5">
									<div class="form-group">
										<form:textarea rows="5" cols="5" minlength="30"
											path="addressLineOne" class="form-control"
											name="addressLineOne" placeholder="Address Line One *"
											required="true"></form:textarea>
									</div>
									<div class="form-group">
										<form:textarea rows="5" cols="5" minlength="30"
											path="addressLineTwo" class="form-control"
											name="addressLineTwo" placeholder="Address Line Two *"
											required="true"></form:textarea>
									</div>
								</div>
								<div class="col-md-7">
									<div class="form-group">
										<form:input type="text" class="form-control"
											path="addressCity" name="addressCity" placeholder="City *"
											value="" maxlength="100" required="true" />
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control"
											path="addressState" name="addressState" placeholder="State *"
											value="" required="true" />
									</div>
									<div class="form-group">
										<form:input type="text" path="addressCountry"
											class="form-control" name="addressCountry"
											placeholder="Country *" value="" required="true" />
									</div>
									<div class="form-group">
										<form:input type="text" path="addressPostalCode"
											class="form-control" name="addressPostalCode"
											placeholder="Postal Code *" value="" required="true" />
									</div>

									<button class="btnRegister"
										name="_eventId_confirm">
										Next - Confirm <i class="fa fa-chevron-right"
											aria-hidden="true"></i><i class="fa fa-chevron-right"
											aria-hidden="true"></i>
									</button>
									<button type="submit" class="btnRegister"
										name="_eventId_personal">
										<i class="fa fa-chevron-left" aria-hidden="true"></i><i
											class="fa fa-chevron-left" aria-hidden="true" onclick="goBack()"></i> Back -
										Personal
									</button>
								</div>
							</div>
						</div>
						<!-- User -->
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>
<!-- Page Content -->
<script type="text/javascript">
function goBack(){
	alert("insideBacl");
}
</script>
<!-- Footer -->
<jsp:include page="../include/flow-footer.jsp" />
<!-- Footer -->