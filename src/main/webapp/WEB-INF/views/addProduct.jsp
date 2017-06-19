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

<title>Add Product</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">

		<div class="container">
			<div class="page-header">
				<h1>Add Product</h1>
				<p class="lead">Fill the below information to add a product:</p>
			</div>

			<!-- to upload file add the enctype multipart/form-data -->
			<form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" enctype="multipart/form-data" commandName="product">
		        <div class="form-group">
		            <label for="name">Name</label> <form:errors path="productName" clas="errors" />
		            <form:input path="productName" id="name" class="form-Control"/>
		        </div>
		
		        <div class="form-group">
		            <label for="category">Category</label>
		            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument" />Instrument</label>
		            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record" />Record</label>
		            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory" />Accessory</label>
		        </div>
		
		        <div class="form-group">
		            <label for="description">Description</label>
		            <form:textarea path="productDescription" id="description" class="form-Control"/>
		        </div>
		
		        <div class="form-group">
		            <label for="price">Price</label> <form:errors path="productPrice" clas="errors"  />
		            <form:input path="productPrice" id="price" class="form-Control"/>
		        </div>
		
		        <div class="form-group">
		            <label for="condition">Condition</label>
		            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new" />New</label>
		            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used" />Used</label>
		        </div>
		
		        <div class="form-group">
		            <label for="status">Status</label>
		            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active" />Active</label>
		        </div>
		
		        <div class="form-group">
		            <label for="unitInStock">Unit In Stock</label> <form:errors path="unitInStock" clas="errors" />
		            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
		        </div>
		
		        <div class="form-group">
		            <label for="manufacturer">Manufacturer</label>
		            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
		        </div>
		
		        <div class="form-group">
		            <label class="control-label" for="productImage">Upload Picture</label>
		            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
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