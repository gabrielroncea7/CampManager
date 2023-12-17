package es.uco.pw.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SVModificar
 */
@WebServlet("/SVModificar")
public class SVModificar extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6746332901443633145L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica de modificación de datos si es necesario

        // Redirigir a la vista ModificarDatosView.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc/view/ModificarDatosView.jsp");
        dispatcher.forward(request, response);
    }
}

