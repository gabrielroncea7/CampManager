package es.uco.pw.business.Gestores;

import java.sql.ResultSet;

import es.uco.pw.business.Actividad.Actividad_DTO;
import es.uco.pw.business.Campamento.Campamento_DTO;
import es.uco.pw.business.Monitor.Monitor_DTO;
import es.uco.pw.data.dao.Actividad.ActividadDAO;
import es.uco.pw.data.dao.Campamento.CampamentoDAO;
import es.uco.pw.data.dao.Inscripcion.AsociarDAO;
import es.uco.pw.data.dao.Monitor.MonitorDAO;

public class GestorCampamentos {

	//Campamento
	
	public static boolean escribirCampamento(Campamento_DTO Campamento)
	{
		return CampamentoDAO.escribirCampamento(Campamento);
	}
	
    public static ResultSet listarCampamentos() {
    	return CampamentoDAO.listarCampamentos();
    }
    
    public static ResultSet listarCampamentosES() {
    	return CampamentoDAO.listarCampamentosES();
    }

    public static ResultSet listarAsistentesCampamento(int IdCampamento)
    {
    	return CampamentoDAO.listarAsistentesCampamento(IdCampamento);
    }
        
	//Actividad
	public static boolean escribirActividad(Actividad_DTO Actividad)
	{
		return ActividadDAO.escribirActividad(Actividad);		
	}
	
    public static ResultSet listarActividades() {
    	return ActividadDAO.listarActividades();
    }
    
    public static boolean existeActividad(String nombre) {
    	return ActividadDAO.existeActividad(nombre);
    }

    //Monitor
    
	public static boolean escribirMonitor(Monitor_DTO Monitor)
	{
		return MonitorDAO.escribirMonitor(Monitor);
	}
	
    public static ResultSet listarMonitores() {
		return MonitorDAO.listarMonitores();

    }

    public static ResultSet listarMonitoresES() {
		return MonitorDAO.listarMonitoresES();
    }

    public static boolean existeMonitor(String nombre, String apellido) {
    	return MonitorDAO.existeMonitor(nombre, apellido);
    }

    //Asociar
    
	public static boolean asociarMonitorAActividad(int idMonitor,String nombre_actividad)
	{
		return AsociarDAO.asociarMonitorAActividad(idMonitor, nombre_actividad);
	}
	
	public static boolean asociarActividadCampamento(String nombre_actividad, int idcampamento) {
		return AsociarDAO.asociarActividadCampamento(nombre_actividad, idcampamento);
	}
	
	public static boolean existeMonitorActividad(int idMonitor) {
		return AsociarDAO.existeMonitorActividad(idMonitor);
	}
	
	public static boolean existeActividadMonitor(String nombre_actividad, int idmonitor) {
		return AsociarDAO.existeActividadMonitor(nombre_actividad, idmonitor);
	}

    public static boolean existeActividadCampamento(String nombreActividad, int idCampamento){
    	return AsociarDAO.existeActividadCampamento(nombreActividad, idCampamento);
    }
    
    public static void actualizarActividadCampamento(String nombreActividad, int idCampamento){
    	AsociarDAO.actualizarActividadCampamento(nombreActividad, idCampamento);
    }

    public static void insertarActividadCampamento(String nombreActividad, int idCampamento){
    	AsociarDAO.insertarActividadCampamento(nombreActividad, idCampamento);
    }

    public static boolean existeMonitorCampamento(int idMonitor, int idCampamento){
    	return AsociarDAO.existeMonitorCampamento(idMonitor, idCampamento);
    }
    
    public static void insertarMonitorCampamento(int idMonitor, int idCampamento){
    	AsociarDAO.insertarMonitorCampamento(idMonitor, idCampamento);
    }
    
	public static boolean asociarMonitorCampamento(int idMonitor, int id_Campamento) {
		return AsociarDAO.asociarMonitorCampamento(idMonitor, id_Campamento);
	}
	
	public static boolean comprobarMonitoresMax(String Nombre) {
		return AsociarDAO.comprobarMonitoresMax(Nombre);
	}
	
	public static boolean mismoNivelEducativo(String nombre_Actividad, int idCampamento) {
		return AsociarDAO.mismoNivelEducativo(nombre_Actividad, idCampamento);
	}	
}
