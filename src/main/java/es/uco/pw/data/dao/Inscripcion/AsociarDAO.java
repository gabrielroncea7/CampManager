package es.uco.pw.data.dao.Inscripcion;

import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que proporciona métodos para asociar monitores a actividades y actividades a campamentos en la base de datos.
 */
public class AsociarDAO {

    /**
     * Asocia un monitor a una actividad en la base de datos.
     *
     * @param idMonitor        El ID del monitor a asociar.
     * @param nombre_actividad El nombre de la actividad a la que se asociará el monitor.
     * @return                 True si la asociación fue exitosa, false en caso contrario.
     */
	public static boolean asociarMonitorAActividad(int idMonitor, String nombre_actividad) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	    String asociarMonitorActividadQuery = SQLQueries.getQuery("sql.asociarMonitorActividad");

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(asociarMonitorActividadQuery);
	        preparedStatement.setInt(1, idMonitor);
	        preparedStatement.setString(2, nombre_actividad);
	        
        	int rowsAffected = preparedStatement.executeUpdate();
    	    return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        dbConnection.closeConnection();
	    }

	}

    /**
     * Asocia una actividad a un campamento en la base de datos.
     *
     * @param nombre_actividad El nombre de la actividad a asociar.
     * @param idcampamento     El ID del campamento al que se asociará la actividad.
     * @return                 True si la asociación fue exitosa, false en caso contrario.
     */
	public static boolean asociarActividadCampamento(String nombre_actividad, int idcampamento) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	    String asociarActividadCampamentoQuery = SQLQueries.getQuery("sql.asociarActividadCampamento");

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(asociarActividadCampamentoQuery);
	        preparedStatement.setInt(1, idcampamento);
	        preparedStatement.setString(2, nombre_actividad);
	        
        	int rowsAffected = preparedStatement.executeUpdate();
    	    return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        dbConnection.closeConnection();
	    }

	}

    /**
     * Verifica si un monitor ya está asociado a alguna actividad en la base de datos.
     *
     * @param idMonitor El ID del monitor a verificar.
     * @return          True si el monitor ya está asociado a alguna actividad, false en caso contrario.
     */
	public static boolean existeMonitorActividad(int idMonitor) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
		// Realiza una consulta para verificar si el monitor con idMonitor existe en la tabla Monitor
	    // Devuelve true si existe, false si no
	    String existeMonitorActividadQuery = SQLQueries.getQuery("sql.existeMonitorActividad");
	    
	    try {
	    	
	        PreparedStatement preparedStatement = connection.prepareStatement(existeMonitorActividadQuery);
	        preparedStatement.setInt(1, idMonitor);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;  // Si count > 0, significa que el monitor existe
	        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return false;
	}

    /**
     * Verifica si una actividad ya está asociada a un monitor en la base de datos.
     *
     * @param nombre_actividad El nombre de la actividad a verificar.
     * @param idmonitor        El ID del monitor a verificar.
     * @return                 True si la actividad ya está asociada al monitor, false en caso contrario.
     */
	public static boolean existeActividadMonitor(String nombre_actividad, int idmonitor) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    boolean actividadExistente = false;
	    // Realiza una consulta para verificar si la actividad con idActividad existe en la tabla Actividad
	    // Devuelve true si existe, false si no
		String existeActividadMonitorQuery = SQLQueries.getQuery("sql.existeActividadMonitor");
	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(existeActividadMonitorQuery);
	        preparedStatement.setInt(1, idmonitor);
	        preparedStatement.setString(2, nombre_actividad);
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    actividadExistente = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
        }
	    
	    return actividadExistente;  // En caso de error o si no se encuentra la actividad
	}



/**
 * Verifica si una actividad ya está asociada a un campamento en la base de datos.
 *
 * @param nombreActividad El nombre de la actividad a verificar.
 * @param idCampamento    El ID del campamento a verificar.
 * @return                True si la actividad ya está asociada al campamento, false en caso contrario.
 */
    public static boolean existeActividadCampamento(String nombreActividad, int idCampamento){
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
        // Realiza una consulta SQL para verificar si la actividad ya está asociada.
        // Devuelve true si existe, false si no.
	    
	    String existeActividadCampamentoQuery = SQLQueries.getQuery("sql.existeActividadCampamento");
	    
        try (PreparedStatement preparedStatement = connection.prepareStatement(existeActividadCampamentoQuery)) {
            preparedStatement.setInt(1, idCampamento);
            preparedStatement.setString(2, nombreActividad);
            return preparedStatement.executeQuery().next();
        }catch (SQLException e) {
	        e.printStackTrace();
        }
        return false;
    }

/**
 * Actualiza la asociación de una actividad a un campamento en la base de datos.
 *
 * @param nombreActividad El nombre de la actividad a actualizar.
 * @param idCampamento    El ID del campamento al que se actualizará la asociación.
 */
    public static void actualizarActividadCampamento(String nombreActividad, int idCampamento){
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
        // Realiza una sentencia SQL para actualizar la asociación de la actividad al campamento.
	    String actualizarActividadCampamentoQuery = SQLQueries.getQuery("sql.actualizarActividadCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(actualizarActividadCampamentoQuery)) {
            preparedStatement.setInt(1, idCampamento);
            preparedStatement.setString(2, nombreActividad);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
	        e.printStackTrace();
        }
    }

/**
 * Inserta una nueva asociación de una actividad a un campamento en la base de datos.
 *
 * @param nombreActividad El nombre de la actividad a insertar.
 * @param idCampamento    El ID del campamento al que se asociará la actividad.
 */
    public static void insertarActividadCampamento(String nombreActividad, int idCampamento){
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
        // Realiza una sentencia SQL para insertar una nueva asociación de la actividad al campamento.
	    String insertarActividadCampamentoQuery = SQLQueries.getQuery("sql.insertarActividadCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertarActividadCampamentoQuery)) {
            preparedStatement.setString(1, nombreActividad);
            preparedStatement.setInt(2, idCampamento);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
	        e.printStackTrace();
        }
    }

/**
 * Verifica si ya existe una asociación entre un monitor y un campamento en la base de datos.
 *
 * @param idMonitor    El ID del monitor a verificar.
 * @param idCampamento El ID del campamento a verificar.
 * @return             True si la asociación ya existe, false en caso contrario.
 */
    public static boolean existeMonitorCampamento(int idMonitor, int idCampamento){
    	DBConnection dbConnection = new DBConnection();
 	    Connection connection = dbConnection.getConnection();
        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
 	   String existeMonitorCampamentoQuery = SQLQueries.getQuery("sql.existeMonitorCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeMonitorCampamentoQuery)) {
            preparedStatement.setInt(1, idCampamento);
            preparedStatement.setInt(2, idMonitor);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;  // Si count > 0, significa que el Actividad existe
            }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	return false;
        }

/**
 * Inserta una nueva asociación entre un monitor y un campamento en la base de datos.
 *
 * @param idMonitor    El ID del monitor a asociar.
 * @param idCampamento El ID del campamento al que se asociará el monitor.
 */
    public static void insertarMonitorCampamento(int idMonitor, int idCampamento){
    	DBConnection dbConnection = new DBConnection();
 	    Connection connection = dbConnection.getConnection();
        // Realiza una sentencia SQL para insertar una nueva asociación entre el monitor y el campamento.
 	   String insertarMonitorCampamentoQuery = SQLQueries.getQuery("sql.insertarMonitorCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertarMonitorCampamentoQuery)) {
            preparedStatement.setInt(1, idMonitor);
            preparedStatement.setInt(2, idCampamento);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
	        e.printStackTrace();
        }
    }

/**
 * Asocia un monitor a un campamento en la base de datos.
 *
 * @param idMonitor    El ID del monitor a asociar.
 * @param idCampamento El ID del campamento al que se asociará el monitor.
 * @return             True si la asociación fue exitosa, false en caso contrario.
 */
	public static boolean asociarMonitorCampamento(int idMonitor, int id_Campamento) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	    String asociarMonitorCampamentoQuery = SQLQueries.getQuery("sql.asociarMonitorCampamento");

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(asociarMonitorCampamentoQuery);
	        preparedStatement.setInt(1, idMonitor);
	        preparedStatement.setInt(2, id_Campamento);
	        
        	int rowsAffected = preparedStatement.executeUpdate();
    	    return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        dbConnection.closeConnection();
	    }
	}

/**
 * Comprueba si se ha alcanzado el número máximo de monitores asociados a una actividad en la base de datos.
 *
 *
     * @param nombre El nombre de la actividad a comprobar.
     * @return        True si se ha alcanzado el número máximo de monitores, false en caso contrario.
     */
	public static boolean comprobarMonitoresMax(String Nombre) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
		// Realiza una consulta para verificar si el monitor con idMonitor existe en la tabla Monitor
	    // Devuelve true si existe, false si no
	    String comprobarMonitoresMaxQuery = SQLQueries.getQuery("sql.comprobarMonitoresMax");
	    boolean existeMonitorActividad = false;
	    try {
	    	
	        PreparedStatement preparedStatement = connection.prepareStatement(comprobarMonitoresMaxQuery);
	        preparedStatement.setString(1, Nombre);
	        preparedStatement.setString(2, Nombre);
	        
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                	existeMonitorActividad = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
        }
	    
	    return existeMonitorActividad;  // En caso de error o si no se encuentra la actividad
	}

    /**
     * Verifica si una actividad tiene monitores del mismo nivel educativo en el campamento.
     *
     * @param nombreActividad El nombre de la actividad a verificar.
     * @param idCampamento    El ID del campamento al que está asociada la actividad.
     * @return                True si hay monitores del mismo nivel educativo, false en caso contrario.
     */
	public static boolean mismoNivelEducativo(String nombre_Actividad, int idCampamento) {
		DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
    // Realiza una consulta SQL para verificar si la asociación ya existe.
    // Devuelve true si existe, false si no.
	   String mismoNivelEducativodQuery = SQLQueries.getQuery("sql.mismoNivelEducativo");

    try (PreparedStatement preparedStatement = connection.prepareStatement(mismoNivelEducativodQuery)) {
        preparedStatement.setString(1, nombre_Actividad);
        preparedStatement.setInt(2, idCampamento);

        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;  // Si count > 0, significa que el Actividad existe
        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	return false;
	}
}

