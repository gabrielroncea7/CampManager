package es.uco.pw.data.display;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellidos;
	private String email;
	private LocalDate fechaNacimiento; 
	private String password;
	private boolean necesidadesEspeciales;
	private boolean Admin;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isNecesidadesEspeciales() {
		return necesidadesEspeciales;
	}
	public void setNecesidadesEspeciales(boolean necesidadesEspeciales) {
		this.necesidadesEspeciales = necesidadesEspeciales;
	}
	public boolean isAdmin() {
		return Admin;
	}
	public void setAdmin(boolean admin) {
		Admin = admin;
	}
	


}
