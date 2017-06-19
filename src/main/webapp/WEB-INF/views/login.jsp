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

<title>Login Page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />"	rel="stylesheet">

</head>
<body>

	<%@ include file="/WEB-INF/views/template/nav-bar.jsp"%>

	<div class="container-wrapper">
	    <div class="container">
	        <div id="login-box">
	
	            <h2>Login with Username and Password</h2>
	
	            <c:if test="${not empty logoutMsg}">
	                <div class="msg">${logoutMsg}</div>
	            </c:if>
	
	            <form name="loginForm" action="<c:url value="/login" />" method="post">
	                <c:if test="${not empty error}">
	                    <div class="error" style="color: #ff0000;">${error}</div>
	                </c:if>
	                <div class="form-group">
	                    <label for="username">User: </label>
	                    <input type="text" id="username" name="username" class="form-control" />
	                </div>
	                <div class="form-group">
	                    <label for="password">Password:</label>
	                    <input type="password" id="password" name="password" class="form-control" />
	                </div>
	
	                <input type="submit" value="Submit" class="btn btn-default">
	
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	            </form>
	
	        </div>
	    </div>
	</div>

	<%@ include file="/WEB-INF/views/template/footer.jsp"%>

</body>
</html>