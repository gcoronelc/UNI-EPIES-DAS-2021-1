package pe.sistventaventas.prueba;

import java.util.ArrayList;
import java.util.List;
import pe.sistventaventas.dto.DetalleVentaDto;
import pe.sistventaventas.dto.VentaDto;
import pe.sistventaventas.service.VentaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba09 {
	
	public static void main(String[] args) {
		// Datos
		VentaDto ventaDto = new VentaDto();
		ventaDto.setIdcliente(3);
		ventaDto.setIdempleado(2);
		ventaDto.setIdrepartidor(3);
		ventaDto.setRepartoDistrito(5);
		ventaDto.setRepartoDireccion("En mi casa de Comas.");
		ventaDto.setCostoEnvio(50.0);
		ventaDto.setBaseImponible(500.0);
		ventaDto.setImpuesto(100.0);
		ventaDto.setTotal(600.0);
		List<DetalleVentaDto> items = new ArrayList<>();
		items.add(new DetalleVentaDto(0, 2, "aaaaa", 3, 100, 300));
		items.add(new DetalleVentaDto(0, 3, "aaaaa", 2, 150, 300));		
		// Proceso
		try {
			VentaService service = new VentaService();
			int codigo = service.registrarVenta(ventaDto, items);
			if(service.getCode() == 1){
				System.out.println("Proceso ok. Venta nro. : " + codigo);
			} else {
				System.err.println(service.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
