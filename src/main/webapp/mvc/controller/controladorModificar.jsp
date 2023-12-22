<%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.io.PrintWriter" %>
<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
/**
 * Página de controlador para la actualización de datos de usuario.
 * Verifica la sesión del usuario antes de realizar la actualización.
 */
if(userBean.getEmail()==null || userBean.getEmail().isEmpty())
{
	response.sendRedirect("/Practica3" + "?message=" + URLEncoder.encode("Inicia sesión o Registrate", "UTF-8"));	
}
%>

<%
// Recuperar los parámetros del formulario
String nuevoNombre = request.getParameter("nombre");
String nuevoApellido = request.getParameter("apellido");
String nuevaFechaNacimiento = request.getParameter("fechaNacimiento");
String nuevaPassword = request.getParameter("password");

// Realizar la conexión a la base de datos (ajusta estos valores según tu configuración)
String jdbcUrl = "jdbc:mysql://oraclepr.uco.es:3306/i02rafea";
String dbUser = "i02rafea";
String dbPassword = "usuario";

try {
	Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

    // Preparar la sentencia SQL para la actualización
    String sql = "UPDATE Usuarios SET nombre=?, apellido=?, fechaNacimiento=?, password=? WHERE email=?";
    PreparedStatement statement = connection.prepareStatement(sql);

    // Establecer los valores de los parámetros en la sentencia SQL
    statement.setString(1, nuevoNombre);
    statement.setString(2, nuevoApellido);
    statement.setString(3, nuevaFechaNacimiento);
    statement.setString(4, nuevaPassword);
    statement.setString(5, userBean.getEmail());  // Ajusta esto según tu modelo

    // Ejecutar la actualización
    statement.executeUpdate();


    // Cerrar la conexión y la declaración
    statement.close();
    connection.close();

} catch (Exception e) {
    e.printStackTrace();
}
%>