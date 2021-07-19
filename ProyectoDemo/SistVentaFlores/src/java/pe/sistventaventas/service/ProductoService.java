package pe.sistventaventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.ProductoDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ProductoService extends AbstractService implements ICrud<ProductoDto> {

	private final String QUERY_BASE = "SELECT IDPRODUCTO, NOMBRE, DETALLE, IDCATEGORIA, "
			  + "PRECOSTO, PREVENTA, STOCK FROM PRODUCTO ";

	@Override
	public List<ProductoDto> leerTodos() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<ProductoDto> leerTodos(ProductoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ProductoDto leerPorId(int id) {
		ProductoDto dto = null;
		String query = QUERY_BASE + "WHERE IDPRODUCTO = ?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		this.setCode(1);
		this.setMessage("Proceso ok!!!");
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				this.setCode(-1);
				this.setMessage("ERROR: Registro no existe.");
				rs.close();
				pstm.close();
				return null;
			}
			dto = new ProductoDto();
			dto.setIdproducto(rs.getInt("idproducto"));
			dto.setNombre(rs.getString("nombre"));
			dto.setDetalle(rs.getString("detalle"));
			dto.setIdcategoria(rs.getInt("idcategoria"));
			dto.setPrecosto(rs.getDouble("precosto"));
			dto.setPreventa(rs.getDouble("preventa"));
			dto.setStock(rs.getInt("stock"));
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			this.setCode(-1);
			this.setMessage(e.getMessage());
		} catch (Exception e) {
			this.setCode(-1);
			this.setMessage("Error en el proceso, intenteo de nuevo.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}

	@Override
	public int grabar(ProductoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int actualizar(ProductoDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int eliminar(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
