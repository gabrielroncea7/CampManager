package es.uco.pw.business.Gestores;

import java.sql.ResultSet;

import es.uco.pw.business.Asistente.Asistente_DTO;
import es.uco.pw.data.dao.Asistente.AsistenteDAO;

public class GestorAsistentes {

    public static boolean escribirAsistente(Asistente_DTO AsistenteDTO) {
    	return AsistenteDAO.escribirAsistente(AsistenteDTO);
    }
    
    public static ResultSet listarAsistentes()
    {
		return AsistenteDAO.listarAsistentes();
    }
    
    public static boolean modificarAsistente(int id_asistente,Asistente_DTO AsistenteDTO)
    {
    	return AsistenteDAO.modificarAsistente(id_asistente, AsistenteDTO);
    }
    
    public static boolean existeAsistente(int id_Persona) {
    	return AsistenteDAO.existeAsistente(id_Persona);
    }
    
    
}
