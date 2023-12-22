package es.uco.pw.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorInscripciones;
import es.uco.pw.business.Gestores.GestorUsuarios;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class mostrarInscripciones
 */
@WebServlet(name="mostrarInscripciones", urlPatterns="/mostrarInscripciones")
public class SVMostrarInscripciones extends HttpServlet {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SVMostrarInscripciones() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
        if (userBean != null && userBean.getEmail() != null) {

        	int idAsistente = GestorUsuarios.obtenerAsistenteUsuario(userBean.getEmail());
			ResultSet resultSet = GestorInscripciones.listarInscripcionesAsistente(idAsistente);
			
			request.setAttribute("verInscripciones", resultSet);

			
			RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/asistenteView.jsp");         
			rd.forward(request, response);
        }
		else {
			response.sendRedirect(request.getContextPath());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
