package es.uco.pw.business.Gestores;

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
	    

}
