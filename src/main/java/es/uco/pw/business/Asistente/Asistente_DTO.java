package es.uco.pw.business.Asistente;

import java.time.LocalDate;

/**
 * Clase que representa a una persona que asiste al campamento de verano.
 */

public class Asistente_DTO {
   
   private int idPersona; // Identificador de la persona
   private String nombre; // Nombre del asistente
   private String apellidos; // Apellidos del asistente
   private LocalDate fechaNacimiento; // Fecha de nacimiento para gestionar grupos de edad
   private boolean necesitaAtencionEspecial; // Indica si el asistente requiere atención especial

   /**
    * Constructor vacío de la clase Asistente.
    */
   public Asistente_DTO() {
   }

   /**
    * Constructor parametrizado de la clase Asistente.
    *
    * @param idPersona               Identificador de la persona.
    * @param nombre                  Nombre del asistente.
    * @param apellidos               Apellidos del asistente.
    * @param fechaNacimiento         Fecha de nacimiento del asistente.
    * @param necesitaAtencionEspecial Indica si el asistente requiere atención especial.
    */
   public Asistente_DTO(int idPersona, String nombre, String apellidos, LocalDate fechaNacimiento, boolean necesitaAtencionEspecial) {
       this.idPersona = idPersona;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.fechaNacimiento = fechaNacimiento;
       this.necesitaAtencionEspecial = necesitaAtencionEspecial;
   }

   // Métodos get/set para todos los atributos
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getNecesitaAtencionEspecial() {
        return necesitaAtencionEspecial;
    }

    public void setNecesitaAtencionEspecial(boolean necesitaAtencionEspecial) {
        this.necesitaAtencionEspecial = necesitaAtencionEspecial;
    }

    /**
     * Método toString que imprime la información del asistente.
     *
     * @return Cadena de texto que representa la información del asistente.
     */
    @Override
    public String toString() {
        return "Asistente: Id=" + idPersona + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", fechaNacimiento=" + fechaNacimiento + ", necesitaAtencionEspecial=" + necesitaAtencionEspecial;
    }
}