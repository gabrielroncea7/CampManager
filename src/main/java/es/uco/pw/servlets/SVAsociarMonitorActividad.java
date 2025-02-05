package es.uco.pw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVAsociarMonitorActividad
 */
@WebServlet(name = "asociarMonitorActividad", urlPatterns = "/asociarMonitorActividad")
public class SVAsociarMonitorActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVAsociarMonitorActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		CustomerBean userBean = (CustomerBean) session.getAttribute("userBean");
		String msg = "No se ha podido hacer la asociación";
		
		if (userBean != null && userBean.getEmail() != null) {
			if(GestorCampamentos.existeMonitor(Integer.parseInt(request.getParameter("idMonitor")))){
				if(GestorCampamentos.existeActividad(request.getParameter("nombreActividad"))){
						if(GestorCampamentos.comprobarMonitoresMax(request.getParameter("nombreActividad"))) {
							if(!GestorCampamentos.existeActividadMonitor(request.getParameter("nombreActividad"), Integer.parseInt(request.getParameter("idMonitor")))) {
								GestorCampamentos.asociarMonitorAActividad(Integer.parseInt(request.getParameter("idMonitor")), request.getParameter("nombreActividad"));
								msg= "Asociación Realizada";
						}else {
							msg = "El monitor ya está asocuado a la actividad";
						}
					}else {
						msg = "La actividad tiene el nº maximo de monitores";
					}
				}else {
					msg="No existe esa actividad";
				}
			}else{
				msg = "No existe ese monitor";
			}
			session.setAttribute("msg", msg);
			response.sendRedirect(request.getContextPath() + "/asociarMonitor");
			
		}else {
			response.sendRedirect(request.getContextPath());
		}

		
		
	}

}
