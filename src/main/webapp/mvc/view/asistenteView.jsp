<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="es.uco.pw.business.Gestores.GestorInscripciones"%>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios"%>

<jsp:useBean id="userBean" scope="session"
	class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
if (userBean.getEmail() == null || userBean.getEmail().isEmpty()) {
	response.sendRedirect("/Practica3" + "?message=" + URLEncoder.encode("Inicia sesión o Registrate", "UTF-8"));
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de inicio del Asistente</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/asistente.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/admin.css">
</head>
<body>
	<%--AQUI EMPIEZAN LOS BOTONES--%>
	<%@ include file="../../include/headerAsistente.jsp"%>
	<br>
	<br>
	<br>
	<div class="centrado">
		<div>
			<h2>
				Bienvenido,
				<%=userBean.getNombre()%></h2>

			<h2>
				Fecha actual:
				<%=java.time.LocalDate.now()%></h2>
		</div>
					<form action="/Practica3/mostrarInscripciones" method="GET">

			<button type="submit" class="pure-button">Ver mis campamentos</button>
		</form>
			<div>
		<%
		ResultSet verInscripciones = (ResultSet) request.getAttribute("verInscripciones");
		if (verInscripciones != null) {
		%>
		<h2>Mis campamentos:</h2>

		<%
		while (verInscripciones.next()) {
		%>
		<table id="campamentos-list">
			<tr>
				<th>Id de campamento</th>
				<th>Fecha de Inicio</th>
				<th>Fecha de Fin</th>
				<th>Nivel educativo</th>
			</tr>
			<tr>
				<td><%=verInscripciones.getInt(3)%></td>
				<td><%=verInscripciones.getString(4)%></td>
				<td><%=verInscripciones.getString(5)%></td>
				<td>
					<%
					String monitor;
					if (verInscripciones.getBoolean(6)) {
						monitor = "Tardio";
					} else {
						monitor = "Temprano";
					}
					%> <%=monitor%>
				</td>
			</tr>
		</table>
		<form action="/Practica3/SVCancelarInscripcion" method="post">
			<button type="submit">Cancelar Inscripcion</button>
		</form>
		<%
		}

		}
		%>

	</div>
		<form action="/Practica3/mostrarCampamentosDisponibles" method="GET">
			<div class="flex-container">

				<h3>Buscar campamento entre fechas</h3>
				<label for="fechaInicio">Fecha Inicio</label> <input type="date"
					id="fechaInicio" name="fechaInicio" required>

			</div>
			<br>
			<div class="flex-container">
				<div class="flex-item">
					<label for="fechaFin">Fecha Fin</label> <input type="date"
						id="fechaFin" name="fechaFin" required>
				</div>
			</div>
			<br>

			<button type="submit" class="pure-button">Ver campamentos
				disponibles</button>
		</form>
		<br>

		<form action="/Practica3/SVMostrarCampamentoCriterios" method="GET">
			<h3>Buscar campamento por nivel educativo o minimo de plazas</h3>

			<label for="nivelEducativo">Nivel Educativo:</label> 
			<select name="nivelEducativo">
				<option value="Infantil" selected>Infantil</option>
				<option value="Juvenil">Juvenil</option>
				<option value="Adolescente">Adolescente</option>
			</select>
			<button type="submit" class="pure-button">Buscar</button>
			</form>
			<form action="/Practica3/SVMostrarCampamentoPlazaslibres" method="GET">
			<br> <label for="plazas">Número mínimo de plazas disponibles:</label> 
				<input type="number" name="plazaslibres" placeholder="Ingresa el número mínimo de plazas">

			<button type="submit" class="pure-button">Buscar</button>
		</form>
	</div>
	<%--AQUI ACABAN LOS BOTONES--%>
	<%--ESTO VA	 ABAJO--%>


	<div>
		<%
		ResultSet verCampamentosCriterio = (ResultSet) request.getAttribute("verCampamentosCriterio");
		if (verCampamentosCriterio != null) {
		%>
		<h2>
			Campamentos disponibles con nivel educativo:
		<%=request.getAttribute("nivelEducativo")%></h2>

		<%
		while (verCampamentosCriterio.next()) {
		%>
		<table id="campamentos-list">
			<tr>
				<th>Id de campamento</th>
				<th>Fecha de Inicio</th>
				<th>Fecha de Fin</th>
				<th>Nivel educativo</th>
				<th>Numero Maximo Asistentes</th>
				<th>Asistentes inscritos</th>
				<th>¿Monitor asignado?</th>
			</tr>
			<tr>
				<td><%=verCampamentosCriterio.getInt(1)%></td>
				<td><%=verCampamentosCriterio.getString(2)%></td>
				<td><%=verCampamentosCriterio.getString(3)%></td>
				<td><%=verCampamentosCriterio.getString(4)%></td>
				<td><%=verCampamentosCriterio.getInt(5)%></td>
				<td><%=verCampamentosCriterio.getInt(6)%></td>
				<td>
					<%
					String monitor;
					if (verCampamentosCriterio.getBoolean(7)) {
						monitor = "Si";
					} else {
						monitor = "No";
					}
					%> <%=monitor%>
				</td>
			</tr>
		</table>
		<form action="/Practica3/SVInscribirseCampamento" method="post">
			<button type="submit">Inscribirse</button>
		</form>
		<%
		}

		}
		%>

	</div>
	<div class="mi-div7">
		<%
		ResultSet verCampamentos = (ResultSet) request.getAttribute("verCampamentos");
		if (verCampamentos != null) {
		%>
		<h2>
			Campamentos disponibles entre
			<%=request.getAttribute("fechaInicio")%>
			y
			<%=request.getAttribute("fechaFin")%></h2>

		<%
		while (verCampamentos.next()) {
		%>
		<table id="campamentos-list" class="tabla1">
			<tr>
				<th>Id de campamento</th>
				<th>Fecha de Inicio</th>
				<th>Fecha de Fin</th>
				<th>Nivel educativo</th>
				<th>Numero Maximo Asistentes</th>
				<th>Asistentes inscritos</th>
				<th>¿Monitor asignado?</th>
			</tr>
			<tr>
				<td><%=verCampamentos.getInt(1)%></td>
				<td><%=verCampamentos.getString(2)%></td>
				<td><%=verCampamentos.getString(3)%></td>
				<td><%=verCampamentos.getString(4)%></td>
				<td><%=verCampamentos.getInt(5)%></td>
				<td><%=verCampamentos.getInt(6)%></td>
				<td>
					<%
					String monitor;
					if (verCampamentos.getBoolean(7)) {
						monitor = "Si";
					} else {
						monitor = "No";
					}
					%> <%=monitor%>
				</td>
			<tr>
				<td>
					<form action="/Practica3/crearInscripcion" method="GET">
						<div class="flex-item">
							<input type="hidden" id="idCampamento" name="idCampamento"
								value="<%=verCampamentos.getInt(1)%>"> <label
								for="inscripcionCompleta">¿Desea una inscripcion
								completa?</label> <input type="checkbox" id="inscripcionCompleta"
								name="inscripcionCompleta" value=true>
							<button type="submit">Inscribirse</button>
						</div>
					</form>
				</td>
			</tr>
		</table>
		<%
		}

		}
		%>
	</div>
</body>
</html>