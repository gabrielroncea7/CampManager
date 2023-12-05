package es.uco.pw.data.display;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String login;
	private String nombre;
	private String apellidos;
	private String email;
	private String contrasena;
	private boolean necesidadesEspeciales;
	private int rol;
	
	public String getUsername() {
		return login;
	}
	public void setUsername(String login) {
		this.login = login;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean isNecesidadesEspeciales() {
		return necesidadesEspeciales;
	}
	public void setNecesidadesEspeciales(boolean necesidadesEspeciales) {
		this.necesidadesEspeciales = necesidadesEspeciales;
	}
	public int isRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}


}
