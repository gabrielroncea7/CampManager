package es.uco.pw.business.Factory;

import java.time.LocalDate;

/**
 * Interfaz que define métodos para crear diferentes tipos de inscripciones a un campamento.
 */
public interface InscripcionFactory_DTO {

    /**
     * Crea una inscripción completa a un campamento.
     *
     * @param idParticipante     Identificador del participante que se inscribe.
     * @param idCampamento       Identificador del campamento al que se inscribe.
     * @param fechaInscripcion   Fecha en la que se realizó la inscripción.
     * @param Precio             Precio de la inscripción en euros.
     * @return Una instancia de InscripcionCompleta.
     */
    InscripcionCompleta_DTO crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float Precio);

    /**
     * Crea una inscripción parcial a un campamento.
     *
     * @param idParticipante     Identificador del participante que se inscribe.
     * @param idCampamento       Identificador del campamento al que se inscribe.
     * @param fechaInscripcion   Fecha en la que se realizó la inscripción.
     * @param Precio             Precio de la inscripción en euros.
     * @return Una instancia de InscripcionParcial.
     */
    InscripcionParcial_DTO crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float Precio);
}
