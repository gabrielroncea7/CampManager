<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp" %>
<%@ page import="es.uco.pw.data.dao.Usuario.UsuarioDAO" %>


<%
boolean boolSpecialNeeds;
boolean boolAdminUser;

String nextPage = "";
String mensajeNextPage = "";

String nameUser = request.getParameter("name");
String lastnameUser = request.getParameter("lastname");
String emailUser = request.getParameter("email");
String passwordUser = request.getParameter("password");
String specialNeedsUser = request.getParameter("specialNeeds");
String isAdminUser = request.getParameter("isAdmin");

if (specialNeedsUser == "True"){
	boolSpecialNeeds = true;
} else {
	boolSpecialNeeds = false;
}

if (isAdminUser == "True"){
	boolAdminUser = true;
} else {
	boolAdminUser = false;
}

UsuarioDAO UsuarioDAO = new UsuarioDAO();
UsuarioDAO.escribirUsuario(nameUser, lastnameUser, emailUser, passwordUser, boolSpecialNeeds, boolAdminUser);
%>

<%=nameUser %>
<%=lastnameUser %>
<%=emailUser %>
<%=passwordUser %>
<%=specialNeedsUser %>
<%=isAdminUser %>