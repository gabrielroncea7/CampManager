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
 * Servlet implementation class SVAsociarMonitor
 */
@WebServlet(name = "asociarMonitor", urlPatterns = "/asociarMonitor")
public class SVAsociarMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVAsociarMonitor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
		String msg;
		RequestDispatcher rd;
		if (userBean != null && userBean.getEmail() != null) {

			ResultSet Actividades = GestorCampamentos.listarActividades();
			ResultSet Campamentos = GestorCampamentos.listarCampamentos();
			ResultSet Monitores = GestorCampamentos.listarMonitores();
			
			if (Actividades != null) {

				if (Campamentos != null) {
					if(Monitores!=null) 
					{
						request.setAttribute("verCampamentos", Campamentos);
						request.setAttribute("verActividades", Actividades);
						request.setAttribute("verMonitores", Monitores);
						rd = request.getRequestDispatcher("/mvc/view/asociarMonitorView.jsp");
						rd.forward(request, response);
					}
					else
					{
						msg = "No existen Monitores disponibles";
						request.setAttribute("msg", msg);
						rd = request.getRequestDispatcher("/mvc/view/adminView.jsp");
						rd.forward(request, response);
					}

				} else {
					msg = "No existen Campamentos disponibles";
					request.setAttribute("msg", msg);
					rd = request.getRequestDispatcher("/mvc/view/adminView.jsp");
					rd.forward(request, response);
				}
			} else {
				msg = "No existen actividades disponibles";
				request.setAttribute("msg", msg);
				rd = request.getRequestDispatcher("/mvc/view/adminView.jsp");
				rd.forward(request, response);
			}
		} else {
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
