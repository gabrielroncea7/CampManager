package es.uco.pw.data.dao.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;

import es.uco.pw.business.Usuario.UsuarioDTO;
import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

/**
 * Esta clase proporciona métodos para interactuar con la tabla de asistentes en la base de datos.
 */

public class UsuarioDAO {
	
    /**
     * Escribe un nuevo asistente en la base de datos.
     *
     * @param nombre            Nombre del asistente.
     * @param apellidos         Apellidos del asistente.
     * @param fechaNacimiento   Fecha de nacimiento del asistente.
     * @param atencionEspecial  Indica si el asistente requiere atención especial.
     * @return                  True si la operación fue exitosa, false en caso contrario.
     */
    public static boolean escribirUsuario(UsuarioDTO usuarioDTO) {
        // Obtener la conexión desde la clase DBConnection
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Consulta SQL para la inserción
        String insertUsuariosQuery = SQLQueries.getQuery("sql.escribirUsuario");

        try {
            // Crear una sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(insertUsuariosQuery);
            preparedStatement.setString(1, usuarioDTO.getNombre());
            preparedStatement.setString(2, usuarioDTO.getApellidos());
            preparedStatement.setString(3, usuarioDTO.getEmail());
            preparedStatement.setString(4, usuarioDTO.getPassword());            
            preparedStatement.setBoolean(5, usuarioDTO.isNecesidadesEspeciales());
            preparedStatement.setBoolean(6, usuarioDTO.isAdmin());

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

    
    public static boolean existeUsuario(UsuarioDTO usuarioDTO) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String existeAsistenteQuery = SQLQueries.getQuery("sql.existeUsuario");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeAsistenteQuery)) {
            preparedStatement.setString(1, usuarioDTO.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;  // Si count > 0, significa que el usuario existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
