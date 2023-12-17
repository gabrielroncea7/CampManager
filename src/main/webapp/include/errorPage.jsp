<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
	<body>
	<fieldset>
		<legend>ERROR ${pageContext.errorData.statusCode}</legend>
		<p>Ha ocurrido un error</p>
		<form id="volver" method="get" action="/Practica3/src/main/webapp/mvc/controller/logOutController.jsp">
			<input type="submit" value="De acuerdo"/>
		</form>
	</fieldset>
	</body>
</html>