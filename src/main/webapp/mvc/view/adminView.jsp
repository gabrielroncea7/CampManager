<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@page import="es.uco.pw.business.Asistente.Asistente_DTO"%>
<%@page import="es.uco.pw.business.Campamento.Campamento_DTO"%>
<%@page import="es.uco.pw.business.Usuario.UsuarioDTO,java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
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
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
    <title>Página de Administrador</title>
</head>
<body>
<%@ include file="../../include/headerAdministrador.jsp" %>
<%
/**
 * ResultSets para manipular datos de campamentos y asistentes.
 */
ResultSet resultSet = null;
ResultSet resultSet2 = null;
Campamento_DTO campamento = new Campamento_DTO();
Asistente_DTO asistente = new Asistente_DTO();
%>

		<div class="big-button-container">
		    <form action="/Practica3/mvc/view/addView.jsp" method="get">
		        <button type="submit" class="pure-button">Dar de alta actividades, monitores y campamentos</button>
		    </form>
		    <form action="/Practica3/asociarActividadCampamento" method="get">
		        <button type="submit" class="pure-button">Asociar actividades a campamentos</button>
		    </form>
		    <form action="/Practica3/asociarMonitor" method="get">
		        <button type="submit" class="pure-button">Asociar monitores a actividades y campamentos</button>
		    </form>
		</div>
                    <%-- Muestra el mensaje si está presente --%>
			<%
			/**
			 * Muestra un mensaje si está presente en los atributos de la solicitud.
			 */
			
			    String msg =(String)request.getAttribute("msg");
			    if (msg != null && !msg.isEmpty()) {
			%>
				<div class="form-container">
			    <h2><%= msg %></h2>
			    </div>
			<%
			    }
			%>
	
    <h1>Listado de Campamentos</h1>
	<%
	/**
	 * Obtiene y muestra la lista de campamentos junto con los asistentes.
	 */
		resultSet = GestorCampamentos.listarCampamentos();
		if(resultSet != null)
		{
			while (resultSet.next())
			{
				campamento.setId(resultSet.getInt("Id"));
				%>
			    <table id="campamentos-list">
			        <tr>
			            <th>Campamento: <%=campamento.getId() %></th>   
			            <th> Tipo de Registro</th>
			        </tr>
			     	<%
			     		resultSet2 = GestorCampamentos.listarAsistentesCampamento(resultSet.getInt("Id"));
				     		while(resultSet2.next())
				     		{
				     			asistente.setNombre(resultSet2.getString(1));
				     			asistente.setApellidos(resultSet2.getString(2));
				     			%>
				     				<tr>
				     				<td> <%=asistente.getNombre().toUpperCase()%> <%=asistente.getApellidos().toUpperCase()%> </td>
				     				<td> <%=(resultSet2.getInt(3) == 1) ? "Completa" : "Parcial" %></td>
				     				</tr>
				     			<%
				     		}
			     	%>
			    </table>
				<%
			}
		}
	%>


</body>
</html>