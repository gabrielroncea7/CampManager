 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/asistente.css">
    <title>Página que se abre dentro de otra "añadir actividad"</title>
</head>
   <div > 
        <h2>Añadir Actividad</h2>
        <form action="/Practica3/crearActividad" method="post">
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
                <option value="Manana">Mañana</option>
                <option value="Tarde">Tarde</option>
            </select>
            
            <label for="numParticipantes">Número de Participantes:</label>
            <input type="number" id="numParticipantes" name="numParticipantes" required min="0">
            
            <label for="numMonitores">Número de Monitores:</label>
            <input type="number" id="numMonitores" name="numMonitores" required min="0">
            
            <button type="submit" class="pure-button">Guardar Actividad</button>
        </form>       
    </div>
