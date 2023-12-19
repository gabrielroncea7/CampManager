<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
    <title>Añadir Actividad</title>
</head>
<body>
    <div class="form-container">
        <h2>Añadir Actividad</h2>
        <form action="/Practica3/mvc/controller/TuControlador" method="post">
            <label for="nombreActividad">Nombre de la Actividad:</label>
            <input type="text" id="nombreActividad" name="nombreActividad" required>
            
            <label for="nivelEducativo">Nivel Educativo:</label>
            <select id="nivelEducativo" name="nivelEducativo" required>
                <option value="Infantil">Infantil</option>
                <option value="Juvenil">Juvenil</option>
                <option value="Adolescente">Adolescente</option>
            </select>
            
            <label for="horario">Horario de la Actividad:</label>
            <select id="horario" name="horario" required>
                <option value="Mañana">Mañana</option>
                <option value="Tarde">Tarde</option>
            </select>
            
            <label for="numParticipantes">Número de Participantes:</label>
            <input type="number" id="numParticipantes" name="numParticipantes" required>
            
            <label for="numMonitores">Número de Monitores:</label>
            <input type="number" id="numMonitores" name="numMonitores" required>
            
            <button type="submit" class="big-button">Guardar Actividad</button>
        </form>
    </div>
</body>
</html>
