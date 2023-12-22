package es.uco.pw.data.dao.Monitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uco.pw.business.Monitor.Monitor_DTO;
import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

/**
 * Clase que proporciona métodos para interactuar con la base de datos relacionados con la entidad Monitor.
 */
public class MonitorDAO {

    /**
     * Escribe un nuevo registro de monitor en la base de datos.
     *
     * @param nombre      El nombre del monitor.
     * @param apellidos   Los apellidos del monitor.
     * @param edEspecial  Indica si el monitor tiene educación especial.
     * @return            True si la escritura fue exitosa, false en caso contrario.
     */
    public static boolean escribirMonitor(Monitor_DTO Monitor) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String escribirMonitorQuery = SQLQueries.getQuery("sql.escribirMonitor");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(escribirMonitorQuery);
            preparedStatement.setString(1, Monitor.getNombre());
            preparedStatement.setString(2, Monitor.getApellidos());
            preparedStatement.setBoolean(3, Monitor.getEducadorespecial());

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
     * Obtiene un ResultSet con la lista de monitores desde la base de datos.
     *
     * @return Un ResultSet con la lista de monitores, o null en caso de error.
     */
    public static ResultSet listarMonitores() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarMonitorQuery = SQLQueries.getQuery("sql.listarMonitor");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarMonitorQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    /**
     * Obtiene un ResultSet con la lista de monitores con educación especial desde la base de datos.
     *
     * @return Un ResultSet con la lista de monitores, o null en caso de error.
     */
    public static ResultSet listarMonitoresES() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarMonitorESQuery = SQLQueries.getQuery("sql.listarMonitorES");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarMonitorESQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }

    /**
     * Verifica si un monitor ya existe en la base de datos.
     *
     * @param nombre   El nombre del monitor.
     * @param apellido Los apellidos del monitor.
     * @return         True si el monitor existe, false en caso contrario.
     */
    public static boolean existeMonitor(int id)
    {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String existeMonitorQuery = SQLQueries.getQuery("sql.existeMonitor");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeMonitorQuery)) {
            preparedStatement.setInt(1, id);


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
    
   
}
