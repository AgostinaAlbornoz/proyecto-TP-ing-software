/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBD;

import Modelo.Color;
import Modelo.Estado;
import Modelo.Fecha;
import Modelo.Linea;
import Modelo.OrdenDeProduccion;
import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class OPDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
//                               1             2                   3                     4                    5                 6                  7                 8       9         10        11         12
        String sql = "SELECT op.numero,DAY(op.FechaInicio),MONTH(op.fecha_inicio),YEAR(op.fecha_inicio),DAY(op.fecha_fin),MONTH(op.fecha_fin),YEAR(op.fecha_fin),op.objetivos,op.estado,l.idlinea,c.codigo,c.descripcion FROM orden_de_produccion AS op INNER JOIN linea AS l ON op.linea_idlinea=l.idlinea INNER JOIN color AS c ON op.color_codigo=c.codigo";
        List<OrdenDeProduccion> lista = new ArrayList();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                OrdenDeProduccion op = new OrdenDeProduccion();
                op.setNumero(rs.getInt(1));
                op.setFechaInicio(new Fecha(rs.getInt(2),rs.getInt(3),rs.getInt(4)));  
                op.setFechaFin(new Fecha(rs.getInt(5),rs.getInt(6),rs.getInt(7)));   
                op.setObjetivos(rs.getString(8));
                op.setEstado(Estado.getEstado(rs.getString(9)));
                op.setLinea(new Linea(rs.getInt(10)));
                op.setColor(new Color(rs.getString(11),rs.getString(12)));
                lista.add(op);
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        
        return lista;
    }
    
    public int agregarOP(OrdenDeProduccion op){
        //                                             1        2          3         4       5         6         7           8   
        String sql = "INSERT INTO orden_de_produccion (numero,fecha_inicio,fecha_fin,objetivos,estado,modelo_sku,linea_idlinea,color_codigo) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, op.getNumero());
            ps.setDate(2, new Date(op.getFechaInicio().getYear(), op.getFechaInicio().getMes(), op.getFechaInicio().getDia()));
            ps.setDate(3, new Date(op.getFechaFin().getYear(), op.getFechaFin().getMes() ,op.getFechaFin().getDia()));
            ps.setString(4, op.getObjetivos());
            ps.setInt(5, op.getEstado().ordinal());
            ps.setInt(6, op.getModelo().getSku());
            ps.setInt(7, op.getLinea().getNumero());
            ps.setString(8, op.getColor().getCodColor());
            
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return -1;
        }
        return r;
    }
    
    public OrdenDeProduccion listarOP(int numero){
        OrdenDeProduccion ops = new OrdenDeProduccion();
        String sql = "SELECT op.numero,DAY(op.fecha_inicio),MONTH(op.fecha_inicio),YEAR(op.fecha_inicio),DAY(op.fecha_fin),MONTH(op.fecha_fin),YEAR(op.fecha_fin),op.objetivos,op.estado,l.idlinea,c.codigo,c.descripcion FROM orden_de_produccion AS op INNER JOIN linea AS l ON op.linea_idlinea=l.idlinea INNER JOIN color AS c ON op.color_codigo=c.codigo WHERE numero="+numero;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                ops.setNumero(rs.getInt(1));
                ops.setFechaInicio(new Fecha(rs.getInt(2), rs.getInt(3), rs.getInt(4)));
                ops.setFechaFin(new Fecha(rs.getInt(5), rs.getInt(6), rs.getInt(7)));
                ops.setObjetivos(rs.getString(8));
                ops.setEstado(Estado.getEstado(rs.getString(9)));
                ops.setLinea(new Linea(rs.getInt(10)));
                ops.setColor(new Color(rs.getString(11), rs.getString(12)));
                
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        
        return ops;
    }
    

}
