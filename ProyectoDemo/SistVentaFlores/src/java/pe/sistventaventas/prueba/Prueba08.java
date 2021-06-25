package pe.sistventaventas.prueba;

import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.service.ClienteService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba08 {
	
	public static void main(String[] args) {
		// Datos
		int codigo = 6;
		// Proceso
		try {
			ClienteService service = new ClienteService();
			codigo = service.eliminar(codigo);
			if(service.getCode() == 1){
				System.out.println("Registro eliminado de codigo: " + codigo);
			} else {
				System.err.println(service.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
