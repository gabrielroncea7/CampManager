   <div > 
        <h2>A�adir Actividad</h2>
        <form action="<%= request.getContextPath() %>/crearActividad" method="post">
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
                <option value="Ma�ana">Ma�ana</option>
                <option value="Tarde">Tarde</option>
            </select>
            
            <label for="numParticipantes">N�mero de Participantes:</label>
            <input type="number" id="numParticipantes" name="numParticipantes" required min="0">
            
            <label for="numMonitores">N�mero de Monitores:</label>
            <input type="number" id="numMonitores" name="numMonitores" required min="0">
            
            <button type="submit" class="big-button">Guardar Actividad</button>
        </form>       
    </div>
	    
