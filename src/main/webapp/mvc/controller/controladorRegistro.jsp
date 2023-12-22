<%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter"%>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<%@ page import="es.uco.pw.business.Gestores.GestorAsistentes,es.uco.pw.business.Asistente.Asistente_DTO"%>
<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
/**
 * Página de controlador para la creación de usuarios.
 */
String nextPage = "";
String mensajeNextPage = "";

String nombre = request.getParameter("name");
String apellidos = request.getParameter("lastname");
String email = request.getParameter("email");
String password = request.getParameter("password");
String necesidadesEspeciales = request.getParameter("specialNeeds");
String Admin = request.getParameter("isAdmin");
String fechaNacimientoStr = request.getParameter("birthdate");

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

boolean boolSpecialNeeds = "True".equals(necesidadesEspeciales);
boolean boolAdminUser = "True".equals(Admin);

if (nombre == null || apellidos == null || email == null || password == null || nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || password.isEmpty()) {
    nextPage = "../view/registroView.jsp";
    mensajeNextPage ="Campos incompletos";
} else {
    UsuarioDTO usuarioDTO = new UsuarioDTO(nombre, apellidos, email, password, fechaNacimiento,boolSpecialNeeds, boolAdminUser);
    Asistente_DTO asistenteDTO = new Asistente_DTO(1, nombre, apellidos, fechaNacimiento, boolSpecialNeeds);    
    
    if (GestorUsuarios.existeUsuario(usuarioDTO)) {
        nextPage = "../view/registroView.jsp";
        mensajeNextPage = "El email ya existe";
    } else {
    	
    	//CREACION DE ASISTENTE CON LOS DATOS DE USUARIO
    	//Y CREACION DE RELACION USUARIO-ASISTENTE
    	if(!boolAdminUser){
    		GestorAsistentes.escribirAsistente(asistenteDTO);
    		int idAsistente = GestorUsuarios.obtenerIdAsistenteUsuario(asistenteDTO);
    		GestorUsuarios.asociarAsistenteUsuario(email, idAsistente);
    	}
    	
        GestorUsuarios.escribirUsuario(usuarioDTO);
        nextPage = "../../index.jsp";
        mensajeNextPage = "Usuario creado correctamente";
    }
}

response.sendRedirect(nextPage + "?message=" + URLEncoder.encode(mensajeNextPage, "UTF-8"));
%>
