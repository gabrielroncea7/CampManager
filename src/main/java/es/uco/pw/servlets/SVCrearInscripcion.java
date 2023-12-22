package es.uco.pw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorUsuarios;
import es.uco.pw.business.Gestores.GestorInscripciones;
import es.uco.pw.data.display.CustomerBean;


/**
 * Servlet implementation class SVMostarCampamentosDisponibles
 */
@WebServlet(name="crearInscripcion", urlPatterns="/crearInscripcion")
public class SVCrearInscripcion extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1158701249726439838L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SVCrearInscripcion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
        
        if (userBean != null && userBean.getEmail() != null) {
            
            String idCampamentoStr = request.getParameter("idCampamento");
            String inscripcionCompletaStr = request.getParameter("inscripcionCompleta");
            boolean inscripcionCompleta = Boolean.parseBoolean(inscripcionCompletaStr);

            int idCampamento = Integer.parseInt(idCampamentoStr);
            int idAsistente = GestorUsuarios.obtenerAsistenteUsuario(userBean.getEmail());
            double precio = GestorInscripciones.calcularPrecioInscripcion(idCampamento, inscripcionCompleta);
            
			request.setAttribute("idCampamento", idCampamento);
			request.setAttribute("idAsistente", idAsistente);
			request.setAttribute("precio", precio);

            if(GestorInscripciones.ComprobarInscripcion(idAsistente, idCampamento)){
            	response.sendRedirect("mvc/view/asistenteView.jsp");             	
            }else {
    			RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/confirmacionInscripcionView.jsp");
    			rd.forward(request, response);           	
            }
	 	       	
        }
		else {
			response.sendRedirect(request.getContextPath());
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
