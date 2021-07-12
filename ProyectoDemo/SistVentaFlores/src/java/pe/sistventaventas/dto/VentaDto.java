package pe.sistventaventas.dto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class VentaDto {

	private int idventa;
	private int idcliente;
	private String fecha;
	private int idempleado;
	private int idrepartidor;
	private int repartoDistrito;
	private String repartoDireccion;
	private double costoEnvio;
	private double baseImponible;
	private double impuesto;
	private double total;

	public VentaDto() {
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public int getRepartoDistrito() {
		return repartoDistrito;
	}

	public void setRepartoDistrito(int repartoDistrito) {
		this.repartoDistrito = repartoDistrito;
	}

	public String getRepartoDireccion() {
		return repartoDireccion;
	}

	public void setRepartoDireccion(String repartoDireccion) {
		this.repartoDireccion = repartoDireccion;
	}

	public double getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
