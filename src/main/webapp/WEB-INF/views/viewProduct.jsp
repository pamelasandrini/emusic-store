<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page isELIgnored="false"%>
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Detail Info</title>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="<c:url value="/resources/js/angular-controller.js" /> "></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%-- <link href="<c:url value="/resources/css/main.css" />"	rel="stylesheet"> --%>	

</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>Product Detail</h1>
				<p class="lead">Here is the detail information of the product!</p>
			</div>

			<div class="container" ng-app="cartApp">
				<div class="row">
					<div class="col-md-5">
						<%--<img src="<c:url value="resources/image/${id}.png" />" alt="image" style="width: 100%"/> --%>
					</div>

					<div class="col-md-5">
						<h3>${product.productName}</h3>
						<p>${product.productDescription}</p>
						<p>
							<strong>Manufacturer: </strong> ${product.productManufacturer}
						</p>
						<p>
							<strong>Category: </strong>${product.productCategory}
						</p>
						<p>
							<strong>Condition: </strong>${product.productCondition}
						</p>
						<p>${product.productPrice}USD</p>
						
						<br>
						
	                    <c:set var="role" scope="page" value="${param.role}" />
	                    <c:set var="url" scope="page" value="/productList" />
	                    <c:if test="${role='admin'}">
	                        <c:set var="url" scope="page" value="/admin/productInventory" />
	                    </c:if>
	
	                    <p ng-controller="cartCtrl">
	                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
	                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
	                        <a href="<spring:url value="/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
	                    </p>						
					</div>
				</div>
			</div>

			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>