package pe.sistventaventas.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ProductoDto {

	private int idproducto;
	private String nombre;
	private String detalle;
	private int idcategoria;
	private double precosto;
	private double preventa;
	private int stock;

	public ProductoDto() {
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public double getPrecosto() {
		return precosto;
	}

	public void setPrecosto(double precosto) {
		this.precosto = precosto;
	}

	public double getPreventa() {
		return preventa;
	}

	public void setPreventa(double preventa) {
		this.preventa = preventa;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
