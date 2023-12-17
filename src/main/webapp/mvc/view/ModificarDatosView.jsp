<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/include/errorPage.jsp" %>
<%@ page import="java.net.URLEncoder" %>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>
<%
if(userBean.getEmail()==null || userBean.getEmail().isEmpty())
{
	response.sendRedirect("/Practica3" + "?message=" + URLEncoder.encode("Inicia sesión o Registrate", "UTF-8"));	
}
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Datos</title>
</head>
<body>
    <h2>Modificar Datos</h2>
    <form action="/Practica3/mvc/controller/controladorModificar.jsp" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= userBean.getNombre() %>" required>

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" value="<%= userBean.getApellidos() %>" required>

        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="<%= userBean.getFechaNacimiento() %>" required>
		
		<label for="fechaNacimiento">Contraseña:</label>
        <input type="password" id="password" name="password" value="<%= userBean.getPassword() %>" required>
        <!-- Otros campos según sea necesario -->

        <button type="submit">Guardar Cambios</button>
    </form>
</body>
</html>
