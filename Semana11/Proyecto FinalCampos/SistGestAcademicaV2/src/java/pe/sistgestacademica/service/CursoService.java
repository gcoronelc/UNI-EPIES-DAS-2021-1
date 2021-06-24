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
import pe.sistgestacademica.dto.CursoDto;

/**
 *
 * @author LENOVO
 */
public class CursoService extends AbstractService implements ICrud<CursoDto> {

    private final String queryBase = "SELECT IdCurso, IdArea, Nombre, Cantidad_Horas,Precio,Modulo "
            + "FROM CURSO ";

    @Override
    public List<CursoDto> leerTodos() {
        List<CursoDto> lista = new ArrayList<>();
        CursoDto dto = null;
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
                dto = new CursoDto();
                dto.setIdCurso(rs.getInt("IdCurso"));
                dto.setIdArea(rs.getInt("IdArea"));
                dto.setNombre(rs.getString("Nombre"));
                dto.setCantidadHoras(rs.getInt("Cantidad_Horas"));
                dto.setPrecio(rs.getInt("Precio"));
                dto.setModulo(rs.getString("Modulo"));
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
    public List<CursoDto> leerTodos(CursoDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CursoDto leerPorId(int id) {
        CursoDto dto = null;
        String query = queryBase + "WHERE IdCurso = ?";
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
            dto = new CursoDto();
            dto.setIdCurso(rs.getInt("IdCurso"));
            dto.setIdArea(rs.getInt("IdArea"));
            dto.setNombre(rs.getString("Nombre"));
            dto.setCantidadHoras(rs.getInt("Cantidad_Horas"));
            dto.setPrecio(rs.getInt("Precio"));
            dto.setModulo(rs.getString("Modulo"));
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
    public int grabar(CursoDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(CursoDto bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
