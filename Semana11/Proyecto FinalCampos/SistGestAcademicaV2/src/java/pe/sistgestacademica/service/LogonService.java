/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.sistgestacademica.db.AccesoDB;
import pe.sistgestacademica.dto.UsuarioDto;

/**
 *
 * @author USUARIO
 */
public class LogonService extends AbstractService {

    public UsuarioDto validar(String usuario, String clave) {
        UsuarioDto admDto = null;
        String query = "select u.IDEMPLEADO, u.USUARIO, '*****' CLAVE, u.IDROL, "
                + "u.ACTIVO "
                + "from dbo.EMPLEADO e "
                + "join dbo.USUARIO u "
                + "on e.IDEMPLEADO = u.IDEMPLEADO "
                + "where u.USUARIO = ? and u.CLAVE = ? "
                + "and u.ACTIVO = 1 ";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection cn = null;
        this.setCode(1);
        this.setMessage("Proceso OK!!");
        try{
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(query);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            rs = pstm.executeQuery(); 
            if(!rs.next()){
                rs.close();
                pstm.close();
                throw new SQLException("Datos incorrectos");
            }
            admDto = new UsuarioDto();
            admDto.setIdEmpleado(rs.getInt("IDEMPLEADO"));
            admDto.setUsuario(rs.getString("USUARIO"));
            admDto.setClave(rs.getString("CLAVE"));
            admDto.setIdRol(rs.getInt("IDROL"));
            admDto.setActivo(rs.getInt("ACTIVO"));
            rs.close();
            pstm.close();
        } catch (SQLException e){
            this.setCode(-1);
            this.setMessage(e.getMessage());
        } catch (Exception e){
            this.setCode(-1);
            this.setMessage("Error en el proceso, intentelo de nuevo");
        } finally {
            try{
                cn.close();
        } catch (Exception e) {
        }
        return admDto;
        }
    }
}    