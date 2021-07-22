package pe.sistventaventas.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.sistventaventas.dto.UsuarioDto;
import pe.sistventaventas.service.LogonService;

/**
 *
 * @author Gustavo Coronel
 */
@WebServlet(name = "LogonController", urlPatterns = {"/LogonControllerIngresar", "/LogonControllerSalir"})
public class LogonController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = request.getServletPath();
		switch (url) {
			case "/LogonControllerIngresar": // Iniciar sesión
				logonControllerIngresar(request, response);
				break;
			case "/LogonControllerSalir": // Envia en formato JSON los repartidores para el combo
				logonControllerSalir(request, response);
				break;
		}
	}

	protected void logonControllerIngresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Datos
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		// Proceso
		LogonService service = new LogonService();
		UsuarioDto dto = service.validar(usuario, clave);
		String destino;
		if (service.getCode() == 1) {
			destino = "main.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("usuario", dto);
		} else {
			destino = "index.jsp";
			request.setAttribute("mensaje", service.getMessage());
		}
		// Reporte
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	private void logonControllerSalir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Proceso
		HttpSession session = request.getSession();
		session.invalidate();
		// Pagina de inicio
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
