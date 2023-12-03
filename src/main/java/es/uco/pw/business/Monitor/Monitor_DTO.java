package es.uco.pw.business.Monitor;

/**
 * Clase que representa a un monitor en el contexto de un campamento.
 */
public class Monitor_DTO {
    
    // Atributos de la clase Monitor
    
    private int id;               // Identificador del monitor
    private String nombre;        // Nombre del monitor
    private String apellidos;     // Apellidos del monitor
    private boolean educadorespecial;  // Indica si el monitor es un educador especial

    /**
     * Constructor por defecto para la clase Monitor.
     */
    public Monitor_DTO() {
    }

    /**
     * Constructor parametrizado para crear una instancia de la clase Monitor con datos específicos.
     *
     * @param id                Identificador del monitor.
     * @param nombre            Nombre del monitor.
     * @param apellidos         Apellidos del monitor.
     * @param educadorespecial  Indica si el monitor es un educador especial (true si lo es, false si no).
     */
    public Monitor_DTO(int id, String nombre, String apellidos, boolean educadorespecial) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.educadorespecial = educadorespecial;
    }

    // Métodos getter y setter para todos los atributos

    /**
     * Obtiene el identificador del monitor.
     *
     * @return El identificador del monitor.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del monitor.
     *
     * @param id El identificador del monitor.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del monitor.
     *
     * @return El nombre del monitor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del monitor.
     *
     * @param nombre El nombre del monitor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del monitor.
     *
     * @return Los apellidos del monitor.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del monitor.
     *
     * @param apellidos Los apellidos del monitor.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Verifica si el monitor es un educador especial.
     *
     * @return true si el monitor es un educador especial, false en caso contrario.
     */
    public boolean getEducadorespecial() {
        return educadorespecial;
    }

    /**
     * Establece si el monitor es un educador especial.
     *
     * @param educadorespecial true si el monitor es un educador especial, false en caso contrario.
     */
    public void setEducadorespecial(boolean educadorespecial) {
        this.educadorespecial = educadorespecial;
    }

    /**
     * Devuelve una representación en cadena de la información del monitor.
     *
     * @return Una cadena que contiene el ID, nombre, apellidos y estado de educador especial del monitor.
     */
    @Override
    public String toString() {
        return "Monitor: Id: " + id + ", Nombre: " + nombre + " " + apellidos +
               ", Educador Especial: " + (educadorespecial ? "Sí" : "No");
    }
}

