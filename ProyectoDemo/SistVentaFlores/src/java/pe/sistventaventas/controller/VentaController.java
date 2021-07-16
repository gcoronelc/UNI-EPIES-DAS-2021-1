package pe.sistventaventas.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.sistventaventas.dto.ComboDto;
import pe.sistventaventas.dto.DetalleVentaDto;
import pe.sistventaventas.service.ComboService;

@WebServlet(name = "VentaController",
		  urlPatterns = {"/ProcVentaPage", "/ProcVentaTraerRepartidores",
		  "/ProcVentaTraerItems"})
public class VentaController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
			case "/ProcVentaPage": // Carga la pagina principal
				procVentaPage(request, response);
				break;
			case "/ProcVentaTraerRepartidores": // Envia en formato JSON los repartidores para el combo
				procVentaTraerRepartidores(request, response);
				break;
			case "/ProcVentaTraerItems": // Envia en formato JSON los items de la venta
				procVentaTraerItems(request, response);
				break;
		}
	}

	private void procVentaPage(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

		// Verificar Lista de items a nivel de sesion
		HttpSession session = request.getSession();
		if (session.getAttribute("listaItems") == null) {
			List<DetalleVentaDto> listaItems = new ArrayList<>();
			listaItems.add(new DetalleVentaDto(0, 2, "aaaaa", 3, 100, 300));
			listaItems.add(new DetalleVentaDto(0, 3, "aaaaa", 2, 150, 300));
			session.setAttribute("listaItems", listaItems);
		}
		// Enviar combos
		UtilController.cargarCombos(request);
		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("ventas.jsp");
		rd.forward(request, response);
	}

	private void procVentaTraerRepartidores(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Parametro
		int distrito = Integer.parseInt(request.getParameter("distrito"));
		// Traer Lista.
		ComboService service = new ComboService();
		List<ComboDto> lista = service.repartidores(distrito);
		// El JSON
		Gson gson = new Gson();
		String cadena = gson.toJson(lista);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	}

	private void procVentaTraerItems(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Obtener lista de items
		HttpSession session = request.getSession();
		List<DetalleVentaDto> listaItems = (List<DetalleVentaDto>) session.getAttribute("listaItems");
		// El JSON
		Gson gson = new Gson();
		String cadena = gson.toJson(listaItems);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	
	}

}
