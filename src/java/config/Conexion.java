/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */
public class Conexion {
    
    private static String url = "jdbc:mysql://127.0.0.1:3306/sistemacontrolcalzado";
    private static String user = "root";
    private static String pass = "VamoAKD14";
    
    public static Connection Conexion(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de Conexión"
                        + ": " + e.getMessage());
            
        }
        return con;
    }

    
}
