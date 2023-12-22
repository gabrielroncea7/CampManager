<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/include/errorPage.jsp" %>
<%@ page import="java.net.URLEncoder" %>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>
<%
/**
 * Verifica si el usuario ha iniciado sesión. Si no, redirige a la página de inicio de sesión o registro.
 */
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/asistente.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/modificarDatos.css">
</head>
<body>

<header class="navbar">
    <div class="logo">
        <a class="boton-header1">
        <i class="fas fa-home">Inicio</i></a>
    </div>

    <div class="logout-button">
        <a href="/Practica3/mvc/controller/logOutController.jsp">Desconectar</a>
    </div>
</header>

<footer class="footer l-box is-center">Proyecto Golfotron</footer>

<div class="divGrandePrincipio"></div>

<div class="contenedor-formulario">
    <h2>Modificar Datos</h2>
    <form action="/Practica3/mvc/controller/controladorModificar.jsp" method="post">
        <div class="campo-formulario">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= userBean.getNombre() %>" required>
        </div>

        <div class="campo-formulario">
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" value="<%= userBean.getApellidos() %>" required>
        </div>

        <div class="campo-formulario">
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="<%= userBean.getFechaNacimiento() %>" required>
        </div>
		
		<div class="campo-formulario">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" value="<%= userBean.getPassword() %>" required>
        </div>
		
        <div class="campo-formulario">
            <!-- Otros campos según sea necesario -->
        </div>

        <div class="campo-formulario">
            <button type="submit" class="pure-button">Guardar Cambios</button>
        </div>
    </form>
</div>

</body>
</html>
