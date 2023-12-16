package es.uco.pw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SVDesconectar
 */
@WebServlet("/DesconectarServlet")
public class SVDesconectar extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1374157113522829569L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidar la sesión actual
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirigir a index.jsp
        response.sendRedirect("index.jsp");
    }
}
