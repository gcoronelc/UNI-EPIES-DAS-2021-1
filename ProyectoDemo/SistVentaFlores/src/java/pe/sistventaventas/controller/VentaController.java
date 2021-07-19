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
import pe.sistventaventas.dto.ProductoDto;
import pe.sistventaventas.dto.RespuestaDto;
import pe.sistventaventas.dto.UsuarioDto;
import pe.sistventaventas.dto.VentaDto;
import pe.sistventaventas.service.ComboService;
import pe.sistventaventas.service.ProductoService;
import pe.sistventaventas.service.VentaService;

@WebServlet(name = "VentaController",
		  urlPatterns = {"/ProcVentaPage", "/ProcVentaTraerRepartidores",
			  "/ProcVentaTraerItems", "/ProcVentaTraerProductos",
			  "/ProcVentaAgregarItem", "/ProcVentaEliminarItem",
			  "/ProcVentaGrabarVenta"})
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
			case "/ProcVentaTraerProductos": // Envia en formato JSON los producto según criterio de busqueda
				procVentaTraerProductos(request, response);
				break;
			case "/ProcVentaAgregarItem": // Agrega un item a la lista de items
				procVentaAgregarItem(request, response);
				break;
			case "/ProcVentaEliminarItem": // Elimina un item a la lista de items
				procVentaEliminarItem(request, response);
				break;
			case "/ProcVentaGrabarVenta": // Registra la venta en la BD
				procVentaGrabarVenta(request, response);
				break;
		}
	}

	private void procVentaPage(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

		// Verificar Lista de items a nivel de sesion
		HttpSession session = request.getSession();
		if (session.getAttribute("listaItems") == null) {
			List<DetalleVentaDto> listaItems = new ArrayList<>();
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

	private void procVentaTraerProductos(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Parámetros
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String nombre = request.getParameter("nombre");
		// Obtener lista de items
		VentaService service = new VentaService();
		List<ProductoDto> lista = service.traerProductos(categoria, nombre);
		// El JSON
		Gson gson = new Gson();
		String cadena = gson.toJson(lista);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	}

	private void procVentaAgregarItem(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Parámetros
		int idproducto = Integer.parseInt(request.getParameter("idproducto"));
		// Datos del producto
		ProductoService service = new ProductoService();
		ProductoDto dto = service.leerPorId(idproducto);
		// Actualizar la lista
		HttpSession session = request.getSession();
		List<DetalleVentaDto> listaItems = (List<DetalleVentaDto>) session.getAttribute("listaItems");
		DetalleVentaDto item = null;
		for (DetalleVentaDto r : listaItems) {
			if (r.getIdproducto() == dto.getIdproducto()) {
				item = r;
				break;
			}
		}
		if (item == null) {
			listaItems.add(new DetalleVentaDto(dto));
		} else {
			item.setCantidad(item.getCantidad() + 1);
			item.setSubtotal(item.getCantidad() + item.getPrecio());
		}
		session.setAttribute("listaItems", listaItems);
		// El JSON
		Gson gson = new Gson();
		String cadena = gson.toJson(listaItems);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	}

	private void procVentaEliminarItem(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Parámetros
		int idproducto = Integer.parseInt(request.getParameter("idproducto"));
		// Actualizar la lista
		HttpSession session = request.getSession();
		List<DetalleVentaDto> listaItems = (List<DetalleVentaDto>) session.getAttribute("listaItems");
		DetalleVentaDto item = null;
		for (DetalleVentaDto r : listaItems) {
			if (r.getIdproducto() == idproducto) {
				listaItems.remove(r);
				break;
			}
		}
		session.setAttribute("listaItems", listaItems);
		// El JSON
		Gson gson = new Gson();
		String cadena = gson.toJson(listaItems);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	}

	private void procVentaGrabarVenta(HttpServletRequest request, HttpServletResponse response)
			  throws IOException {
		// Recoger datos de la cabecera
		VentaDto ventaDto = new VentaDto();
		ventaDto.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
		ventaDto.setRepartoDistrito(Integer.parseInt(request.getParameter("repartoDistrito")));
		ventaDto.setRepartoDireccion(request.getParameter("repartoDireccion"));
		ventaDto.setIdrepartidor(Integer.parseInt(request.getParameter("idrepartidor")));
		ventaDto.setCostoEnvio(Double.parseDouble(request.getParameter("costoEnvio")));
		ventaDto.setBaseImponible(Double.parseDouble(request.getParameter("baseImponible")));
		ventaDto.setImpuesto(Double.parseDouble(request.getParameter("impuesto")));
		ventaDto.setTotal(Double.parseDouble(request.getParameter("total")));
		// Items
		HttpSession session = request.getSession();
		List<DetalleVentaDto> listaItems = (List<DetalleVentaDto>) session.getAttribute("listaItems");
		UsuarioDto usuario = (UsuarioDto) session.getAttribute("usuario");
		if (usuario == null) {
			ventaDto.setIdempleado(0);
		} else {
			ventaDto.setIdempleado(usuario.getIdempleado());
		}
		// Validacion
		RespuestaDto rpta = new RespuestaDto(1, "Proceso ok.", "");
		if (validarVenta(ventaDto, listaItems)) {
			VentaService service = new VentaService();
			int idVenta = service.registrarVenta(ventaDto, listaItems);
			if (service.getCode() == 1) {
				rpta.setMessage("Venta ok, id=" + idVenta + ".");
				listaItems = new ArrayList<>();
				session.setAttribute("listaItems", listaItems);
			} else {
				rpta.setCode(-1);
				rpta.setMessage(service.getMessage());
			}
		} else {
			rpta.setCode(-1);
			rpta.setMessage("Existe inconsistencia o faltan datos.");
		}
		// Enviar Respuesta
		Gson gson = new Gson();
		String cadena = gson.toJson(rpta);
		// Respuesta
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(cadena);
		out.flush();
	}

	private boolean validarVenta(VentaDto venta, List<DetalleVentaDto> listaItems) {
		boolean estado = true;
		estado = (listaItems.size() == 0) ? false : estado;
		estado = (venta.getIdcliente() == 0) ? false : estado;
		estado = (venta.getRepartoDistrito() == 0) ? false : estado;
		estado = (venta.getIdrepartidor() == 0) ? false : estado;
		estado = (venta.getIdempleado() == 0) ? false : estado;
		estado = (venta.getRepartoDireccion().length() == 0) ? false : estado;
		return estado;
	}

}
