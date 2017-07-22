<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page isELIgnored="false"%>
<meta name="description" content="">
<meta name="author" content="">

<title>View Cart</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="<c:url value="/resources/js/angular-controller.js" /> "></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">--%>
</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">
		<div class="container">
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1>Cart</h1>
						
						<p>All the selected products in your shopping cart!</p>
					</div>
				</div>
			</section>
			
			<section class="container" ng-app="cartApp">
				<div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
					<div>
						<a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
						<a href='<spring:url value="/order/${cartId}"></spring:url>' class="btn btn-success pull-right"><span class="glyphicon  glyphicon-shopping-cart"></span> Check out</a>
					</div>
					
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Unit Price</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
			                <tr ng-repeat = "item in cart.cartItems">
			                    <td>{{item.product.productName}}</td>
			                    <td>{{item.product.productPrice}}</td>
			                    <td>{{item.quantity}}</td>
			                    <td>{{item.totalPrice}}</td>
			                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)"><span class="glyphicon glyphicon-remove"></span> remove</a></td>
			                </tr>
							<tr>
								<td></td>
								<td></td>
								<td>Grand Total</td>
								<th>{{calGrandTotal()}}</th>
								<td></td>
							</tr>
						</tbody>
					</table>
					
					<a href='<spring:url value="/product/productList"></spring:url>' class="btn btn-default">Continue shopping</a>
				</div>
			</section>
			
			<br>
			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>
	</div>

</body>
</html>