<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/include/errorPage.jsp" %>

<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"  href="css/Login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <title>Iniciar Sesión</title>
</head>
<body>
    <div class="login-container">
        <form action="mvc/controller/controladorLogin.jsp" method="post" class="login-form">
        
                    <%-- Muestra el mensaje si está presente --%>
			<%
			    String message = request.getParameter("message");
			    if (message != null && !message.isEmpty()) {
			%>
			    <p class="message"><%= message %></p>
			<%
			    }
			%>
            <h2>Iniciar Sesión</h2>
            <div class="input-container">
                <i class="far fa-envelope"></i>
                <input type="email" id="email" name="email" placeholder="Correo" required>
            </div>
            <div class="input-container">
                <i class="fas fa-lock"></i>
                <input type="password" id="password" name="password" placeholder="Contraseña" required>
            </div>
            <button type="submit">Iniciar Sesión</button>
            <p class="register-link">¿No tienes una cuenta? <a href="mvc/view/registroView.jsp">Regístrate aquí</a></p>
        </form>
    </div>
</body>
</html>
