<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@page import="es.uco.pw.business.Campamento.Campamento_DTO"%>
<%@page import="es.uco.pw.business.Usuario.UsuarioDTO,java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css"> 
    <title>Página de Administrador</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<%ResultSet resultSet = null;
ResultSet resultSet2 = null;
Campamento_DTO campamento;
%>
    <h1>Listado de Campamentos</h1>
	<%
		resultSet = GestorCampamentos.listarCampamentos();
		if(resultSet != null)
		{
			while (resultSet.next())
			{
				%>
			    <table id="campamentos-list">
			        <tr>
			            <th>Campamento: <%=resultSet.getInt("Id") %></th>   
			        </tr>
			     	<%
			 			 		
			     	%>
			    </table>
				<%
				
			}
		}
	%>

    <div id="options">
        <a href="#">Desconectar</a>
        <a href="#">Modificar Datos</a>
    </div>
</body>
</html>