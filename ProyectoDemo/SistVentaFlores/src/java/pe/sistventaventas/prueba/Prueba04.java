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
public class Prueba04 {
	
	public static void main(String[] args) {
		
		try {
			ClienteService service = new ClienteService();
			ClienteDto dto = service.leerPorId(2);
			if(service.getCode() == 1){
				System.out.println("Hola: " + dto.getNombre());
			} else {
				System.err.println(service.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
