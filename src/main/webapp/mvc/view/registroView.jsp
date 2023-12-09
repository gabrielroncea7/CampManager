<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/Registro.css"> 
    <title>Registro de Usuario</title>
</head>
<body>
		<% String msg = (String)request.getParameter("msg"); %>
    	<% if (msg != null) { %>
    		<p style="background-color: #ff9999; text-align: center;"><%= msg %></p>
    	<% } %>
    <div class="container">
        <form action="../controller/controladorRegistro.jsp" method="POST" class="register-form">
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

            <!-- Checkbox para atención especial -->
            <label for="specialNeeds">Necesita Atención Especial:</label>
            <input type="checkbox" id="specialNeeds" name="specialNeeds" value="True">

            <!-- Checkbox para administrador -->
            <label for="isAdmin">Es Administrador:</label>
            <input type="checkbox" id="isAdmin" name="isAdmin" value="True">

            <!-- Campo de contraseña de administrador -->
            <div class="admin-password" style="display: none;">
                <label for="adminPassword">Contraseña de Administrador:</label>
                <input type="password" id="adminPassword" name="adminPassword">
            </div>

            <button type="submit">Registrarse</button>

            <!-- Enlace para "Ya tengo cuenta" -->
            <p>¿Ya tienes cuenta? <a href="/Practica3">Iniciar sesión</a></p>
        </form>
    </div>

    <!-- Script JavaScript para manejar la visibilidad del campo de contraseña de administrador -->
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var isAdminCheckbox = document.getElementById('isAdmin');
            var adminPasswordDiv = document.querySelector('.admin-password');

            isAdminCheckbox.addEventListener('change', function () {
                adminPasswordDiv.style.display = isAdminCheckbox.checked ? 'block' : 'none';
            });
        });
    </script>
</body>
</html>