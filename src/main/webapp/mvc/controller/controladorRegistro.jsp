<%@page import="es.uco.pw.business.Gestores.GestorUsuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page
	import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<jsp:useBean id="customerBean" scope="session"
	class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>
<%
String nextPage = "";
String mensajeNextPage = "";

String nombre = request.getParameter("name");
String apellidos = request.getParameter("lastname");
String email = request.getParameter("email");
String password = request.getParameter("password");
String necesidadesEspeciales = request.getParameter("specialNeeds");
String Admin = request.getParameter("isAdmin");

boolean boolSpecialNeeds = "True".equals(necesidadesEspeciales);
boolean boolAdminUser = "True".equals(Admin);

if (nombre == null || apellidos == null || email == null || password == null || nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || password.isEmpty()) {
    nextPage = "../view/registroView.jsp";
    mensajeNextPage ="Campos incompletos";
}

else {

UsuarioDTO usuarioDTO = new UsuarioDTO(nombre, apellidos, email, password, boolAdminUser, boolAdminUser);

if (GestorUsuarios.existeUsuario(usuarioDTO)) {
    nextPage = "../view/registroView.jsp";
    mensajeNextPage = "El email ya existe";
} else {
	GestorUsuarios.escribirUsuario(usuarioDTO);
    nextPage = "../../index.jsp";
    mensajeNextPage = "Usuario creado correctamente";
}
}
response.sendRedirect(nextPage + "?message=" + URLEncoder.encode(mensajeNextPage, "UTF-8"));
%>
