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

<title>Successfully Registration</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">--%>
</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">
		<div class="container">
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1>Customer registered successfully!</h1>
					</div>
				</div>
			</section>

			<section class="container">
				<p>
					<a href='<spring:url value="/product/productList"></spring:url>' class="btn btn-default">Check out the Products</a>
				</p>
			</section>

			<br>
			<%@ include file="/WEB-INF/views/template/footer.jsp"%>
		</div>
	</div>

</body>
</html>