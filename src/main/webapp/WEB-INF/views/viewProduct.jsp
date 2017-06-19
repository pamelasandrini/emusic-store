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

<title>Detail Info</title>
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

			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<img src="<c:url value="resources/image/${id}.png" />" alt="image" style="width: 100%"/>
					</div>

					<div class="col-md-5">
						<h3>${product.productName}</h3>
						<p>${product.productDescription}</p>
						<p>
							<strong>Manufacturer: </strong> ${product.productManufacturer}
						</p>
						<p>
							<strong>Category: </strong>${product.productCategory}</p>
						<p>
							<strong>Condition: </strong>${product.productCondition}</p>
						<p>${product.productPrice}USD</p>
					</div>
				</div>
			</div>

			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>