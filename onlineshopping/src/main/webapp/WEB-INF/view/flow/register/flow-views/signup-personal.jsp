<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="../include/flow-header.jsp" />
<core:url var="radioCss" value="/resources/css/radio.css"/>
<link href="${radioCss}" rel="stylesheet">
<!-- Header -->
<core:url var="logo" value="/resources/images/userIcon.png" />
<!-- Page Content -->
<div class="container">
	<jsp:include page="../include/flow-navigation-bar.jsp" />

	<div class="container register" >
		<form:form modelAttribute="userRegister" method="POST">
			<div class="row" style="padding-top: 5%; padding-bottom: 5%;">
				<div class="col-md-3 register-left">
					<img src="${logo}" alt="" width="100" height="100"
						style="width: auto;" />
					<h3 style="color: #FFF;">User Account</h3>
					<p style="color: #FFF;">Create A New User Account. Please Enter
						Your Personal Details</p>
				</div>
				<div class="col-md-9 register-right">
					<div class="tab-content" id="myTabContent">
						<!-- User -->
						<div class="tab-pane fade show active" id="userRegisterTab" role="tabpanel"
							aria-labelledby="user-tab">
							<h3 class="register-heading" style="color: #FFF;">Create New
								User Account</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" path="userFirstName"
											class="form-control" name="userFirstName"
											placeholder="First Name *" value="" maxlength="50"
											minlength="1" required="true"/>
										<form:errors path="userFirstName" cssClass="error-tip"
											element="div" />
									</div>
									<div class="form-group">
										<form:input type="text" path="userLastName"
											class="form-control" name="userLastName"
											placeholder="Last Name *" value="" maxlength="50"
											minlength="1" required="true"/>
										<form:errors path="userLastName" cssClass="error-tip"
											element="div" required="true"/>
									</div>
									<div class="form-group">
										<form:input type="email" class="form-control"
											path="userEmailAddress" name="userEmailAddress"
											placeholder="Email Address *" value="" maxlength="50" required="true"/>
										<form:errors path="userEmailAddress" cssClass="error-tip"
											element="div" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="password" class="form-control"
											path="userPassword" name="userPassword"
											placeholder="Password *" value="" required="true"/>
										<form:errors path="userPassword" cssClass="error-tip"
											element="div" />
									</div>
									<div class="form-group">
										<form:input type="text" path="userPhoneNumber"
											class="form-control" name="userPhoneNumber"
											placeholder="Phone Number *" value="" required="true"/>
										<form:errors path="userPhoneNumber" cssClass="error-tip"
											element="div" />
									</div>
									<div class="form-group">
										<span style="color:white;font-size: 15px;font-weight: bold;">Account Type:  </span>
										<label for="opt1" class="radio"> <form:radiobutton 
											name="rdo" id="opt1" value = "USER" class="hidden" path="userRole" checked="true"/> <span class="label"></span>User
										</label> <label for="opt2" class="radio"> <form:radiobutton 
											name="rdo" id="opt2" value="SUPPLIER" class="hidden" path="userRole"/> <span class="label"></span>Supplier
										</label>
									</div>
									<button type="submit" class="btnRegister"
										name="_eventId_billing">
										Next - Billing <i class="fa fa-chevron-right"
											aria-hidden="true"></i><i class="fa fa-chevron-right"
											aria-hidden="true"></i>
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
<!-- Footer -->
<jsp:include page="../include/flow-footer.jsp" />
<!-- Footer -->