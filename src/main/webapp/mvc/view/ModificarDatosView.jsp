<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Datos</title>
    <!-- Puedes incluir aquí tus estilos CSS si es necesario -->
</head>
<body>
    <h1>Modificar Datos</h1>
    
    <!-- Puedes agregar el formulario para modificar datos aquí -->
    <form action="${pageContext.request.contextPath}/SVGuardarCambios" method="post">
        <!-- Campos de formulario para modificar datos -->
        <label for="nombre">Nuevo Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        
        <!-- Otros campos de formulario según sea necesario -->

        <button type="submit">Guardar Cambios</button>
    </form>

    <!-- Puedes agregar aquí cualquier otro contenido de la página -->

</body>
</html>
