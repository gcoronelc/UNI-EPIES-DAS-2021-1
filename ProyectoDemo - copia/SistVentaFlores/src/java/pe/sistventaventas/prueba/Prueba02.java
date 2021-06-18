package pe.sistventaventas.prueba;

import java.sql.Connection;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.UsuarioDto;
import pe.sistventaventas.service.LogonService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba02 {
	
	public static void main(String[] args) {
		
		// Datos
		String usuario = "jarias";
		String clave = "ganador";
		// Proceso
		LogonService service = new LogonService();
		UsuarioDto dto = service.validar(usuario, clave);
		// Reporte
		if( service.getCode() == 1 ){
			System.out.println("Hola " + dto.getUsuario() );
		} else {
			System.err.println("Error: " + service.getMessage());
		}
		
	}

}
