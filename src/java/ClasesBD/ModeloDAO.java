package ClasesBD;

import Modelo.Modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class ModeloDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql = "SELECT * FROM modelo";
        List<Modelo> lista = new ArrayList();
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelo m = new Modelo();
                m.setSku(rs.getInt(1));
                m.setDenominacion(rs.getString(2));
                m.setLimiteInferiorReproceso(rs.getInt(3));
                m.setLimiteSuperiorReproceso(rs.getInt(4));
                m.setLimiteInferiorObservado(rs.getInt(5));
                m.setLimiteSuperiorObservado(rs.getInt(6));
                lista.add(m);
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        return lista;
    }
    public int agregar(Modelo m){
        String sql = "INSERT INTO modelo (sku,descripcion,limiteInferiorReproceso,limiteSuperiorReproceso,limiteInferiorObservado,limiteSuperiorObservado) VALUES (?,?,?,?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, m.getSku());
            ps.setString(2, m.getDenominacion());
            ps.setInt(3, m.getLimiteInferiorReproceso());
            ps.setInt(4, m.getLimiteSuperiorReproceso());
            ps.setInt(5, m.getLimiteInferiorObservado());
            ps.setInt(6, m.getLimiteSuperiorObservado());
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return -1;
        }
        return r;
    }
    
    public Modelo listarSKU(int SKU){
        Modelo m = new Modelo();
        String sql = "SELECT * FROM modelo WHERE sku="+SKU;
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                m.setSku(rs.getInt(1));
                m.setDenominacion(rs.getString(2));
                m.setLimiteInferiorReproceso(rs.getInt(3));
                m.setLimiteSuperiorReproceso(rs.getInt(4));
                m.setLimiteInferiorObservado(rs.getInt(5));
                m.setLimiteSuperiorObservado(rs.getInt(6));
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        
        return m;
    }
    public int actualizar(Modelo m){
        String sql = "UPDATE modelo SET sku=?,descrpicion=?,limiteInferiorReproceso=?,limiteSuperiorReproceso=?,limiteInferiorObservado=?,limiteSuperiorObservado=? WHERE sku=?";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, m.getSku());
            ps.setString(2, m.getDenominacion());
            ps.setInt(3, m.getLimiteInferiorReproceso());
            ps.setInt(4, m.getLimiteSuperiorReproceso());
            ps.setInt(5, m.getLimiteInferiorObservado());
            ps.setInt(6, m.getLimiteSuperiorObservado());
            ps.setInt(7, m.getSku());
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return -1;
        }
        return r;
    }
    public void eliminar(int SKU){
        String sql = "DELETE FROM modelo WHERE sku="+SKU;
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
        }
    }
}
