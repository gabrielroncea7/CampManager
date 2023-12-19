<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
    <title>Añadir Monitor</title>
</head>
<body>
    <div class="form-container">
        <h2>Añadir Monitor</h2>
        <form action="/Practica3/mvc/controller/TuControlador" method="post">
            <label for="nombreMonitor">Nombre del Monitor:</label>
            <input type="text" id="nombreMonitor" name="nombreMonitor" required>
            
            <label for="apellidosMonitor">Apellidos del Monitor:</label>
            <input type="text" id="apellidosMonitor" name="apellidosMonitor" required>
            
            <label for="educadorEspecial">Educador Especial:</label>
            <input type="checkbox" id="educadorEspecial" name="educadorEspecial">
            
            <button type="submit" class="big-button">Guardar Monitor</button>
        </form>
    </div>
</body>
</html>
