package es.uco.pw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorInscripciones;
import es.uco.pw.business.Gestores.GestorUsuarios;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVCancelarInscripcion
 */
@WebServlet("/SVCancelarInscripcion")
public class SVCancelarInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVCancelarInscripcion() {
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
            
            String idCampamentoStr = request.getParameter("idCampamento");

            int idCampamento = Integer.parseInt(idCampamentoStr);
            int idAsistente = GestorUsuarios.obtenerAsistenteUsuario(userBean.getEmail());
            
			request.setAttribute("idCampamento", idCampamento);
			request.setAttribute("idAsistente", idAsistente);

            if(GestorInscripciones.ComprobarInscripcion(idAsistente, idCampamento)){
            	GestorInscripciones.eliminarInscripcion(idAsistente, idCampamento);
            	response.sendRedirect(request.getContextPath() + "/mostrarInscripciones");             	
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
