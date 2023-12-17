<%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter"%>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="es.uco.pw.business.Gestores.GestorUsuarios,es.uco.pw.business.Usuario.UsuarioDTO"%>
<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
String nextPage = "";
String mensajeNextPage = "";
	
UsuarioDTO usuario = GestorUsuarios.listarUsuario(userBean.getEmail(), userBean.getPassword());

if(userBean == null || userBean.getEmail().isEmpty() || userBean.getEmail() == null)
{
	nextPage="../../index.jsp";
	mensajeNextPage = "Acceda o Regístrese";
}


response.sendRedirect(nextPage + "?message=" + URLEncoder.encode(mensajeNextPage, "UTF-8"));

%>