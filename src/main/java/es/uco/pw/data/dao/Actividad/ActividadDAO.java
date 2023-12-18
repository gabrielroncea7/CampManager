package es.uco.pw.data.dao.Actividad;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uco.pw.business.Actividad.Actividad_DTO;
import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

/**
 * Esta clase proporciona métodos para interactuar con la tabla de actividades en la base de datos.
 */
public class ActividadDAO {
	
    /**
     * Escribe una nueva actividad en la base de datos.
     *
     * @param nombre           Nombre de la actividad.
     * @param nivelEducativo   Nivel educativo de la actividad.
     * @param horarioActividad Horario de la actividad.
     * @param nParticipantes   Número de participantes.
     * @param nMonitores       Número de monitores.
     * @return                 True si la operación fue exitosa, false en caso contrario.
     */
    public static boolean escribirActividad(Actividad_DTO Actividad) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String escribirActividadQuery = SQLQueries.getQuery("sql.escribirActividad");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(escribirActividadQuery);
            preparedStatement.setString(1, Actividad.getNombreActividad());
            preparedStatement.setString(2, Actividad.getnEducativo().name());
            preparedStatement.setString(3, Actividad.gethActividad().name());
            preparedStatement.setObject(4, Actividad.getNumeroParticipantes());
            preparedStatement.setInt(5, Actividad.getMonitoresNecesarios());

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
     * Lista todas las actividades almacenadas en la base de datos.
     *
     * @return ResultSet con el resultado de la consulta.
     */
    public static ResultSet listarActividades() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarActividadQuery = SQLQueries.getQuery("sql.listarActividad");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarActividadQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    /**
     * Verifica si una actividad con el nombre proporcionado ya existe en la base de datos.
     *
     * @param nombre Nombre de la actividad a verificar.
     * @return       True si la actividad existe, false en caso contrario.
     */
    public static boolean existeActividad(String nombre) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String existeActividadQuery = SQLQueries.getQuery("sql.existeActividad");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeActividadQuery)) {
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;  // Si count > 0, significa que la actividad existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }




}
