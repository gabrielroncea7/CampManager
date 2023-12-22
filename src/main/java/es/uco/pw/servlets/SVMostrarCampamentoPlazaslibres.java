package es.uco.pw.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVMostrarCampamentoPlazaslibres
 */
@WebServlet(name="SVMostrarCampamentoPlazaslibres", urlPatterns = "/SVMostrarCampamentoPlazaslibres")
public class SVMostrarCampamentoPlazaslibres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVMostrarCampamentoPlazaslibres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
	 	   if (userBean != null && userBean.getEmail() != null) {
			   
			   int plazaslibres = Integer.parseInt(request.getParameter("plazaslibres"));
				
				ResultSet resultSet = GestorCampamentos.listarCampamentosPlazasLibres(plazaslibres);
				
				request.setAttribute("verCampamentosCriterio", resultSet);
				request.setAttribute("plazaslibres", plazaslibres);
				RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/asistenteView.jsp");
				rd.forward(request, response); 
			   
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
