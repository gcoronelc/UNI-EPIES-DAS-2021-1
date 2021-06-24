/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.SistVentaPasajes.prueba;


import pe.SistVentaPasajes.dto.UsuarioDto;
import pe.SistVentaPasajes.service.LogonService;

public class Prueba02 {

    public static void main(String[] args) {
       //DATOS 
       String usuario="kevinpf";
       String clave="12345";
       //PROCESO
       LogonService service= new LogonService();
       
       UsuarioDto dto=service.validar(usuario,clave);
       //REPORTE 
       if(service.getCode()==1){
           System.out.println("Hola" + dto.getUsuario());
       }else {
          System.err.println("Error: " + service.getMessage()) ;
       }

    }
}
