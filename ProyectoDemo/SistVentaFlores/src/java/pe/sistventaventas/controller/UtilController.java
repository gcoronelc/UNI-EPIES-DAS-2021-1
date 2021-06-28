package pe.sistventaventas.controller;

import javax.servlet.http.HttpServletRequest;
import pe.sistventaventas.service.ComboService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class UtilController {

	private UtilController() {
	}
	
	public static void cargarCombos(HttpServletRequest request){
		ComboService service = new ComboService();
		request.setAttribute("comboDistritos", service.distritos());
		//request.setAttribute("comboCategorias", service.categorias());
	}

}
