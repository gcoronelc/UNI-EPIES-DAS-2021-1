package pe.sistventaventas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		// Datos
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		// Proceso
		LogonService service = new LogonService();
		UsuarioDto dto = service.validar(usuario, clave);
		String destino;
		if( service.getCode() == 1 ){
			destino = "main.jsp";
			request.setAttribute("usuario", dto);
		} else {
			destino = "index.jsp";
			request.setAttribute("mensaje", service.getMessage());
		}
		// Reporte
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
