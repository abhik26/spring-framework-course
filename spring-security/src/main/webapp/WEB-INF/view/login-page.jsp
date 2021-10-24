<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Custom Login Page</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h3>Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticate-user"
		method="POST">
		<core:if test="${param.error != null}">
			<i class="error">Sorry! You have entered invalid
				username/password.</i>
		</core:if>
		<p>
			User name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<button>Login</button>
	</form:form>
</body>
</html>