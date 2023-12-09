<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp" %>
<%@ page import="es.uco.pw.data.dao.Usuario.UsuarioDAO,es.uco.pw.business.Usuario.*" %>
<jsp:useBean  id="customerBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
	String nextPage= "controladorContenido.jsp";
	String nextPageMessage = "";
	
	if(customerBean == null || customerBean.getEmail().equals(""))
	{
		String emailUser = request.getParameter("email");
		String passUser = request.getParameter("pass");
		
	}
	
	


%>