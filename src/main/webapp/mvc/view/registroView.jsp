<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/Registro.css"> 
    <title>Registro de Usuario</title>
</head>
<body>

    <div class="container">
<form action="../controller/controladorRegistro.jsp" method="POST" class="register-form">
    <%-- Muestra el mensaje si está presente --%>
    <%
        String message = request.getParameter("message");
        if (message != null && !message.isEmpty()) {
    %>
        <p class="message"><%= message %></p>
    <%
        }
    %>
    <h2>Registro de Usuario</h2>

    <!-- Flex container para nombre y apellidos -->
    <div class="flex-container">
        <div class="flex-item">
            <label for="name">Nombre:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="flex-item">
            <label for="lastname">Apellidos:</label>
            <input type="text" id="lastname" name="lastname" required>
        </div>
    </div>

    <!-- Flex container para email y contraseña -->
    <div class="flex-container">
        <div class="flex-item">
            <label for="email">Correo:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="flex-item">
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
        </div>
    </div>

    <!-- Campo para la fecha de nacimiento -->
    <div class="flex-container">
        <div class="flex-item">
            <label for="birthdate">Fecha de Nacimiento:</label>
            <input type="date" id="birthdate" name="birthdate" required>
        </div>
    </div>

	<div class="checkbox-container">
	    <div class="checkbox-item">
	        <label for="specialNeeds">Necesita Atención Especial:</label>
	        <input type="checkbox" id="specialNeeds" name="specialNeeds" value="True">
	    </div>
	
	    <div class="checkbox-item">
	        <label for="isAdmin">Es Administrador:</label>
	        <input type="checkbox" id="isAdmin" name="isAdmin" value="True">
	    </div>
	</div>
    <button type="submit">Registrarse</button>

    <!-- Enlace para "Ya tengo cuenta" -->
    <p>¿Ya tienes cuenta? <a href="/Practica3">Iniciar sesión</a></p>
</form>
    </div>


</body>
</html>