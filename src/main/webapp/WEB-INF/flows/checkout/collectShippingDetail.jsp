<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page isELIgnored="false"%>
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Shipping Details</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>Confirm Shipping Details:</h1>
			</div>

			<form:form commandName="order" class="form-horizontal">

		        <h3>Shipping Address</h3>
		        <div class="form-group">
		            <label for="streetName">Street Name</label>
		            <form:input path="cart.customer.shippingAddress.streetName" id="streetName" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="apartmentNumber">Apartment Numer</label>
		            <form:input path="cart.customer.shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="city">City</label>
		            <form:input path="cart.customer.shippingAddress.city" id="city" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="state">State</label>
		            <form:input path="cart.customer.shippingAddress.state" id="state" class="form-Control"/>
		        </div>		
		        <div class="form-group">
		            <label for="country">Country</label>
		            <form:input path="cart.customer.shippingAddress.country" id="country" class="form-Control"/>
		        </div>			
		        <div class="form-group">
		            <label for="zipCode">Zip Code</label>
		            <form:input path="cart.customer.shippingAddress.zipCode" id="zipCode" class="form-Control"/>
		        </div>		
		        
		        <input type="hidden" name="_flowExecutionKey">
						
		        <br><br>
		        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
		        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected">
		        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>			

			</form:form>
			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>