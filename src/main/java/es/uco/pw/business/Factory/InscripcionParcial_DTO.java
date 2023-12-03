package es.uco.pw.business.Factory;

import java.time.LocalDate;

/**
 * Clase que representa una inscripción parcial a un campamento.
 * Extiende la clase abstracta Inscripcion.
 */
public class InscripcionParcial_DTO extends Inscripcion_DTO {

    /**
     * Constructor de InscripcionParcial.
     *
     * @param idParticipante     Identificador del participante que se inscribe.
     * @param idCampamento       Identificador del campamento al que se inscribe.
     * @param fechaInscripcion   Fecha en la que se realizó la inscripción.
     * @param Precio             Precio de la inscripción en euros.
     */
    public InscripcionParcial_DTO(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float Precio) {
        this.setIdParticipante(idParticipante);
        this.setIdCampamento(idCampamento);
        this.setFechaInscripcion(fechaInscripcion);
        this.setPrecio(Precio);
    }
}
