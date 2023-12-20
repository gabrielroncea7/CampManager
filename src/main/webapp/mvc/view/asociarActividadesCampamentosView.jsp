<%@page import="es.uco.pw.business.common.HorarioActividad_DTO"%>
<%@page import="es.uco.pw.business.common.NivelEducativo_DTO"%>
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/asociar.css">
    <title>Página de Administrador</title>
</head>
<body>


<div class="table-container">
    <div class="actividades-container">
        <h2>Actividades:</h2>
        <table id="actividades-list">
            <tr>
                <th>Nombre</th>
                <th>Nivel Educativo</th>
                <th>Horario Actividad</th>
            </tr>
            <%
            ResultSet actividades = (ResultSet)request.getAttribute("verActividades");
            while(actividades.next()) {
            %>
                <tr>
                    <td><%= actividades.getString(1) %></td>
                    <td><%= NivelEducativo_DTO.valueOf(actividades.getString(2)) %></td>
                    <td><%= HorarioActividad_DTO.valueOf(actividades.getString(3)) %></td>
                </tr>
            <%
            }
            %>
        </table>
    </div>

    <div class="form-container">
        <h2>Asociar Actividad y Campamento</h2>
        <form action="/Practica3/asociarActividadCampamento" method="post">
            <label for="nombreActividad">Nombre de la Actividad:</label>
            <input type="text" id="nombreActividad" name="nombreActividad" required>

            <label for="idCampamento">ID del Campamento:</label>
            <input type="text" id="idCampamento" name="idCampamento" required>

            <button type="submit" class="big-button">Asociar</button>
        </form>
        
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
    </div>

    <div class="campamentos-container">
        <h2>Campamentos:</h2>
        <table id="campamentos-list">
            <tr>
                <th>ID Campamento</th>
                <th>Nivel Educativo</th>
            </tr>
            <%
            ResultSet campamentos = (ResultSet)request.getAttribute("verCampamentos");
            while(campamentos.next()) {
            %>
                <tr>
                    <td><%= campamentos.getInt(1)%></td>
                    <td><%= campamentos.getString(4)%></td>
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
</body>
</html>