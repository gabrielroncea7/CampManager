<%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter"%>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<jsp:useBean id="customerBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
String nextPage = "";
String mensajeNextPage = "";
	
String email = request.getParameter("email");
String password = request.getParameter("password");

if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
    nextPage = "../../index.jsp";
    mensajeNextPage ="Campos incompletos";
}
else
{
	
    UsuarioDTO usuarioDTO = GestorUsuarios.listarUsuario(email, password);
    if (GestorUsuarios.existeUsuario(usuarioDTO)) {
    	session.setAttribute("usuarioDTO", usuarioDTO);
        nextPage = "../view/inicioView.jsp";
    }
    else
    {
        nextPage = "../../index.jsp";
        mensajeNextPage = "Usuario Incorrecto";	
    }
    
    		
}
response.sendRedirect(nextPage + "?message=" + URLEncoder.encode(mensajeNextPage, "UTF-8"));

%>