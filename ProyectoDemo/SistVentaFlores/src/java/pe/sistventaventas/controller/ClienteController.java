package pe.sistventaventas.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.service.ClienteService;
import pe.sistventaventas.util.Mate;

/**
 *
 * @author Gustavo Coronel
 */
@WebServlet(name = "ClienteController",
		  urlPatterns = {"/ClientesFormularioConsulta", "/ClientesEditar",
			  "/ClientesEliminar", "/ClientesFormularioGrabar"})
public class ClienteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
			case "/ClientesFormularioConsulta":
				formularioConsulta(request, response);
				break;
			case "/ClientesEditar":
				clientesEditar(request, response);
				break;
			case "/ClientesEliminar":
				clientesEliminar(request, response);
				break;
			case "/ClientesFormularioGrabar":
				clientesFormularioGrabar(request, response);
				break;
		}

	}

	private void formularioConsulta(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String btnConsultar = request.getParameter("btnConsultar");
		String btnNuevo = request.getParameter("btnNuevo");
		if (btnConsultar != null) {
			consultarClientes(request, response);
		}
		if (btnNuevo != null) {
			nuevoCliente(request, response);
		}
	}

	private void consultarClientes(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		// Datos
		String sCodigo = request.getParameter("codigo");
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
		Integer codigo = Mate.stringToInteger(sCodigo);
		// Consuta
		ClienteDto criterio = new ClienteDto();
		criterio.setIdcliente(codigo);
		criterio.setNombre(nombre);
		criterio.setApellido(apellido);
		ClienteService service = new ClienteService();
		List<ClienteDto> lista = service.leerTodos(criterio);
		System.err.println("Code: " + service.getCode());
		System.err.println("Size: " + lista.size());
		if (service.getCode() == 1) {
			request.setAttribute("lista", lista);
		} else {
			request.setAttribute("error", service.getMessage());
		}
		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	private void nuevoCliente(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

		ClienteDto dto = new ClienteDto();
		dto.setIdcliente(0);

		request.setAttribute("accion", "NUEVO");
		request.setAttribute("dto", dto);
		request.setAttribute("desactiva", "");
		UtilController.cargarCombos(request);

		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientesForm.jsp");
		rd.forward(request, response);
	}

	private void clientesEditar(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		// Datos
		Integer id = Integer.parseInt(request.getParameter("id"));
		// Consulta
		ClienteService service = new ClienteService();
		ClienteDto dto = service.leerPorId(id);

		request.setAttribute("accion", "EDITAR");
		request.setAttribute("dto", dto);
		request.setAttribute("desactiva", "");
		UtilController.cargarCombos(request);

		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientesForm.jsp");
		rd.forward(request, response);
	}

	private void clientesEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		Integer id = Integer.parseInt(request.getParameter("id"));
		// Consulta
		ClienteService service = new ClienteService();
		ClienteDto dto = service.leerPorId(id);

		request.setAttribute("accion", "ELIMINAR");
		request.setAttribute("dto", dto);
		request.setAttribute("desactiva", "disabled=\"disabled\"");
		UtilController.cargarCombos(request);

		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientesForm.jsp");
		rd.forward(request, response);
	}

	private void clientesFormularioGrabar(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		String btnGrabar = request.getParameter("btnGrabar");
		String btnCancelar = request.getParameter("btnCancelar");
		if (btnGrabar != null) {
			formularioGrabar(request, response);
		}
		if (btnCancelar != null) {
			formularioCancelar(request, response);
		}

	}

	private void formularioCancelar(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	private void formularioGrabar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
		String accion = request.getParameter("accion");
		ClienteDto dto = new ClienteDto();
		dto.setIdcliente(Integer.parseInt(request.getParameter("id")));
		if(!accion.equals("ELIMINAR")){
			dto.setNombre(request.getParameter("nombre"));
			dto.setApellido(request.getParameter("apellido"));
			dto.setDni(request.getParameter("dni"));
			dto.setTelefono(request.getParameter("telefono"));
			dto.setCorreo(request.getParameter("correo"));
			dto.setDireccion(request.getParameter("direccion"));
			dto.setIddistrito(Integer.parseInt(request.getParameter("distrito")));
		}
		// Proceso
		ClienteService service = new ClienteService();
		switch(accion){
			case "NUEVO":
				dto.setIdcliente(null);
				service.grabar(dto);
				break;
			case "EDITAR":
				service.actualizar(dto);
				break;
			case "ELIMINAR":
				service.eliminar(dto.getIdcliente());
				break;				
		}
		if(service.getCode() == 1){
			request.setAttribute("mensaje", service.getMessage());
		} else {
			request.setAttribute("error", service.getMessage());
		}
		request.setAttribute("accion", accion);
		// Enviar respuesta
		RequestDispatcher rd = request.getRequestDispatcher("clientesForm.jsp");
		rd.forward(request, response);
	}

}
