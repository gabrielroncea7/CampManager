<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/styles.css"></head>
	<title>PR&Aacute;CTICA 3</title>
</head>
<body>
		<div class="cuadro">
			<div class="container-center">
				<div class="header">
					<h1 class="page-title">ERROR</h1>
					    <h2>Error en la aplicación</h2>
   						 <p>${exception}</p>
					<p id="bienvenida"></p>
				</div>
				<div class="main">
					<button type="button" class="small-button" onclick="window.location.href='<%= request.getContextPath() %>/index.jsp'">Volver al inicio</button>
					
				</div>
			</div>
		</div>
</body></html>