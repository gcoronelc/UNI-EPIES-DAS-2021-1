/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.prueba;

import pe.sistgestacademica.dto.UsuarioDto;
import pe.sistgestacademica.service.LogonService;


/**
 *
 * @author USUARIO
 */
public class Prueba02 {
    public static void main(String[] args){
        
        // Datos
        String usuario = "wzavaleta";
        String clave = "123456";
        // Proceso
        LogonService service = new LogonService();
        UsuarioDto dto = service.validar(usuario, clave);
        // Reporte
        if( service.getCode() == 1){
            System.out.println("Hola " + dto.getUsuario() );
        } else {
            System.err.println("Error: " + service.getMessage());
        }
    }
}
