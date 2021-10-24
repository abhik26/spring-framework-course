<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student Confirmation</title>
		<style>
			div {
				margin: 10px 0px;
			}
		</style>
	</head>
	<body>
		<div>
			The student has been successfully registered: ${student.firstName} ${student.lastName}
		</div>
		<div>
			Country: ${student.country}
		</div>
		<div>
			Student's favorite language: ${student.favoriteLanguage}
		</div>
		<div>
			Operating Systems: 
			<ul>
				<c:forEach var="temp" items="${student.operatingSystems}">
					<li>${temp}</li> 
				</c:forEach>
			</ul>
		</div>
		<div>
			free passes: ${student.freePasses}	
		</div>
		<div>
			Postal Code: ${student.postalCode}
		</div>
		<div>
			Course Code: ${student.courseCode}
		</div>
	</body>
</html>