package es.uco.pw.business.Usuario;


public class UsuarioDTO {

	private int idUsuario;

	private String login;
	private String password;
	private String nombre;
	private String apellidos;
	private String email;
	private String contrasena;
	private boolean necesidadesEspeciales;
	private int rol;
	
	public UsuarioDTO(int idUsuario, String login, String password, String nombre, String apellidos, String email,
			String contrasena, boolean necesidadesEspeciales, int rol) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasena = contrasena;
		this.necesidadesEspeciales = necesidadesEspeciales;
		this.rol = rol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	
	
	
	
}
