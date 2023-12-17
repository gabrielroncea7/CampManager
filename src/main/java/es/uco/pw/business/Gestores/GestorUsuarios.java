package es.uco.pw.business.Gestores;

import es.uco.pw.business.Asistente.Asistente_DTO;
import es.uco.pw.business.Usuario.UsuarioDTO;
import es.uco.pw.data.dao.Usuario.UsuarioDAO;

public class GestorUsuarios {

	
		public static boolean existeUsuario(UsuarioDTO usuarioDTO)
		{
			return UsuarioDAO.existeUsuario(usuarioDTO);
		}
		
		public static boolean escribirUsuario(UsuarioDTO usuarioDTO)
	    {
	    	return UsuarioDAO.escribirUsuario(usuarioDTO);
	    }
	    public static UsuarioDTO listarUsuario(String emailUser, String passUser) {
	    	
	    	return UsuarioDAO.listarUsuario(emailUser, passUser);
	    } 
	    
	    public static boolean asociarAsistenteUsuario(String emailUser, int idAsistente) {
	    	
	    	return UsuarioDAO.asociarAsistenteUsuario(emailUser, idAsistente);
	    }
	    
	    public static int obtenerAsistenteUsuario(String emailUser) {
	    	
	    	return UsuarioDAO.obtenerAsistenteUsuario(emailUser);
	    }
	    
	    public static int obtenerIdAsistenteUsuario(Asistente_DTO asistenteDTO) {
	    	
	    	return UsuarioDAO.obtenerIdAsistenteUsuario(asistenteDTO);
	    }
	    

}
