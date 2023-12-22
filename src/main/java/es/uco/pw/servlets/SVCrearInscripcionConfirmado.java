package es.uco.pw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.display.CustomerBean;
import es.uco.pw.business.Gestores.GestorInscripciones;

/**
 * Servlet implementation class SVCrearInscripcionConfirmado
 */
@WebServlet(name="crearInscripcionConfirmado", urlPatterns="/crearInscripcionConfirmado")
public class SVCrearInscripcionConfirmado extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -7636007803137762361L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SVCrearInscripcionConfirmado() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
        if (userBean != null && userBean.getEmail() != null) {
            String idCampamentoStr = request.getParameter("idCampamento");
            String idAsistenteStr = request.getParameter("idAsistente");
            String precioStr = request.getParameter("precio");            
            
            int idCampamento = Integer.parseInt(idCampamentoStr);
            int idAsistente = Integer.parseInt(idAsistenteStr);
            Double precio = Double.parseDouble(precioStr);

            GestorInscripciones.crearInscripcion(idAsistente, idCampamento, precio);
            
            response.sendRedirect("mvc/view/asistenteView.jsp");
        }
		else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
