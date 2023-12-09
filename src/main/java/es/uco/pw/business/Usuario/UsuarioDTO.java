package es.uco.pw.business.Usuario;


public class UsuarioDTO {

	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private boolean necesidadesEspeciales;
	private boolean Admin;
	
	public UsuarioDTO(String nombre, String apellidos, String email, String password, boolean necesidadesEspeciales,
			boolean admin) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.necesidadesEspeciales = necesidadesEspeciales;
		Admin = admin;
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
