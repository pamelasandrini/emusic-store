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

<title>Administrator page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>Administrator page</h1>
				<p class="lead">This is the admin page!</p>
			</div>
			


			<h3>
				<a href="<c:url value="/admin/productInventory" />">Product Inventory</a>
			</h3>
			<p>Here you can view and edit the product inventory!</p>

			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>

	</div>

</body>
</html>