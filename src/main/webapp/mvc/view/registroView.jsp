
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
        <form action="#" method="post" class="register-form">
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
            <input type="checkbox" id="specialNeeds" name="specialNeeds">

            <!-- Checkbox para administrador -->
            <label for="isAdmin">Es Administrador:</label>
            <input type="checkbox" id="isAdmin" name="isAdmin">

            <button type="submit">Registrarse</button>
        </form>
    </div>
</body>
</html>