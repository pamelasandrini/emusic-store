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
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
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
			
			<section class="container">
				<div>
					<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
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
						<tr>
							<td>productName</td>
							<td>productPrice</td>
							<td>quantity</td>
							<td>totalPrice</td>
							<td>remove button</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td>Grand Total</td>
							<td>grandTotal</td>
							<td></td>
						</tr>
					</tbody>
				</table>
				
				<a href='<spring:url value="/productList"></spring:url>'>Continue shopping</a>
			</section>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>