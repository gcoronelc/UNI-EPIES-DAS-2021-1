package pe.sistventaventas.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class DetalleVentaDto {

	private int idventa;
	private int idproducto;
	private String nombre;
	private int cantidad;
	private double precio;
	private double subtotal;

	public DetalleVentaDto() {
	}

	public DetalleVentaDto(int idventa, int idproducto, String nombre, int cantidad, double precio, double subtotal) {
		this.idventa = idventa;
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
