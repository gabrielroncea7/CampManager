package es.uco.pw.business.Factory;

import java.time.LocalDate;

/**
 * Clase abstracta que representa una inscripción a un campamento.
 */

public abstract class Inscripcion_DTO {
    private int idParticipante;       // Identificador del participante que se inscribe.
    private int idCampamento;         // Identificador del campamento al que se inscribe.
    private LocalDate fechaInscripcion;    // Fecha en la que se realizó la inscripción.
    private float Precio;             // Precio de la inscripción en euros.
    
    /**
     * Constructor vacío de la inscripción.
     */
    public Inscripcion_DTO() {
        super();
    }

    /**
     * Obtiene el identificador del participante que se inscribe.
     * @return El identificador del participante.
     */
    public int getIdParticipante() {
        return idParticipante;
    }

    /**
     * Establece el identificador del participante que se inscribe.
     * @param idParticipante El identificador del participante.
     */
    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    /**
     * Obtiene el identificador del campamento al que se inscribe.
     * @return El identificador del campamento.
     */
    public int getIdCampamento() {
        return idCampamento;
    }

    /**
     * Establece el identificador del campamento al que se inscribe.
     * @param idCampamento El identificador del campamento.
     */
    public void setIdCampamento(int idCampamento) {
        this.idParticipante = idCampamento;
    }

    /**
     * Obtiene la fecha en la que se realizó la inscripción.
     * @return La fecha de inscripción.
     */
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Establece la fecha en la que se realizó la inscripción.
     * @param fechaInscripcion La fecha de inscripción.
     */
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Obtiene el precio de la inscripción en euros.
     * @return El precio de la inscripción.
     */
    public float getPrecio() {
        return Precio;
    }

    /**
     * Establece el precio de la inscripción en euros.
     * @param precio El precio de la inscripción.
     */
    public void setPrecio(float precio) {
        Precio = precio;
    }

    /**
     * Retorna una representación en forma de cadena de la inscripción.
     * @return Cadena que representa la inscripción.
     */
    @Override
    public String toString() {
        return " IdParticipante=" + idParticipante
                + ", idCampamento=" + idCampamento + ", fechaInscripcion="
                + fechaInscripcion + ", Precio=" + Precio;
    }
}
