<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar-wrapper">
	<div class="container">

		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">My Music Store</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/" />">Home</a></li>
						<li><a href="<c:url value="/productList" />">Products</a></li>
						<li><a href="#contact">Contact</a></li>
						<li><a href="<c:url value="/admin" />">Admin</a></li>
						
						<%-- leave this comment for future reference
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li> --%>
							
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a>Welcome ${pageContext.request.userPrincipal.name} | </a></li>
								<li><a href="<c:url value="/logout" />">Logout</a></li>
							</c:if>
					</ul>
				</div>
			</div>
		</nav>

	</div>
</div>