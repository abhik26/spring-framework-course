<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	
	<style>
		.error {
			color: red;
		}
		
		div {
			margin: 10px 0px;
		}
	</style>
	<body>
		<form:form action="process-form" modelAttribute="student">
			<div>
				First Name*: <form:input path="firstName"/>
				<form:errors path="firstName" cssClass="error"/>
			</div>
			<div>
				Last Name: <form:input path="lastName"/>
			</div>
			<div>
				Country: 
				<form:select path="country">
					<form:option value="UK" label="United Kingdom"/>
					<form:option value="NZ" label="New Zealand"/>
					<form:options items="${countryOptions}"/>
				</form:select>
			</div>
			<div>
				Favorite Language: 
				<form:radiobutton path="favoriteLanguage" value="Java"/> Java
				<form:radiobutton path="favoriteLanguage" value="C#"/> C#
				<form:radiobutton path="favoriteLanguage" value="PHP"/> PHP
				<form:radiobutton path="favoriteLanguage" value="Ruby"/> Ruby
				<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
			</div>
			<div>
				Operating Systems: 
				<form:checkbox path="operatingSystems" value="Linux"/> Linux
				<form:checkbox path="operatingSystems" value="Mac OS"/> Mac OS
				<form:checkbox path="operatingSystems" value="Windows"/> Windows
			</div>
			<div>
				Free Passes: <form:input path="freePasses"/>
				<form:errors path="freePasses" cssClass="error"/>
			</div>
			<div>
				Postal Code: <form:input path="postalCode"/>
				<form:errors path="postalCode" cssClass="error"/>
			</div>
			<div>
				Course Code: <form:input path="courseCode"/>
				<form:errors path="courseCode" cssClass="error"/>
			</div>
			<div>
				<input type="submit" value="submit"/>
			</div>
		</form:form>
	</body>
</html>