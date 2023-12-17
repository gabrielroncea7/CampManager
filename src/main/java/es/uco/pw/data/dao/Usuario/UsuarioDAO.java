package es.uco.pw.data.dao.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

import es.uco.pw.business.Asistente.Asistente_DTO;
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
            Date fechaNacimientoSQL = Date.valueOf(usuarioDTO.getFechaNacimiento());
            preparedStatement.setDate(4, fechaNacimientoSQL);
            preparedStatement.setString(5, usuarioDTO.getPassword());            
            preparedStatement.setBoolean(6, usuarioDTO.isNecesidadesEspeciales());
            preparedStatement.setBoolean(7, usuarioDTO.isAdmin());

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
        String existeUsuarioQuery = SQLQueries.getQuery("sql.existeUsuario");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeUsuarioQuery)) {
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

    public static UsuarioDTO listarUsuario(String emailUser, String passUser) {
        int id;
        String nombre = null;
        String apellidos = null;
        String email = null;
        Date dateFechaNacimiento;
        String password = null;
        boolean atencionEspecial = false;
        boolean esAdmin = false;
        LocalDate fechaNacimiento = null;

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String existeUsuarioQuery = SQLQueries.getQuery("sql.listarUsuario");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeUsuarioQuery)) {
            preparedStatement.setString(1, emailUser);
            preparedStatement.setString(2, passUser);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
                nombre = resultSet.getString(2);
                apellidos = resultSet.getString(3);
                dateFechaNacimiento = resultSet.getDate(4);
                email = resultSet.getString(5);
                password = resultSet.getString(6);
                atencionEspecial = resultSet.getBoolean(7);
                esAdmin = resultSet.getBoolean(8);

                // Manejo de la conversión de fecha
                if (dateFechaNacimiento != null) {
                    fechaNacimiento = dateFechaNacimiento.toLocalDate();
                }

                UsuarioDTO usuarioDTO = new UsuarioDTO(nombre, apellidos, email, password, fechaNacimiento, atencionEspecial, esAdmin);
                return usuarioDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO(nombre, apellidos, email, password, fechaNacimiento, atencionEspecial, esAdmin);
        return usuarioDTO;
    }
    
    
	public static boolean asociarAsistenteUsuario(String emailUser, int idAsistente) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	    String asociarAsistenteUsuarioQuery = SQLQueries.getQuery("sql.asociarUsuarioAsistente");

	    try {
	        PreparedStatement preparedStatement = connection.prepareStatement(asociarAsistenteUsuarioQuery);
	        preparedStatement.setString(1, emailUser);
	        preparedStatement.setInt(2, idAsistente);
	        
        	int rowsAffected = preparedStatement.executeUpdate();
    	    return rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        dbConnection.closeConnection();
	    }

	}
	
	
    public static int obtenerAsistenteUsuario(String emailUser) {
        int id = 0;

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String obtenerAsistenteUsuarioQuery = SQLQueries.getQuery("sql.obtenerAsistenteUsuario");

        try (PreparedStatement preparedStatement = connection.prepareStatement(obtenerAsistenteUsuarioQuery)) {
            preparedStatement.setString(1, emailUser);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static int obtenerIdAsistenteUsuario(Asistente_DTO asistenteDTO) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        int id=0;
        
        // Realiza una consulta SQL para verificar si la asociación ya existe.
        // Devuelve true si existe, false si no.
        String obtenerIdAsistenteUsuarioQuery = SQLQueries.getQuery("sql.obtenerIdAsistenteUsuario");

        try (PreparedStatement preparedStatement = connection.prepareStatement(obtenerIdAsistenteUsuarioQuery)) {
            preparedStatement.setString(1, asistenteDTO.getNombre());
            preparedStatement.setString(2, asistenteDTO.getApellidos());
            preparedStatement.setDate(3, Date.valueOf(asistenteDTO.getFechaNacimiento()));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
	

    }