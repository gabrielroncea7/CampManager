 
 
 <div >
        <h2>Añadir Campamento</h2>
        <form action="/Practica3/crearCampamento" method="post">
            <label for="fechaInicio">Fecha de Inicio:</label>
            <input type="date" id="fechaInicio" name="fechaInicio" required>
            
            <label for="fechaFin">Fecha de Fin:</label>
            <input type="date" id="fechaFin" name="fechaFin" required>
            
            <label for="nivelEducativo">Nivel Educativo:</label>
            <select id="nivelEducativo" name="nivelEducativo" required>
                <option value="Infantil">Infantil</option>
                <option value="Juvenil">Juvenil</option>
                <option value="Adolescente">Adolescente</option>
            </select>
            
            <label for="numMaxAsistentes">Número Máximo de Asistentes:</label>
            <input type="number" id="numMaxAsistentes" name="numMaxAsistentes" required min="0">
            
            <button type="submit" class="big-button">Guardar Campamento</button>
        </form>
    </div>