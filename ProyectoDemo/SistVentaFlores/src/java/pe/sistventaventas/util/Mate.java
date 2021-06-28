package pe.sistventaventas.util;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Mate {

	private Mate() {
	}
	
	public static Integer stringToInteger(String s){
		Integer valor;
		try {
			valor = Integer.parseInt(s);
		} catch (Exception e) {
			valor = null;
		}
		return valor;
	}

}
