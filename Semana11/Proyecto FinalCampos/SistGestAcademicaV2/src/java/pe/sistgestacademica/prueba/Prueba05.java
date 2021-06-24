/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.prueba;

import java.util.List;
import pe.sistgestacademica.dto.AreaDto;
import pe.sistgestacademica.service.AreaService;


/**
 *
 * @author USUARIO
 */
public class Prueba05 {
    public static void main(String[] args){
        
        
		try {
			AreaService service = new AreaService();
			List<AreaDto> lista = service.leerTodos();
			for (AreaDto dto : lista) {
				System.out.println(dto.getIdArea() + " - " + dto.getNombre());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    }
}
