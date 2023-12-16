

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SVDesconectar
 */
@WebServlet("/DesconectarServlet")
public class DesconectarServlet extends HttpServlet {
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
