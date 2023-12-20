<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.sql.ResultSet" %>    
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorInscripciones"%>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios"%>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
if(userBean.getEmail()==null || userBean.getEmail().isEmpty())
{
	response.sendRedirect("/Practica3" + "?message=" + URLEncoder.encode("Inicia sesión o Registrate", "UTF-8"));	
}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de inicio del Asistente</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/asistente.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
</head>
<body>

    <h1>Bienvenido, <%= userBean.getNombre() %></h1>
    
    <h2>Fecha actual: <%= java.time.LocalDate.now() %></h2>
    
    <div>
<%  

ResultSet verCampamentos = (ResultSet)request.getAttribute("verCampamentos");
if(verCampamentos!=null){
	%> 
	<h2>Campamentos disponibles entre <%=request.getAttribute("fechaInicio") %> y <%=request.getAttribute("fechaFin") %></h2>
	
	<%
	while (verCampamentos.next()){
		 %> 
		 <table  id="campamentos-list">
		<tr>
		<th> Id de campamento </th>
		<th>Fecha de Inicio</th>
		<th>Fecha de Fin</th>
		<th>Nivel educativo</th>
		<th>Numero Maximo Asistentes</th>
		<th>Asistentes inscritos</th>
		<th>¿Monitor asignado?</th>	
		</tr>
		<tr>
		 <td><%=verCampamentos.getInt(1) %> </td>
		 <td><%=verCampamentos.getString(2) %></td>
		 <td><%=verCampamentos.getString(3) %></td>
		 <td><%=verCampamentos.getString(4) %></td>
		 <td><%=verCampamentos.getInt(5)%></td>
		 <td><%=verCampamentos.getInt(6) %></td>	 
		<td>
		 <%
		 String monitor;
		 if(verCampamentos.getBoolean(7)){
			monitor = "Si";
		 } 
		 else 
		 {
			 monitor = "No";
		} 
		 %>
		<%=monitor %>
		</td>	 
		</tr>
		</table>	
		 <% 
		 
	}

}

%>

</div>
    
    <h2>Campamentos Inscritos:</h2>
    <ul>
    	<% int idAsistente = GestorUsuarios.obtenerAsistenteUsuario(userBean.getEmail());%>
    	<%String Inscripciones = GestorInscripciones.listarInscripcionesAsistente(idAsistente);%>
    	
    	<%=Inscripciones %>
    </ul>
    
<!-- Botones -->
<div class="button-container">
    <form action="/Practica3/mvc/controller/logOutController.jsp" method="post">
        <button type="submit">Desconectar</button>
    </form>

    <form action="/Practica3/mvc/view/ModificarDatosView.jsp" method="post">
        <button type="submit">Modificar Datos</button>
    </form>
    
    <form action="/Practica3/mostrarCampamentosDisponibles" method="GET">
    	<div class="flex-container">
	        <div class="flex-item">
	            <label for="fechaInicio">Fecha Inicio</label>
	            <input type="date" id="fechaInicio" name="fechaInicio" required>
	        </div>
    	</div>
    	<br>
    	<div class="flex-container">
	        <div class="flex-item">
	            <label for="fechaFin">Fecha Fin</label>
	            <input type="date" id="fechaFin" name="fechaFin" required>
	        </div>
    	</div>
    
        <button type="submit">Ver campamentos disponibles</button>
    </form>
</div>
</body>
</html>