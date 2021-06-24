/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.SistVentaPasajes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.SistVentaPasajes.db.AccesoDB;
import pe.SistVentaPasajes.dto.UsuarioDto;

/**
 *
 * @author jazmi
 */
public class LogonService extends AbstractService {

    public UsuarioDto validar(String usuario, String clave) {
        UsuarioDto usuDto = null;
        String query = "select u.IDEMPLEADO, u.USUARIO, '*****' CLAVE,  "
                + "u.IDROL, r.NOMBRE, u.ACTIVO "
                + "from dbo.USUARIO u "
                + "join dbo.EMPLEADO e on u.IDEMPLEADO = e.IDEMPLEADO "
                + "join dbo.ROL r on u.IDROL = r.IDROL "
                + "where u.USUARIO = ? and u.CLAVE = ? "
                + "and u.ACTIVO = 1 and e.ACTIVO = 1 ";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection cn = null;
        this.setCode(1);
        this.setMessage("Proceso OK");
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(query);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                rs.close();
                pstm.close();
                throw new SQLException("Datos Incorrectos. ");
            }
            usuDto = new UsuarioDto();
            usuDto.setIdempleado(rs.getInt("IDEMPLEADO"));
            usuDto.setUsuario(rs.getString("USUARIO"));
            usuDto.setClave(rs.getString("CLAVE"));
            usuDto.setIdrol(rs.getInt("IDROL"));
            usuDto.setRol(rs.getString("NOMBRE"));
            usuDto.setActivo(rs.getInt("ACTIVO"));
            rs.close();
            pstm.close();

        } catch (SQLException e) {
            this.setCode(-1);
            this.setMessage(e.getMessage());
        } catch (Exception e) {
            this.setCode(-1);
            this.setMessage("Error en el proceso. ");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
            return usuDto;
        }
    }
}
