<%@page import="es.uco.pw.business.Usuario.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
// Recupera el usuarioDTO de la sesión
UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute("usuarioDTO");

// Ahora puedes usar el objeto usuarioDTO en tu página
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de inicio</title>
</head>
<body>
    <h1>Bienvenido, <%= userBean.getNombre() %></h1>
    <h1>Especial, <%= userBean.isNecesidadesEspeciales() %></h1>
    <h1>admin, <%= userBean.isAdmin() %></h1>
    <!-- Otro contenido de la página -->
</body>
</html>
