package es.uco.pw.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.business.Gestores.GestorCampamentos;
import es.uco.pw.data.display.CustomerBean;

/**
 * Servlet implementation class SVAsociarMonitorESCampamento
 */
@WebServlet(name = "asociarMonitorESCampamento", urlPatterns = "/asociarMonitorESCampamento")
public class SVAsociarMonitorESCampamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVAsociarMonitorESCampamento() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerBean userBean = (CustomerBean) session.getAttribute("userBean");
        String msg = "No se ha podido hacer la asociación";

        if (userBean != null && userBean.getEmail() != null) {
            if (GestorCampamentos.existeMonitor(Integer.parseInt(request.getParameter("idMonitor")))) {
                if (GestorCampamentos.existeCampamento(Integer.parseInt(request.getParameter("idCampamento")))) {
                    if (!GestorCampamentos.existeMonitorCampamento(Integer.parseInt(request.getParameter("idMonitor")), Integer.parseInt(request.getParameter("idCampamento")))) {
                        if (GestorCampamentos.existeMonitorEspecial(Integer.parseInt(request.getParameter("idMonitor")))) {
                            if (GestorCampamentos.asociarMonitorCampamento(Integer.parseInt(request.getParameter("idMonitor")), Integer.parseInt(request.getParameter("idCampamento")))) {
                                msg = "Monitor responsable asociado correctamente";
                            } else {
                                msg = "No se ha podido asociar el monitor";
                            }
                        } else {
                            msg = "El monitor no es educador especial";
                        }
                    } else {
                        msg = "El monitor ya está asociado al campamento";
                    }
                } else {
                    msg = "No existe el campamento";
                }
            } else {
                msg = "No existe el monitor";
            }
            session.setAttribute("msg", msg);
            response.sendRedirect(request.getContextPath() + "/asociarMonitor");
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }


}
