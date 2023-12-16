package es.uco.pw.data.dao.Asistente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uco.pw.business.Asistente.Asistente_DTO;
import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

/**
 * Esta clase proporciona métodos para interactuar con la tabla de asistentes en la base de datos.
 */
public class AsistenteDAO {

    /**
     * Escribe un nuevo asistente en la base de datos.
     *
     * @param nombre            Nombre del asistente.
     * @param apellidos         Apellidos del asistente.
     * @param fechaNacimiento   Fecha de nacimiento del asistente.
     * @param atencionEspecial  Indica si el asistente requiere atención especial.
     * @return                  True si la operación fue exitosa, false en caso contrario.
     */
    public static boolean escribirAsistente(Asistente_DTO AsistenteDTO) {
        // Obtener la conexión desde la clase DBConnection
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Consulta SQL para la inserción
        String insertAsistentesQuery = SQLQueries.getQuery("sql.escribirAsistente");

        try {
            // Crear una sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(insertAsistentesQuery);
            preparedStatement.setString(1, AsistenteDTO.getNombre());
            preparedStatement.setString(2, AsistenteDTO.getApellidos() );
            Date fechaNacimientoSQL = Date.valueOf(AsistenteDTO.getFechaNacimiento());
            preparedStatement.setDate(3, fechaNacimientoSQL);
            preparedStatement.setBoolean(4, AsistenteDTO.getNecesitaAtencionEspecial());

            // Ejecutar la inserción
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            dbConnection.closeConnection(); // Cerrar la conexión después de su uso
        }
    }

    /**
     * Lista todos los asistentes almacenados en la base de datos.
     *
     * @return ResultSet con el resultado de la consulta.
     */
    public static ResultSet listarAsistentes() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String selectAsistentesQuery = SQLQueries.getQuery("sql.listarAsistentes");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAsistentesQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }

    /**
     * Modifica la información de un asistente en la base de datos.
     *
     * @param idPersona         ID del asistente a modificar.
     * @param nombre            Nuevo nombre del asistente.
     * @param apellidos         Nuevos apellidos del asistente.
     * @param fechaNacimiento   Nueva fecha de nacimiento del asistente.
     * @param atencionEspecial  Indica si el asistente requiere atención especial.
     * @return                  True si la operación fue exitosa, false en caso contrario.
     */
    public static boolean modificarAsistente(int idPersona, Asistente_DTO AsistenteDTO) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String updateAsistentesQuery = SQLQueries.getQuery("sql.updateAsistente");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateAsistentesQuery);
            preparedStatement.setString(1, AsistenteDTO.getNombre());
            preparedStatement.setString(2, AsistenteDTO.getApellidos());
            // Convierte LocalDate a java.sql.Date
            Date fechaNacimientoSQL = Date.valueOf(AsistenteDTO.getFechaNacimiento());
            preparedStatement.setDate(3, fechaNacimientoSQL);
            preparedStatement.setBoolean(4, AsistenteDTO.getNecesitaAtencionEspecial());
            preparedStatement.setInt(5, idPersona);

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
     * Verifica si un asistente con el ID proporcionado ya existe en la base de datos.
     *
     * @param idPersona ID del asistente a verificar.
     * @return          True si el asistente existe, false en caso contrario.
     */
    public static boolean existeAsistente(int id_Persona) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String existeAsistenteQuery = SQLQueries.getQuery("sql.existeAsistente");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeAsistenteQuery)) {
            preparedStatement.setInt(1, id_Persona);
            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
