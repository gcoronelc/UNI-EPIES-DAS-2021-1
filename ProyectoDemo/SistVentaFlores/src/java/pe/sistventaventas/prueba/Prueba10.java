package pe.sistventaventas.prueba;

import java.util.List;
import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.dto.ProductoDto;
import pe.sistventaventas.service.ClienteService;
import pe.sistventaventas.service.VentaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba10 {
	
	public static void main(String[] args) {
		// Datos
		int categoria = 1;
		String nombre = "rosa";
		try {
			VentaService service = new VentaService();
			List<ProductoDto> lista = service.traerProductos(categoria, nombre);
			for (ProductoDto dto : lista) {
				System.out.println(dto.getNombre()+ " - " + dto.getStock()+ " - " + dto.getPreventa());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
