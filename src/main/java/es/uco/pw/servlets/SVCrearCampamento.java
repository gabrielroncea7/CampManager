package es.uco.pw.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.Campamento.Campamento_DTO;
import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.business.common.NivelEducativo_DTO;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVCrearCampamento
 */
@WebServlet(name="crearCampamento", urlPatterns="/crearCampamento")
public class SVCrearCampamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVCrearCampamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CustomerBean userBean = (CustomerBean) session.getAttribute("userBean");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        if (userBean != null && userBean.getEmail() != null) {
	            	Campamento_DTO campamento= new Campamento_DTO();
	            	campamento.setFechaInicio(LocalDate.parse(request.getParameter("fechaInicio"), formatter) );
	            	campamento.setFechaFin(LocalDate.parse(request.getParameter("fechaFin"), formatter) );
	            	campamento.setNivelEducativo(NivelEducativo_DTO.valueOf(request.getParameter("nivelEducativo")));
	            	campamento.setNumeroMaximoAsistentes(Integer.parseInt(request.getParameter("numMaxAsistentes")));
	           	
	            	GestorCampamentos.escribirCampamento(campamento);
	            	
	            	String msg = "Campamento creado correctamente";
	    			request.setAttribute("msg", msg);
	    			RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/addView.jsp");
	    			rd.forward(request, response);
	    		
	        	
	        } else {
				response.sendRedirect(request.getContextPath());
	        }
	}

}
