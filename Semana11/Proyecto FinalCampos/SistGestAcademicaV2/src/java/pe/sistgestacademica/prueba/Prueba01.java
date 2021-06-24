/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.prueba;

import java.sql.Connection;
import pe.sistgestacademica.db.AccesoDB;


/**
 *
 * @author USUARIO
 */
public class Prueba01 {
    public static void main(String[] args){
        
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion OK!!!");
            cn.close();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
