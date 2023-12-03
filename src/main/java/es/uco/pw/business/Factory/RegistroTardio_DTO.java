package es.uco.pw.business.Factory;

import java.time.LocalDate;

/**
 * Clase que representa la creación de inscripciones con registro tardío a un campamento.
 */
public class RegistroTardio_DTO implements InscripcionFactory_DTO {

    /**
     * Crea una inscripción completa con registro tardío a un campamento.
     *
     * @param idParticipante     Identificador del participante que se inscribe.
     * @param idCampamento       Identificador del campamento al que se inscribe.
     * @param fechaInscripcion   Fecha en la que se realizó la inscripción.
     * @param Precio             Precio de la inscripción en euros.
     * @return Una instancia de InscripcionCompleta con registro tardío.
     */
    @Override
    public InscripcionCompleta_DTO crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float Precio) {
        InscripcionCompleta_DTO InsCompTardio = new InscripcionCompleta_DTO(idParticipante, idCampamento, fechaInscripcion, Precio);
        return InsCompTardio;
    }

    /**
     * Crea una inscripción parcial con registro tardío a un campamento.
     *
     * @param idParticipante     Identificador del participante que se inscribe.
     * @param idCampamento       Identificador del campamento al que se inscribe.
     * @param fechaInscripcion   Fecha en la que se realizó la inscripción.
     * @param Precio             Precio de la inscripción en euros.
     * @return Una instancia de InscripcionParcial con registro tardío.
     */
    @Override
    public InscripcionParcial_DTO crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float Precio) {
        InscripcionParcial_DTO InsParTardio = new InscripcionParcial_DTO(idParticipante, idCampamento, fechaInscripcion, Precio);
        return InsParTardio;
    }
}
