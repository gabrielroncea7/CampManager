<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Campamentos disponibles entre las fechas seleccionadas</h1>

<%
ResultSet resultset = (ResultSet)request.getAttribute("verCampamentos");
while (resultset.next()){
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
	 <td><%=resultset.getInt(1) %> </td>
	 <td><%=resultset.getString(2) %></td>
	 <td><%=resultset.getString(3) %></td>
	 <td><%=resultset.getString(4) %></td>
	 <td><%=resultset.getInt(5)%></td>
	 <td><%=resultset.getInt(6) %></td>	 
	<td>
	 <%
	 String monitor;
	 if(resultset.getBoolean(7)){
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
	 <% 
	 
}
%>
	 </table>
</body>
</html>