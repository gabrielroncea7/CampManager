<%@page import="es.uco.pw.business.common.HorarioActividad_DTO"%>
<%@page import="es.uco.pw.business.common.NivelEducativo_DTO"%>
<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@page import="es.uco.pw.business.Monitor.Monitor_DTO"%>
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

<div class="big-button-container">
		<button type="button" class="big-button" onclick="mostrarFormulario('addMonitorActividad')">Asociar Monitor a Actividad</button>
   		<button type="button" class="big-button" onclick="mostrarFormulario('addMonitorRCampamento')">Asociar Monitor responsable a campamentos</button>
   		<button type="button" class="big-button" onclick="mostrarFormulario('addMonitorESCampamento')">Asociar Monitor de Atención Especial a campamento</button>
</div>


<div class="form-container" id="addMonitorActividad" style="display: none;"></div>
<div class="form-container" id="addMonitorRCampamento" style="display: none;"></div>
<div class="form-container" id="addMonitorESCampamento" style="display: none;"></div>


        		<%
		String msg = (String) session.getAttribute("msg");
		session.removeAttribute("msg"); // Elimina el mensaje de la sesión después de mostrarlo
		if (msg != null && !msg.isEmpty()) {
		%>
		    <div class="form-container">
		        <h2><%= msg %></h2>
		    </div>
		<%
		}
		%>
			
<div class="table-container">
    <div class="actividades-container">
        <h2>Actividades:</h2>
        <table id="campamentos-list">
            <tr>
                <th>Nombre</th>
                <th>Nivel Educativo</th>
                <th>Monitores Asociados</th>
            </tr>
           <%
            ResultSet actividades = (ResultSet)request.getAttribute("verActividades");
            while(actividades.next()) {
            %>
                <tr>
                    <td><%= actividades.getString(1) %></td>
                    <td><%= NivelEducativo_DTO.valueOf(actividades.getString(2)) %></td>
                    <td><%= actividades.getString(6) %></td>
                </tr>
            <%
            }
            %>
        </table>
    </div>
    
        <div class="monitores-container">
        <h2>Monitores:</h2>
        <table id="campamentos-list">
            <tr>
                <th>ID Monitor</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Educador Especial</th>
            </tr>
            <%
            ResultSet monitores = (ResultSet)request.getAttribute("verMonitores");
            while(monitores.next()) {
            %>
                <tr>
                    <td><%= monitores.getInt(1)%></td>
                     <td><%= monitores.getString(2)%></td>
                      <td><%= monitores.getString(3)%></td>
                    <td><%= monitores.getBoolean(4)%></td>
                </tr>
            <%
            }
            %>
        </table>
    </div>
    
    <div class="campamentos-container">
        <h2>Campamentos:</h2>
        <table id="campamentos-list">
            <tr>
                <th>ID Campamento</th>
                <th>Nivel Educativo</th>
                <th>Nº maximo asistentes</th>
                <th>Asistentes Inscritos</th>
                <th>Monitor Asignado</th>
                <th>Monitores</th>
                <th>Actividades</th>
                <th>Monitor Responsables</th>
            </tr>
            <%
            ResultSet campamentos = (ResultSet)request.getAttribute("verCampamentos");
            while(campamentos.next()) {
            %>
                <tr>
                    <td><%= campamentos.getInt(1)%></td>
                    <td><%= campamentos.getString(4)%></td>
                      <td><%= campamentos.getString(5)%></td>
                        <td><%= campamentos.getString(6)%></td>
                          <td><%= campamentos.getString(7)%></td>
                            <td><%= campamentos.getString(8)%></td>
                              <td><%= campamentos.getString(9)%></td>
                              <td><%= campamentos.getString(10)%></td>
                              
                </tr>
            <%
            }
            %>
        </table>
    </div>
</div>



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