package pe.sistventaventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.DetalleVentaDto;
import pe.sistventaventas.dto.VentaDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class VentaService extends AbstractService {

	public int registrarVenta(VentaDto ventaDto, List<DetalleVentaDto> items) {
		int idventa = 0;
		String query = "";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		int filas = 0;
		this.setCode(1);
		this.setMessage("Proceso ok!!!");
		try {
			// Iniciar la Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Actualizar contador
			query = "UPDATE CONTADOR SET ULTIMO = ULTIMO + 1 WHERE IDCONTADOR=5";
			pstm = cn.prepareStatement(query);
			filas = pstm.executeUpdate();
			if (filas != 1) {
				throw new SQLException("Error en el proceso, intentelo de nuevo.");
			}
			pstm.close();
			// Leer el contador
			query = "SELECT ULTIMO FROM CONTADOR WHERE IDCONTADOR=5";
			pstm = cn.prepareStatement(query);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new SQLException("Error en el proceso, intentelo de nuevo.");
			}
			idventa = rs.getInt("ultimo");
			rs.close();
			pstm.close();
			// Grabar venta
			query = "INSERT INTO VENTA(IDVENTA,IDCLIENTE,FECHA,IDEMPLEADO,IDREPARTIDOR,"
					  + "REPARTODISTRITO,REPARTODIRECCION,COSTOENVIO,BASEIMPONIBLE,"
					  + "IMPUESTO,TOTAL) VALUES(?,?,GETDATE(),?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, idventa);
			pstm.setInt(2, ventaDto.getIdcliente());
			pstm.setInt(3, ventaDto.getIdempleado());
			pstm.setInt(4, ventaDto.getIdrepartidor());
			pstm.setInt(5, ventaDto.getRepartoDistrito());
			pstm.setString(6, ventaDto.getRepartoDireccion());
			pstm.setDouble(7, ventaDto.getCostoEnvio());
			pstm.setDouble(8, ventaDto.getBaseImponible());
			pstm.setDouble(9, ventaDto.getImpuesto());
			pstm.setDouble(10, ventaDto.getTotal());
			pstm.executeUpdate();
			pstm.close();
			// Grabar items
			query = "INSERT INTO DETALLEVENTA(IDVENTA,IDPRODUCTO,CANTIDAD,"
					  + "PRECIO,SUBTOTAL) VALUES(?,?,?,?,?)";
			pstm = cn.prepareStatement(query);
			for(DetalleVentaDto item: items){
				pstm.setInt(1, idventa);
				pstm.setInt(2, item.getIdproducto());
				pstm.setInt(3, item.getCantidad());
				pstm.setDouble(4, item.getPrecio());
				pstm.setDouble(5, item.getSubtotal());
				pstm.executeUpdate();
			}
			pstm.close();
			// Finalizar proceso
			ventaDto.setIdventa(idventa);
			cn.commit(); // Confirma la transacción
			this.setMessage("Proceso ok. Código de nuevo cliente es " + idventa + ".");
		} catch (SQLException e) {
			this.setCode(-1);
			this.setMessage(e.getMessage());
			try {
				cn.rollback(); // Cancela la Tx
			} catch (Exception e1) {
			}
		} catch (Exception e) {
			this.setCode(-1);
			this.setMessage("Error en el proceso, intenteo de nuevo.");
			try {
				cn.rollback(); // Cancela la Tx
			} catch (Exception e1) {
			}
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return idventa;
	}

}
