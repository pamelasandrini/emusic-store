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
<link rel="icon" href="../../favicon.ico">

<title>Product List</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>All products</h1>
				<p class="lead">Check out all the awesome products available
					now!</p>
			</div>
			<table class="table table-striped table-hover">

				<thead class="bg-success">

					<tr>
						<th>Photo Thumb</th>
						<th>Product Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Condition</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td><img src="#" alt="image" /></td>
							<td>${product.productName}</td>
							<td>${product.productCategory}</td>
							<td>${product.productDescription}</td>
							<td>${product.productCondition}</td>
							<td>${product.productPrice} USD</td>
							<td><a
								href='<spring:url value="/product/productList/viewProduct/${product.id}" />'>
									<span class="glyphicon glyphicon-info-sign"> </span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>