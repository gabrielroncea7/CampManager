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
 * Servlet implementation class SVMostrarCampamentoCriterios
 */
@WebServlet("/SVMostrarCampamentoCriterios")
public class SVMostrarCampamentoCriterios extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -6014957908994715686L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SVMostrarCampamentoCriterios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");
        if (userBean != null && userBean.getEmail() != null) {
        	
			String nivelEducativo = request.getParameter("nivelEducativo");
			
			ResultSet resultSet = GestorCampamentos.listarCampamentosCriterios(nivelEducativo);
			
			request.setAttribute("verCampamentosCriterio", resultSet);
			request.setAttribute("nivelEducativo", nivelEducativo);
			RequestDispatcher rd = request.getRequestDispatcher("/mvc/view/asistenteView.jsp");
			rd.forward(request, response);	 	
        	
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
