package es.uco.pw.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.data.display.CustomerBean;
import es.uco.pw.business.Actividad.Actividad_DTO;


/**
 * Servlet implementation class SVMostarCampamentosDisponibles
 */
@WebServlet(name="mostrarCampamentosDisponibles", urlPatterns="/mostrarCampamentosDisponibles")
public class SVMostrarCampamentosDisponibles extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1158701249726439838L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SVMostrarCampamentosDisponibles() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
		
		if(userBean != null)
		{
			if(userBean.getEmail()!=null)
			{
				
				String fecha1String = request.getParameter("fecha1");
				String fecha2String = request.getParameter("fecha2");
				
				Date fecha1 = Date.valueOf(fecha1String);
				Date fecha2 = Date.valueOf(fecha2String);
				
				ResultSet resultSet = GestorCampamentos.listarCampamentosDisponibles(fecha1, fecha2);
				request.setAttribute("verCampamentos", resultSet);
				RequestDispatcher rd = request.getRequestDispatcher("./mvc/view/campamentosDisponiblesView.jsp");
				rd.forward(request, response);
						
			}
				
			else {
				response.sendRedirect(request.getContextPath());
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
