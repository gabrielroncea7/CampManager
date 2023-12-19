package es.uco.pw.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.data.display.CustomerBean;


/**
 * Servlet implementation class SVMostarActividad
 */
@WebServlet(name="mostrarActividad", urlPatterns="/mostrarActividad")
public class SVMostarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVMostarActividad() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerBean userBean = (CustomerBean) request.getSession().getAttribute("userBean");

        if (userBean != null && userBean.getEmail() != null) {
            try {
                ResultSet resultSet = GestorCampamentos.listarActividades();
                // Almacena el ResultSet en el ámbito de la sesión
                request.getSession().setAttribute("verActividades", resultSet);
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Error al obtener actividades");
            }
        } else {
            response.getWriter().println("Usuario no válido");
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
