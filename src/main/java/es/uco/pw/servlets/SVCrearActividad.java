package es.uco.pw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.business.common.HorarioActividad_DTO;
import es.uco.pw.business.common.NivelEducativo_DTO;
import es.uco.pw.data.display.CustomerBean;
import es.uco.pw.business.Actividad.Actividad_DTO;

/**
 * Servlet implementation class SVCrearActividad
 */
@WebServlet(name="crearActividad", urlPatterns="/crearActividad")
public class SVCrearActividad extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Otros métodos y atributos...

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
        String msg = "La actividad no se ha podido crear, comprueba las credenciales";
       
        if (userBean != null && userBean.getEmail() != null) {
        	Actividad_DTO actividad = new Actividad_DTO();
        	actividad.setNombreActividad(request.getParameter("nombreActividad"));
        	actividad.setnEducativo(NivelEducativo_DTO .valueOf( request.getParameter("nivelEducativo")));
        	actividad.sethActividad(HorarioActividad_DTO.valueOf(request.getParameter("horario")));
        	actividad.setNumeroParticipantes(Integer.parseInt(request.getParameter("numParticipantes")));
        	actividad.setMonitoresNecesarios(Integer.parseInt(request.getParameter("numMonitores")));
       	
        	GestorCampamentos.escribirActividad(actividad);
            if(GestorCampamentos.escribirActividad(actividad))
            {          	
            	 msg = "Actividad creada correctamente";
            }

            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher("./mvc/view/addView.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
