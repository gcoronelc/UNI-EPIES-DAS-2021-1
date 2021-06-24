/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.sistgestacademica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class AccesoDB {
    private AccesoDB() {
    }

    public static Connection getConnection() throws SQLException{
        Connection cn = null;   
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=GESTIONACADEMICA";
        String user = "sa";
        String password = "sql";
        try {
            // --------------------------------------------------
            // Paso 1: Cargar el driver a memoria
            Class.forName(driver).newInstance();
            // Paso 2: Obtener el objeto Connection
            cn = DriverManager.getConnection(urlDB, user, password);
            // --------------------------------------------------
        } catch (SQLException e) {
            throw e;
        } catch(ClassNotFoundException e){
            throw new SQLException("No se encontró el driver de la base de datos.");
        } catch(Exception e){
            throw new SQLException("No se puede establecer la conexión con la base de datos.");
        }
        return cn;
    }
}
