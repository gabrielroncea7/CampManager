package es.uco.pw.business.Campamento;

import java.time.LocalDate;

import es.uco.pw.business.common.NivelEducativo_DTO;

public class Campamento_DTO {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private NivelEducativo_DTO nivelEducativo;
    private int numeroMaximoAsistentes;
	boolean monitorAsignado = false;

    // Constructor vacío
    public Campamento_DTO() {

    }

    // Constructor parametrizado
    public Campamento_DTO(int id, LocalDate fechaInicio, LocalDate fechaFin, NivelEducativo_DTO nivelEducativo, int numeroMaximoAsistentes,boolean monitorAsignado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nivelEducativo = nivelEducativo;
        this.numeroMaximoAsistentes = numeroMaximoAsistentes;
        this.monitorAsignado = monitorAsignado;
    }


    // Métodos get/set para todos los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public NivelEducativo_DTO getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo_DTO nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public int getNumeroMaximoAsistentes() {
        return numeroMaximoAsistentes;
    }

    public void setNumeroMaximoAsistentes(int numeroMaximoAsistentes) {
        this.numeroMaximoAsistentes = numeroMaximoAsistentes;
    }


	 public boolean isMonitorAsignado() {
		return monitorAsignado;
	}

	public void setMonitorAsignado(boolean monitorAsignado) {
		this.monitorAsignado = monitorAsignado;
	}

	/**
     * Método toString que imprime la información del campamento.
     *
     * @return Cadena de texto que representa la información del campamento.
     */

    @Override
	public String toString() {
		return "Campamento: id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", nivelEducativo=" + nivelEducativo + ", numeroMaximoAsistentes=" + numeroMaximoAsistentes;
	}
    

    
}
