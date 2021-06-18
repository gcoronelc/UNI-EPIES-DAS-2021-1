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
public class Prueba03 {
	
	public static void main(String[] args) {
		
		try {
			ClienteService service = new ClienteService();
			List<ClienteDto> lista = service.leerTodos();
			for (ClienteDto dto : lista) {
				System.out.println(dto.getNombre() + " - " + dto.getApellido());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
