package pe.sistventaventas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VentaController", 
		  urlPatterns = {"/ProcVentaPage", "/alca"})
public class VentaController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
			case "/ProcVentaPage": // Carga la pagina principal
				procVentaPage(request, response);
				break;
		}
	}

	private void procVentaPage(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		
		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("ventas.jsp");
		rd.forward(request, response);
	}

}
