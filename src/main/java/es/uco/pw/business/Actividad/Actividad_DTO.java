package es.uco.pw.business.Actividad;

import es.uco.pw.business.common.HorarioActividad_DTO;
import es.uco.pw.business.common.NivelEducativo_DTO;

/**
 * La clase Actividad representa una actividad que forma parte de la organización de un campamento de verano.
 */
public class Actividad_DTO {

    /** Nombre de la actividad. */
    private String NombreActividad;

    /** Nivel educativo al que está destinada la actividad. */
    private NivelEducativo_DTO nEducativo;

    /** Horario de la actividad (mañana o tarde). */
    private HorarioActividad_DTO hActividad;

    /** Número máximo de participantes en la actividad. */
    private int NumeroParticipantes;

    /** Número de monitores necesarios para la actividad. */
    private int MonitoresNecesarios;

    /**
     * Constructor vacío de la clase Actividad.
     */
    public Actividad_DTO() {
    }

    /**
     * Constructor parametrizado de la clase Actividad.
     *
     * @param nombreActividad Nombre de la actividad.
     * @param nEducativo      Nivel educativo al que está destinada la actividad.
     * @param hActividad      Horario de la actividad.
     * @param numeroParticipantes Número máximo de participantes en la actividad.
     * @param MonitoresNecesarios Número de monitores necesarios para la actividad.
     */
    public Actividad_DTO(String nombreActividad, NivelEducativo_DTO nEducativo, HorarioActividad_DTO hActividad,
            int numeroParticipantes, int MonitoresNecesarios) {
        this.NombreActividad = nombreActividad;
        this.nEducativo = nEducativo;
        this.hActividad = hActividad;
        this.NumeroParticipantes = numeroParticipantes;
        this.MonitoresNecesarios = MonitoresNecesarios;
    }

    // Getters y Setters

    /**
     * Obtiene el nombre de la actividad.
     *
     * @return Nombre de la actividad.
     */
    public String getNombreActividad() {
        return NombreActividad;
    }

    /**
     * Establece el nombre de la actividad.
     *
     * @param nombreActividad Nombre de la actividad.
     */
    public void setNombreActividad(String nombreActividad) {
        NombreActividad = nombreActividad;
    }

    /**
     * Obtiene el nivel educativo al que está destinada la actividad.
     *
     * @return Nivel educativo.
     */
    public NivelEducativo_DTO getnEducativo() {
        return nEducativo;
    }

    /**
     * Establece el nivel educativo al que está destinada la actividad.
     *
     * @param nEducativo Nivel educativo.
     */
    public void setnEducativo(NivelEducativo_DTO nEducativo) {
        this.nEducativo = nEducativo;
    }

    /**
     * Obtiene el horario de la actividad.
     *
     * @return Horario de la actividad.
     */
    public HorarioActividad_DTO gethActividad() {
        return hActividad;
    }

    /**
     * Establece el horario de la actividad.
     *
     * @param hActividad Horario de la actividad.
     */
    public void sethActividad(HorarioActividad_DTO hActividad) {
        this.hActividad = hActividad;
    }

    /**
     * Obtiene el número máximo de participantes en la actividad.
     *
     * @return Número máximo de participantes.
     */
    public int getNumeroParticipantes() {
        return NumeroParticipantes;
    }

    /**
     * Establece el número máximo de participantes en la actividad.
     *
     * @param numeroParticipantes Número máximo de participantes.
     */
    public void setNumeroParticipantes(int numeroParticipantes) {
        NumeroParticipantes = numeroParticipantes;
    }

    /**
     * Obtiene el número de monitores necesarios para la actividad.
     *
     * @return Número de monitores necesarios.
     */
    public int getMonitoresNecesarios() {
        return MonitoresNecesarios;
    }

    /**
     * Establece el número de monitores necesarios para la actividad.
     *
     * @param MonitoresNecesarios Número de monitores necesarios.
     */
    public void setMonitoresNecesarios(int MonitoresNecesarios) {
        this.MonitoresNecesarios = MonitoresNecesarios;
    }


    /**
     * Devuelve una representación en cadena de la actividad.
     *
     * @return Cadena que representa la actividad.
     */
	@Override
	public String toString() {
		return "Actividad: Nombre=" + NombreActividad + ", nEducativo=" + nEducativo + ", hActividad="
				+ hActividad + ", NumeroParticipantes=" + NumeroParticipantes + ", MonitoresNecesarios="
				+ MonitoresNecesarios;
	}
}
