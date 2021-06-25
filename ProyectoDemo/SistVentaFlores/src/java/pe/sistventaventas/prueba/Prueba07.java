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
public class Prueba07 {
	
	public static void main(String[] args) {
		// Datos
		ClienteDto dto = new ClienteDto();
		dto.setIdcliente(6);
		dto.setApellido("TORRES");
		dto.setNombre("ALEJANDRA");
		dto.setDireccion("Mi Casa");
		dto.setIddistrito(3);
		dto.setDni("65782354");
		dto.setCorreo("algo@gmail.com");
		dto.setTelefono("534768934");
		// Proceso
		try {
			
			ClienteService service = new ClienteService();
			Integer codigo = service.actualizar(dto);
			System.out.println("Codigo: " + codigo);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
