<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmacion inscripcion</title>
</head>
<body>

<h3>El precio final del campamento es: <b><%=request.getAttribute("precio")%></b></h3>
							<form action="/Practica3/crearInscripcionConfirmado" method="POST">
									<div class="flex-item">
										<input type="hidden" id="idCampamento" name="idCampamento" value="<%= request.getAttribute("idCampamento") %>">	
										<input type="hidden" id="idAsistente" name="idAsistente" value="<%= request.getAttribute("idAsistente") %>">												
										<input type="hidden" id="precio" name="precio" value="<%= request.getAttribute("precio") %>">
										<label>¿Seguro que desea inscribirse?</label>
										<button type="submit">Confirmar inscripcion</button>	
									</div>
							</form>
</body>
</html>