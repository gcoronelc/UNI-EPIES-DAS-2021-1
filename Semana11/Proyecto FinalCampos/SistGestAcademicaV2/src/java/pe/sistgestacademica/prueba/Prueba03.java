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
public class Prueba03 {
    public static void main(String[] args){
        
        
		try {
			CursoService service = new CursoService();
			List<CursoDto> lista = service.leerTodos();
			for (CursoDto dto : lista) {
				System.out.println(dto.getNombre() + " - " + dto.getModulo());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    }
}
