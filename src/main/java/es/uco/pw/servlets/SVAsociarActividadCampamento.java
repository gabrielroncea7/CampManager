package es.uco.pw.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.business.Gestores.GestorInscripciones;

import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVAsociarActividadCampamento
 */
@WebServlet(name="asociarActividadCampamento", urlPatterns="/asociarActividadCampamento")
public class SVAsociarActividadCampamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVAsociarActividadCampamento() {
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
        	
        	if(Actividades == null) {
        		msg = "No existen actividades disponibles";
    			rd = request.getRequestDispatcher("/mvc/view/adminView.jsp");
    			rd.forward(request, response);
    			
        	}
        	if(Campamentos == null)
        	{
        		msg = "No existen Campamentos disponibles";
    			rd = request.getRequestDispatcher("/mvc/view/adminView.jsp");
    			rd.forward(request, response);	 
        	}
        	else
        	{
            	request.setAttribute("verCampamentos", Campamentos);
            	request.setAttribute("verActividades", Actividades);
    			rd = request.getRequestDispatcher("/mvc/view/asociarActividadesCampamentosView.jsp");
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
	//request.getParameter("nombreActividad"),
	//Integer.parseInt(request.getParameter("idCampamento"))
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        CustomerBean userBean = (CustomerBean) session.getAttribute("userBean");
        String msg = "No se ha podido hacer la asociación";
        RequestDispatcher rd;
        if (userBean != null && userBean.getEmail() != null) {
        	if(GestorCampamentos.existeActividad(request.getParameter("nombreActividad")))
        			{
        	if(GestorCampamentos.mismoNivelEducativo(request.getParameter("nombreActividad"), Integer.parseInt(request.getParameter("idCampamento"))))
    			{
        		if(!GestorCampamentos.existeActividadCampamento(request.getParameter("nombreActividad"), Integer.parseInt(request.getParameter("idCampamento"))))
	        	{
        			if(GestorCampamentos.asociarActividadCampamento(request.getParameter("nombreActividad"), Integer.parseInt(request.getParameter("idCampamento"))))
            		{
            			msg="Actividad Asociada con éxito";	
            		}
	        	}
        		else
        		{
        			msg = "La actividad ya está asociada al campamento";
        		}
    			}
        	else
        	{
        		msg = "El campamento y la actividad no tienen el mismo nivel educativo";
        	}
              }
      	else
   			{
  				msg = "no existe la actividad";
    			} 
        	session.setAttribute("msg", msg);
        	response.sendRedirect(request.getContextPath() + "/asociarActividadCampamento");
        }
		else 
		{
			response.sendRedirect(request.getContextPath());
		}
	
	}

}
