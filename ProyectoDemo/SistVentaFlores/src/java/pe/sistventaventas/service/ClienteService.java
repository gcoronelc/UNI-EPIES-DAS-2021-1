package pe.sistventaventas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.sistventaventas.db.AccesoDB;
import pe.sistventaventas.dto.ClienteDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ClienteService extends AbstractService implements ICrud<ClienteDto> {

	private final String QUERY_BASE = "SELECT IDCLIENTE, NOMBRE, APELLIDO, DNI, "
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
			pstm = cn.prepareStatement(QUERY_BASE);
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
		// Variables
		List<ClienteDto> lista = new ArrayList<>();
		ClienteDto dto = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection cn = null;
		// Uniformizando datos
		Integer codigo = bean.getIdcliente();
		String nombre = bean.getNombre();
		String apellido = bean.getApellido();
		codigo = (codigo==null)?0:codigo;
		nombre = (nombre == null)?nombre:("%" + nombre + "%");
		apellido = (apellido == null)?apellido:("%" + apellido + "%");
		// Query
		String query = QUERY_BASE + 
				  " WHERE IDCLIENTE = IIF(?=0,IDCLIENTE,?) "
				  + "AND NOMBRE LIKE ISNULL(?,NOMBRE) "
				  + "AND APELLIDO LIKE ISNULL(?,APELLIDO) ";
		// Proceso
		this.setCode(1);
		this.setMessage("Proceso ok!!!");
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			pstm.setInt(1, codigo);
			pstm.setInt(2, codigo);
			pstm.setString(3, nombre);
			pstm.setString(4, apellido);
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
			e.printStackTrace();
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
	public ClienteDto leerPorId(int id) {
		ClienteDto dto = null;
		String query = QUERY_BASE + "WHERE IDCLIENTE = ?";
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
