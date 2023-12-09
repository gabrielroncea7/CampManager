<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/include/errorPage.jsp" %>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>



<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"  href="css/Login.css">
    <title>Iniciar Sesión</title>
</head>
<body>
    <div class="login-container">
        <form action="#" method="post" class="login-form">
            <h2>Iniciar Sesión</h2>
            <label for="email">Correo:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Iniciar Sesión</button>
            <p class="register-link">¿No tienes una cuenta? <a href="mvc/view/registroView.jsp">Regístrate aquí</a></p>
        </form>
    </div>
</body>
</html>




