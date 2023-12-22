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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/formularios.css">
	
    <title>Página de Administrador</title>
</head>
<body>
<%@ include file="../../include/headerAdministrador.jsp" %>
<div class="big-button-container">
		<button type="button" class="pure-button" onclick="mostrarFormulario('addActividad')">Añadir Actividad</button>
   		<button type="button" class="pure-button" onclick="mostrarFormulario('addMonitor')">Añadir Monitor</button>
        <button type="button" class="pure-button" onclick="mostrarFormulario('addCampamento')">Añadir Campamento</button>
</div>


<div class="form-container" id="addActividad" style="display: none;"></div>
<div class="form-container" id="addMonitor" style="display: none;"></div>
<div class="form-container" id="addCampamento" style="display: none;"></div>


                    <%-- Muestra el mensaje si está presente --%>
			<%
			
			    String msg =(String)request.getAttribute("msg");
			    if (msg != null && !msg.isEmpty()) {
			%>
				<div class="form-container">
			    <h2><%= msg %></h2>
			    </div>
			<%
			    }
			%>

<script src="<%=request.getContextPath() %>/js/mostrarFormulario.js"></script>
</body>
</html>