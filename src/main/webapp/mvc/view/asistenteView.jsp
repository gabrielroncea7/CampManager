<%@page import="es.uco.pw.business.Gestores.GestorCampamentos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de inicio del Asistente</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/asistente.css">
</head>
<body>
    <h1>Bienvenido, <%= userBean.getNombre() %></h1>
    
    <h2>Fecha actual: <%= java.time.LocalDate.now() %></h2>
    
    <h2>Campamentos Inscritos:</h2>
    <ul>
    </ul>
<!-- Botones -->
<div class="button-container">
    <form action="${pageContext.request.contextPath}/SVDesconectar" method="post">
        <button type="submit">Desconectar</button>
    </form>

    <form action="ModificarDatosServlet" method="post">
        <button type="submit">Modificar Datos</button>
    </form>
</div>
</body>
</html>