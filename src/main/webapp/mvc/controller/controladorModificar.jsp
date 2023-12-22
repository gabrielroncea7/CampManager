<%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.io.PrintWriter, es.uco.pw.data.common.SQLQueries, es.uco.pw.data.common.DBConnection" %>
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
String nextPage = "";
String nextmessagepage = "";
// Recuperar los parámetros del formulario
String nuevoNombre = request.getParameter("nombre");
String nuevoApellido = request.getParameter("apellido");
String nuevaFechaNacimiento = request.getParameter("fechaNacimiento");
String nuevaPassword = request.getParameter("password");

// Realizar la conexión a la base de datos (ajusta estos valores según tu configuración)
DBConnection dbConnection = new DBConnection();
Connection connection = dbConnection.getConnection();
String modificarDatosQuery = SQLQueries.getQuery("sql.modificarDatos");
UsuarioDTO usuarioDTO = GestorUsuarios.listarUsuario(userBean.getEmail(), nuevaPassword);

try {


    // Preparar la sentencia SQL para la actualización

    PreparedStatement statement = connection.prepareStatement(modificarDatosQuery);

    // Establecer los valores de los parámetros en la sentencia SQL
    statement.setString(1, nuevoNombre);
    statement.setString(2, nuevoApellido);
    statement.setString(3, nuevaFechaNacimiento);
    statement.setString(4, nuevaPassword);
    statement.setString(5, userBean.getEmail());  // Ajusta esto según tu modelo

    // Ejecutar la actualización
    statement.executeUpdate();
    
       

} catch (Exception e) {
    e.printStackTrace();
}
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

userBean.setNombre(nuevoNombre);
userBean.setApellidos(nuevoApellido);
userBean.setEmail(usuarioDTO.getEmail());
userBean.setFechaNacimiento(LocalDate.parse(nuevaFechaNacimiento, formatter));
userBean.setPassword(nuevaPassword);
userBean.setAdmin(usuarioDTO.isAdmin());

if(usuarioDTO.isAdmin())
{
     nextPage = "../view/adminView.jsp";  
 	nextmessagepage ="Datos Actualizados";
}
else
{
	nextPage = "/Practica3/mostrarInscripciones";    
	nextmessagepage ="Datos Actualizados";
}
response.sendRedirect(nextPage + "?message=" + URLEncoder.encode(nextmessagepage, "UTF-8"));

%>