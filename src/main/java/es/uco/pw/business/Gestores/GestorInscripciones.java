package es.uco.pw.business.Gestores;

import java.sql.ResultSet;

import es.uco.pw.business.Factory.Inscripcion_DTO;
import es.uco.pw.data.dao.Inscripcion.InscripcionDAO;

public class GestorInscripciones {

    public static boolean crearInscripcion(int idAsistente, int idCampamento, double precio) {
    	return InscripcionDAO.crearInscripcion(idAsistente, idCampamento, precio);
    }
    
    public static ResultSet listarInscripciones() {
    	return InscripcionDAO.listarInscripciones();
    }
    
    public static double calcularPrecioInscripcion(int IdCampamento, boolean inscripcionCompleta) {
    	return InscripcionDAO.calcularPrecioInscripcion(IdCampamento, inscripcionCompleta);
    }
    
    public static boolean calcularRegistro(int idCampamento) {
    	return InscripcionDAO.calcularRegistro(idCampamento);
    }
    
    public static ResultSet listarCampamentos() {
    	return InscripcionDAO.listarCampamentos();
    }
    
	public static Boolean eliminarInscripcion(int idInscripcion) {
		return InscripcionDAO.eliminarInscripcion(idInscripcion);
	}
	
	public static boolean ComprobarInscripcion(int Id_asistente, int Id_Campamento) {
		return InscripcionDAO.ComprobarInscripcion(Id_asistente, Id_Campamento);
	}

	public static String listarInscripcionesAsistente(int Id_asistente) {
		return InscripcionDAO.listarInscripcionesAsistente(Id_asistente);
	}

}
