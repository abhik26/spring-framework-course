<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h2>Welcome to the home page</h2>
	<hr/>
	<p>
		User: <security:authentication property="principal.username" />
		<br/><br/>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<security:authorize access="hasAnyRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasAnyRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				Meeting</a> (Only for System peeps)
		</p>
	</security:authorize>
	<hr/>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<button>Logout</button>
	</form:form>
</body>
</html>