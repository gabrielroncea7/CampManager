<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="include/errorPage.jsp"%>
<%@ page import="java.net.URLEncoder" %>
<jsp:useBean  id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>

<%
request.getSession().removeAttribute("userBean");
response.sendRedirect(request.getContextPath() + "/index.jsp?message=" + URLEncoder.encode("Te has desconectado", "UTF-8"));
%>

