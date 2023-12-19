<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@page import="es.uco.pw.business.Asistente.Asistente_DTO"%>
<%@page import="es.uco.pw.business.Campamento.Campamento_DTO"%>
<%@page import="es.uco.pw.business.Usuario.UsuarioDTO,java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
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
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
    <title>Página de Administrador</title>
</head>
<body>
<body>
<div class="big-button-container">
    <button type="button" class="big-button" onclick="mostrarFormulario('addActividad')">Añadir Actividad</button>
    <button type="button" class="big-button" onclick="mostrarFormulario('addMonitor')">Añadir Monitor</button>
    <!-- Otros botones ... -->
</div>

<div class="form-container" id="addActividad" style="display: none;"></div>
<div class="form-container" id="addMonitor" style="display: none;"></div>

<!-- Otros elementos ... -->


<div class="button-container">
    <form action="/Practica3/mvc/controller/logOutController.jsp" method="post">
        <button type="submit">Desconectar</button>
    </form>

    <form action="/Practica3/mvc/view/ModificarDatosView.jsp" method="post">
        <button type="submit">Modificar Datos</button>
    </form>
</div>
<script src="<%=request.getContextPath() %>/js/mostrarFormulario.js"></script>
</body>
</html>