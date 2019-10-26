<!-- Header -->
<jsp:include page="../include/flow-header.jsp" />
<!-- Header -->
<jsp:include page="../include/flow-navigation-bar.jsp" />
<!-- Page Content -->
<div class="container" style="margin-top: 3%;">
	<div class="row" style= "margin-bottom: 15px;">
		<div class="col-lg-12">
			<div class="text-center">
				<span style="font-size: 25px;">Please Confirm The Entered Details</span>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">

			<div class="card">
				<div class="card-header">Personal Details</div>
				<div class="card-body">
					<div class="text-center">
						<h6>${registrationModel.userRegister.userFirstName}
							${registrationModel.userRegister.userLastName}</h6>
						<h6>Email Address:
							${registrationModel.userRegister.userEmailAddress}</h6>
						<h6>Phone Number:
							${registrationModel.userRegister.userPhoneNumber}</h6>
						<h6>Role: ${registrationModel.userRegister.userRole}</h6>
					</div>
				</div>
				<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Edit Personal Details</a>
				</div>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="card">
				<div class="card-header">Billing Details</div>
				<div class="card-body">
					<div class="text-center">
						<h6>${registrationModel.addressTO.addressLineOne}</h6>
						<h6>${registrationModel.addressTO.addressLineTwo}</h6>
						<h6>${registrationModel.addressTO.addressCity}-
							${registrationModel.addressTO.addressPostalCode}</h6>
						<h6>${registrationModel.addressTO.addressState}-
							${registrationModel.addressTO.addressCountry}</h6>
					</div>
				</div>
				<div class="card-footer">
					<a href="${flowExecutionUrl}&_eventId_billing"
						class="btn btn-primary">Edit Billing Address</a>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="text-center">
				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-warning" style="margin-top: 5%;">Confirm &amp;
					Create Account</a>
			</div>
		</div>
	</div>
</div>
<!-- Page Content -->

<!-- Footer -->
<jsp:include page="../include/flow-footer.jsp" />
<!-- Footer -->