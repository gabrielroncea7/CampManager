package es.uco.pw.data.dao.Inscripcion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.pw.data.common.DBConnection;
import es.uco.pw.data.common.SQLQueries;

/**
 * Clase que gestiona el registro, modificación y listado de las Inscripciones en un campamento.
 */
public class InscripcionDAO {
    LocalDate fechaActual = LocalDate.now(); // Fecha actual del sistema
    Date fechaActualSQL = Date.valueOf(fechaActual);
    static DateTimeFormatter DateFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static Scanner scanner;

    /**
     * Crea una nueva inscripción para un asistente en un campamento.
     *
     * @param idAsistente       ID del asistente.
     * @param idCampamento      ID del campamento.
     * @param precio            Precio de la inscripción.
     * @return                  True si la inscripción fue creada con éxito, false en caso contrario.
     */
    public static boolean crearInscripcion(int idAsistente, int idCampamento, double precio) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        // Realizar la verificación de disponibilidad del campamento
        LocalDate fechaInscripcion = LocalDate.now(); // Obtener la fecha actual
        String escribirInscripcionQuery = SQLQueries.getQuery("sql.escribirInscripcion");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(escribirInscripcionQuery);
            preparedStatement.setInt(1, idAsistente);
            preparedStatement.setInt(2, idCampamento);
            preparedStatement.setDate(3, java.sql.Date.valueOf(fechaInscripcion));
            preparedStatement.setDouble(4, precio);
            boolean registroCompleto = calcularRegistro(idCampamento); // función
            preparedStatement.setBoolean(5, registroCompleto);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Actualizar el número de asistentes inscritos en el campamento
                String actualizarAsistentesQuery = SQLQueries.getQuery("sql.actualizarAsistentes");

                PreparedStatement updateStatement = connection.prepareStatement(actualizarAsistentesQuery);
                updateStatement.setInt(1, idCampamento);
                updateStatement.executeUpdate();
            }
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpia el buffer del scanner
            System.out.println("Error: Debes ingresar un número entero.");
            // Vuelve al inicio del bucle para que el usuario ingrese nuevamente
        } finally {
            dbConnection.closeConnection();
        }

        return false;
    }

    /**
     * Lista todas las inscripciones.
     *
     * @return ResultSet con la información de las inscripciones.
     */
    public static ResultSet listarInscripciones() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarInscripcionQuery = SQLQueries.getQuery("sql.listarInscripcion");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarInscripcionQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }

    /**
     * Calcula el precio de una inscripción en un campamento.
     *
     * @param IdCampamento          ID del campamento.
     * @param inscripcionCompleta   Indica si la inscripción es completa.
     * @return                      Precio calculado de la inscripción.
     */
    public static double calcularPrecioInscripcion(int IdCampamento, boolean inscripcionCompleta) {
        double costoActividades = 0;

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL para obtener el número de actividades
        String nActividadesQuery = SQLQueries.getQuery("sql.listarNumeroActividades");

        try (PreparedStatement preparedStatement = connection.prepareStatement(nActividadesQuery)) {
            preparedStatement.setInt(1, IdCampamento);

            try (ResultSet nActividades = preparedStatement.executeQuery()) {
                // Verifica si hay resultados en el conjunto de resultados
                if (nActividades.next()) {
                    // Obtén el valor de la columna de número de actividades
                    int numeroActividades = nActividades.getInt(1);
                    costoActividades = numeroActividades * 20;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        double precioBase = (inscripcionCompleta) ? 300 : 100;
        return precioBase + costoActividades;
    }

    /**
     * Calcula si es posible realizar una inscripción en un campamento.
     *
     * @param idCampamento  ID del campamento.
     * @return              True si es posible, false en caso contrario.
     */
    public static boolean calcularRegistro(int idCampamento) {
        // Obtener la fecha actual del sistema
        LocalDate fechaActual = LocalDate.now();
        Date fechaInicioDate = null;

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        // Realiza una consulta SQL
     // Realiza una consulta SQL para obtener la fecha de inicio del campamento
        String nActividadesQuery = SQLQueries.getQuery("sql.fechaInicioCampamento");

        try (PreparedStatement preparedStatement = connection.prepareStatement(nActividadesQuery)) {
            preparedStatement.setInt(1, idCampamento);

            try (ResultSet fInicio = preparedStatement.executeQuery()) {
                if (fInicio.next()) {
                    fechaInicioDate = fInicio.getDate(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convertir la fecha de inicio de Date a LocalDate para poder calcular la
        // diferencia de días con la fecha actual
        String fechaInicioString = fechaInicioDate.toString();

        LocalDate fechaInicio = LocalDate.parse(fechaInicioString, DateFormato);

        // Calcula la diferencia en días
        long diferenciaDias = Math.abs(ChronoUnit.DAYS.between(fechaActual, fechaInicio));

        if (diferenciaDias > 15) {
            System.out.println("Periodo de inscripción: TEMPRANO.");
            return true;
        } else if (diferenciaDias < 15 && diferenciaDias > 2) {
            System.out.println("Periodo de inscripción: TARDIO.");
            return false;
        } else {
            System.out.println("El periodo de inscripción ha expirado.");
            // NO SE PUEDE
            return false;
        }
    }

    /**
     * Lista todos los campamentos disponibles.
     *
     * @return ResultSet con la información de los campamentos.
     */
    public static ResultSet listarCampamentos() {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String listarcampamentosInsQuery = SQLQueries.getQuery("sql.listarcampamentosIns");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(listarcampamentosInsQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet; // Devuelve el resultado para ser manejado en la función main
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // En caso de error, devuelve null
        }
    }
    

    /**
     * Elimina la inscripcion segun el id proporcionado.
     *
     * @return ResultSet con la información de las inscripciones.
     */
    
	public static Boolean eliminarInscripcion(int idInscripcion) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();

	    String actualizarinscripcionQuery = SQLQueries.getQuery("sql.actualizarinscripcion");

	    try(PreparedStatement preparedStatement = connection.prepareStatement(actualizarinscripcionQuery)) {
		        preparedStatement.setInt(1, idInscripcion);
		        int filasAfectadas = preparedStatement.executeUpdate();
	
		        if (filasAfectadas > 0) {
	                // Actualizar el número de asistentes inscritos en el campamento
		        	String eliminarInscripcionQuery = SQLQueries.getQuery("sql.eliminarInscripcion");
	                

	                PreparedStatement updateStatement = connection.prepareStatement(eliminarInscripcionQuery);
	                updateStatement.setInt(1, idInscripcion);
	                updateStatement.executeUpdate();
	            }
	            return filasAfectadas > 0;
	        } catch (SQLException e) {
	        	e.printStackTrace();	}
		return false;
	}
	
	public static boolean ComprobarInscripcion(int Id_asistente, int Id_Campamento) {
		DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
    // Realiza una consulta SQL para verificar si la asociación ya existe.
    // Devuelve true si existe, false si no.
	   String comprobarAsistenteCampamentoQuery = SQLQueries.getQuery("sql.comprobar.asistenteCampamento");

    try (PreparedStatement preparedStatement = connection.prepareStatement(comprobarAsistenteCampamentoQuery)) {
        preparedStatement.setInt(1, Id_asistente);
        preparedStatement.setInt(2, Id_Campamento);

        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;  // Si count > 0, significa que el asistente ya está inscrito
        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	return false;
	}

	public static ResultSet listarInscripcionesAsistente(int Id_asistente) {		
		DBConnection dbConnection = new DBConnection();
	    Connection connection = dbConnection.getConnection();
	    
	   String listarInscripcionesAsistenteQuery = SQLQueries.getQuery("sql.listarInscripcionesAsistente");

    try (PreparedStatement preparedStatement = connection.prepareStatement(listarInscripcionesAsistenteQuery)) {
        preparedStatement.setInt(1, Id_asistente);

        ResultSet resultSet = preparedStatement.executeQuery();
        
        return resultSet;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    	}
	}
}
