package pe.sistventaventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.dto.ComboDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ComboService extends AbstractService{

	public List<ComboDto> distritos() {
		String query;
		query = "select iddistrito codigo, nombre from distrito";
		return leerCombo(query);
	}

	public List<ComboDto> categorias() {
		String sql;
		sql = "select idcategoria codigo, descripcion nombre from distrito";
		return leerCombo(sql);
	}

	private List<ComboDto> leerCombo(String query) {
		List<ComboDto> lista = new ArrayList<>();
		ComboDto dto = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		this.setCode(1);
		this.setMessage("Proceso ok!!!");
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			rs = pstm.executeQuery();
			while (rs.next()) {
				dto = new ComboDto();
				dto.setCodigo(rs.getInt("codigo"));
				dto.setNombre(rs.getString("nombre"));
				lista.add(dto);
			}
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
		return lista;
	}

}
