/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBD;

import Modelo.Usuario;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author fabri
 */
public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar(String usuario, String clave){
        Usuario u = new Usuario();
//        String sql = "select * from usuario where nombre=? and clave=?";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement("SELECT * FROM usuario WHERE nombre= ? AND clave= ?");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                u.setUsuario(rs.getString("nombre"));
                u.setClave(rs.getString ("clave"));
                u.setDni(rs.getInt("empleado_dni"));
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        return u;
    }
}
