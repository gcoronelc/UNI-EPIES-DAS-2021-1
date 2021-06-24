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
import java.util.ArrayList;
import java.util.List;
import pe.sistgestacademica.db.AccesoDB;
import pe.sistgestacademica.dto.AreaDto;

/**
 *
 * @author LENOVO
 */
public class AreaService extends AbstractService implements ICrud<AreaDto>{
    private final String queryBase = "SELECT IdArea, Nombre "
            + "FROM AREA ";
    
    @Override
    public List<AreaDto> leerTodos() {
        List<AreaDto> lista = new ArrayList<>();
        AreaDto dto = null;
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
                dto = new AreaDto();
                dto.setIdArea(rs.getInt("IdArea"));
                dto.setNombre(rs.getString("Nombre"));
                lista.add(dto);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            this.setCode(-1);
            this.setMessage(e.getMessage());
        } catch (Exception e) {
            this.setCode(-1);
            this.setMessage("Error en el proceso, intente de nuevo.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public List<AreaDto> leerTodos(AreaDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaDto leerPorId(int id) {
        AreaDto dto = null;
        String query = queryBase + "WHERE IdArea = ?";
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
            dto = new AreaDto();
            dto.setIdArea(rs.getInt("IdArea"));
            dto.setNombre(rs.getString("Nombre"));
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
    public int grabar(AreaDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(AreaDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
