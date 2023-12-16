<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de inicio del Asistente</title>
    <link rel="stylesheet" href="css/asistente.css">
</head>
<body>
    <h1>Bienvenido, <%= userBean.getNombre() %></h1>
    
    <h2>Fecha actual: <%= java.time.LocalDate.now() %></h2>
    
    <h2>Campamentos Inscritos:</h2>
    <ul>
    </ul>
</body>
</html>