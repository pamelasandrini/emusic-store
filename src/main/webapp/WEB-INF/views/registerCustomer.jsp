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

<title>Register Customer page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>Register Customer</h1>
				<p class="lead">Please fill in your information below:</p>
			</div>

			<form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">
		        
		        <h3>Basic Info</h3>
		        <div class="form-group">
		            <label for="customerName">Name</label>
		            <form:input path="customerName" id="customerName" class="form-Control"/>
		        </div>

		        <div class="form-group">
		            <label for="customerEmail">Email</label>
		            <form:input path="customerEmail" id="customerEmail" class="form-Control" type="email"/>
		        </div>	
		        	        
		        <div class="form-group">
		            <label for="customerPhone">Phone</label>
		            <form:input path="customerPhone" id="customerPhone" class="form-Control"/>
		        </div>
		        
		        <div class="form-group">
		            <label for="username">User name</label>
		            <form:input path="username" id="username" class="form-Control"/>
		        </div>	
		        <div class="form-group">
		            <label for="password">Password</label>
		            <form:password path="password" id="password" class="form-Control"/>
		        </div>			        	        			        	        

		        <h3>Billing Address</h3>
		        <div class="form-group">
		            <label for="streetName">Street Name</label>
		            <form:input path="billingAddress.streetName" id="streetName" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="apartmentNumber">Apartment Numer</label>
		            <form:input path="billingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="city">City</label>
		            <form:input path="billingAddress.city" id="city" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="state">State</label>
		            <form:input path="billingAddress.state" id="state" class="form-Control"/>
		        </div>		
		        <div class="form-group">
		            <label for="country">Country</label>
		            <form:input path="billingAddress.country" id="country" class="form-Control"/>
		        </div>			
		        <div class="form-group">
		            <label for="zipCode">Zip Code</label>
		            <form:input path="billingAddress.zipCode" id="zipCode" class="form-Control"/>
		        </div>		
		        
		        <h3>Shipping Address</h3>
		        <div class="form-group">
		            <label for="streetName">Street Name</label>
		            <form:input path="shippingAddress.streetName" id="streetName" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="apartmentNumber">Apartment Numer</label>
		            <form:input path="shippingAddress.apartmentNumber" id="apartmentNumber" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="city">City</label>
		            <form:input path="shippingAddress.city" id="city" class="form-Control"/>
		        </div>
		        <div class="form-group">
		            <label for="state">State</label>
		            <form:input path="shippingAddress.state" id="state" class="form-Control"/>
		        </div>		
		        <div class="form-group">
		            <label for="country">Country</label>
		            <form:input path="shippingAddress.country" id="country" class="form-Control"/>
		        </div>			
		        <div class="form-group">
		            <label for="zipCode">Zip Code</label>
		            <form:input path="shippingAddress.zipCode" id="zipCode" class="form-Control"/>
		        </div>				        			        	                		        		        
						
		        <br><br>
		        <input type="submit" value="submit" class="btn btn-default">
		        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>				

			</form:form>
			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>