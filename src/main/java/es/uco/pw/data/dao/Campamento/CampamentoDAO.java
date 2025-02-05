package es.uco.pw.data.dao.Campamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uco.pw.business.Campamento.Campamento_DTO;
import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

public class CampamentoDAO {
    
    /**
     * Escribe un nuevo campamento en la base de datos.
     *
     * @param fechaInicio        Fecha de inicio del campamento.
     * @param fechaFin           Fecha de fin del campamento.
     * @param nivelEducativo     Nivel educativo del campamento.
     * @param numeroMaxAsistentes Número máximo de asistentes al campamento.
     * @param monitorAsignado    Indica si ya hay un monitor asignado al campamento.
     * @return                   True si la operación fue exitosa, false en caso contrario.
     */
    public static boolean escribirCampamento(Campamento_DTO Campamento) {
        // Obtener la conexión desde la clase DBConnection
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Consulta SQL para la inserción
        String escribirCampamentoQuery = SQLQueries.getQuery("sql.escribirCampamento");

        try {
            // Crear una sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(escribirCampamentoQuery);
            Date fechaSQL = Date.valueOf(Campamento.getFechaInicio());
            preparedStatement.setDate(1, fechaSQL);
            fechaSQL = Date.valueOf(Campamento.getFechaFin());
            preparedStatement.setDate(2, fechaSQL);
            preparedStatement.setString(3, Campamento.getNivelEducativo().name());
            preparedStatement.setInt(4, Campamento.getNumeroMaximoAsistentes());
            preparedStatement.setBoolean(5, Campamento.isMonitorAsignado());

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
     * Obtiene un conjunto de resultados con la lista de campamentos.
     *
     * @return ResultSet con la lista de campamentos.
     */
    public static ResultSet listarCampamentos() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarCampamentoQuery = SQLQueries.getQuery("sql.listarCampamento");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarCampamentoQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    public static ResultSet listarCampamentosDisponibles(String fechaInicio, String fechaFin) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarCampamentosDisponiblesQuery = SQLQueries.getQuery("sql.listarCampamentosDisponibles");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarCampamentosDisponiblesQuery);
            
            preparedStatement.setString(1, fechaInicio);
            preparedStatement.setString(2, fechaFin);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }

    /**
     * Obtiene un conjunto de resultados con la lista de campamentos en español.
     *
     * @return ResultSet con la lista de campamentos en español.
     */
    public static ResultSet listarCampamentosES() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarMonitorESQuery = SQLQueries.getQuery("sql.listarCampamentosES");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarMonitorESQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    public static ResultSet listarAsistentesCampamento(int IdCampamento) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarAsistentesCampamentoQuery = SQLQueries.getQuery("sql.listarAsistentesCampamento");

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(listarAsistentesCampamentoQuery);
            preparedStatement.setInt(1, IdCampamento);
            
            ResultSet resultSet = preparedStatement.executeQuery();

                 return resultSet;  	

           
        	} catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    public static boolean existeCampamento(int id_Campamento) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String existeCampamentoQuery = SQLQueries.getQuery("sql.existeCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(existeCampamentoQuery)) {
            preparedStatement.setInt(1, id_Campamento);
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
    
    public static ResultSet listarCampamentosNivelEducativo(String nivelEductivo) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarCampamentosNivelEducativoQuery = SQLQueries.getQuery("sql.listarCampamentosNivelEducativo");

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(listarCampamentosNivelEducativoQuery);
            preparedStatement.setString(1, nivelEductivo);
            
            ResultSet resultSet = preparedStatement.executeQuery();

                 return resultSet;  	

           
        	} catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    
    public static ResultSet listarCampamentosPlazasLibres(int plazaslibres) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarCampamentosPlazasLibresQuery = SQLQueries.getQuery("sql.listarCampamentosPlazasLibres");

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(listarCampamentosPlazasLibresQuery);
            preparedStatement.setInt(1, plazaslibres);
            
            ResultSet resultSet = preparedStatement.executeQuery();

                 return resultSet;  	

           
        	} catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
}
