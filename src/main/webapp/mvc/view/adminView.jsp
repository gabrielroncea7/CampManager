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
<%
ResultSet resultSet = null;
ResultSet resultSet2 = null;
Campamento_DTO campamento = new Campamento_DTO();
Asistente_DTO asistente = new Asistente_DTO();
%>
    <h1>Listado de Campamentos</h1>
	<%
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