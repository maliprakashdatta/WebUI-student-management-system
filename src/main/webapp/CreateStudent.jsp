<!-- JSP Directive -->
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Student Management System</h1>
<form action="/studentManagementSystem/StudentController" method="POST">
	<label>Id : </label>
	<input type = "textbox" id ="id" name="id"/>
	<br/>

	<label>First Name: </label>
	<input type = "textbox" id ="firstname" name="firstname"/>
	<br/>

	<label>Last Name: </label>
	<input type = "textbox" id ="lastname" name="lastname"/>
	<br/>
	<label>Gender: </label>
	<input type = "radio" value="Male" id ="male" name="male">
		<label for="html">Male</label>
	</input>
	<input type = "radio" value="Female" id ="female" name="female">
		<label for="html">Female</label>
	</input>
	<br/>
	<label>Age: </label>
	<input type = "textbox" id ="age" name="age"/>

	<input type = "submit" value="Save Data"/>
</form>
</body>
</html>