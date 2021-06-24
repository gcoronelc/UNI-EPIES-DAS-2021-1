/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.dto;

/**
 *
 * @author LENOVO
 */
public class CursoDto {
    private int IdCurso;
    private int IdArea;
    private String Nombre;
    private int CantidadHoras;
    private int Precio;

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int IdCurso) {
        this.IdCurso = IdCurso;
    }

    public int getIdArea() {
        return IdArea;
    }

    public void setIdArea(int IdArea) {
        this.IdArea = IdArea;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidadHoras() {
        return CantidadHoras;
    }

    public void setCantidadHoras(int CantidadHoras) {
        this.CantidadHoras = CantidadHoras;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getModulo() {
        return Modulo;
    }

    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }
    private String Modulo;
    
}
