package pe.sistventaventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.ClienteDto;
import pe.sistventaventas.dto.UsuarioDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ClienteService extends AbstractService implements ICrud<ClienteDto> {

	private final String queryBase = "SELECT IDCLIENTE, NOMBRE, APELLIDO, DNI, "
			  + "IDDISTRITO, DIRECCION, TELEFONO, CORREO "
			  + "FROM CLIENTE ";

	@Override
	public List<ClienteDto> leerTodos() {
		List<ClienteDto> lista = new ArrayList<>();
		ClienteDto dto = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		this.setCode(1);
		this.setMessage("Proceso ok!!!");
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(queryBase);
			rs = pstm.executeQuery();
			while (rs.next()) {
				dto = new ClienteDto();
				dto.setIdcliente(rs.getInt("idcliente"));
				dto.setNombre(rs.getString("nombre"));
				dto.setApellido(rs.getString("apellido"));
				dto.setDni(rs.getString("dni"));
				dto.setIddistrito(rs.getInt("iddistrito"));
				dto.setDireccion(rs.getString("direccion"));
				dto.setTelefono(rs.getString("telefono"));
				dto.setCorreo(rs.getString("correo"));
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

	@Override
	public List<ClienteDto> leerTodos(ClienteDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ClienteDto leerPorId(int id) {
		ClienteDto dto = null;
		String query = queryBase + "WHERE IDCLIENTE = ?";
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
			dto = new ClienteDto();
			dto.setIdcliente(rs.getInt("idcliente"));
			dto.setNombre(rs.getString("nombre"));
			dto.setApellido(rs.getString("apellido"));
			dto.setDni(rs.getString("dni"));
			dto.setIddistrito(rs.getInt("iddistrito"));
			dto.setDireccion(rs.getString("direccion"));
			dto.setTelefono(rs.getString("telefono"));
			dto.setCorreo(rs.getString("correo"));
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
	public int grabar(ClienteDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int actualizar(ClienteDto bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int eliminar(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
