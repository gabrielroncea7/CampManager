
    <div >
        <h2>Añadir Monitor</h2>
        <form action="/Practica3/crearMonitor" method="post">
            <label for="nombreMonitor">Nombre del Monitor:</label>
            <input type="text" id="nombreMonitor" name="nombreMonitor" required>
            
            <label for="apellidosMonitor">Apellidos del Monitor:</label>
            <input type="text" id="apellidosMonitor" name="apellidosMonitor" required>
            
            <label for="educadorEspecial">Educador Especial:</label>
            <input type="checkbox" id="educadorEspecial" name="educadorEspecial" value="True">
            
            <button type="submit" class="pure-button">Guardar Monitor</button>
        </form>
    </div>

