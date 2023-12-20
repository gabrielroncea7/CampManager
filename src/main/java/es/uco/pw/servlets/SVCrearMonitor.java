package es.uco.pw.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.Campamento.Campamento_DTO;
import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.business.Monitor.Monitor_DTO;
import es.uco.pw.business.common.NivelEducativo_DTO;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVCrearMonitor
 */
@WebServlet(name="crearMonitor", urlPatterns="/crearMonitor")
public class SVCrearMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVCrearMonitor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CustomerBean userBean = (CustomerBean) session.getAttribute("userBean");
		String msg = "No se ha podido crear el usuario, comprueba las credenciales";
	        if (userBean != null && userBean.getEmail() != null) {
	        		Monitor_DTO monitor = new Monitor_DTO();
	        		
	        		boolean boolEducadorEspecial = "True".equals(request.getParameter("educadorEspecial"));
	        		
	        		monitor.setNombre(request.getParameter("nombreMonitor"));
	        		monitor.setApellidos(request.getParameter("apellidosMonitor"));
	        		monitor.setEducadorespecial(boolEducadorEspecial);
	        		
	        		if(GestorCampamentos.escribirMonitor(monitor)) {
	        			
	        			msg = "Usuario creado correctamente";
	        		}
	        		
	    			request.setAttribute("msg", msg);
	    			RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/addView.jsp");
	    			rd.forward(request, response);
	    		
	        	
	        } else {
				response.sendRedirect(request.getContextPath());
	        }
	}

}
