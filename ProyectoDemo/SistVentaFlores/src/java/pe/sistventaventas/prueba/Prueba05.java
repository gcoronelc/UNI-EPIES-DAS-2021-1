package pe.sistventaventas.prueba;

import java.util.List;
import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.service.ClienteService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba05 {
	
	public static void main(String[] args) {
		// Datos
		ClienteDto criterio = new ClienteDto();
		criterio.setIdcliente(null);
		criterio.setNombre("");
		//criterio.setApellido("OLI");
		try {
			
			ClienteService service = new ClienteService();
			List<ClienteDto> lista = service.leerTodos(criterio);
			/*
			System.err.println("Codigo: " + service.getCode());
			System.err.println("Mensaje: " + service.getMessage());
			*/
			for (ClienteDto dto : lista) {
				System.out.println(dto.getIdcliente() + " - " + dto.getNombre() + " - " + dto.getApellido());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
