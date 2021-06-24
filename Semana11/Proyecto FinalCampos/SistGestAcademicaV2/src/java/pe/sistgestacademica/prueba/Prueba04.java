/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.prueba;

import java.util.List;
import pe.sistgestacademica.dto.CursoDto;
import pe.sistgestacademica.dto.UsuarioDto;
import pe.sistgestacademica.service.CursoService;
import pe.sistgestacademica.service.LogonService;


/**
 *
 * @author USUARIO
 */
public class Prueba04 {
    public static void main(String[] args){
        
        
		try {
            CursoService service = new CursoService();
            CursoDto dto = service.leerPorId(2);
            if (service.getCode() == 1) {
                System.out.println("Curso: " + dto.getNombre() + " " + dto.getModulo());
            } else {
                System.err.println(service.getMessage());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
