/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBD;

import Modelo.Fecha;
import Modelo.Hora;
import Modelo.JornadaLaboral;
import Modelo.OrdenDeProduccion;
import Modelo.Ranking;
import Modelo.TipoDescripcion;
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
public class SemaforoDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<JornadaLaboral> cargarJornadas(OrdenDeProduccion ops){
        List<JornadaLaboral> lista = new ArrayList();
        //                              1                  2                       3                       4                       5                        6                    7                    8                        9                  10                       11                     12                13               14
        String sql = "SELECT DAY(jl.fecha_ingreso),MONTH(jl.fecha_ingreso),YEAR(jl.fecha_ingreso), HOUR(jl.hora_ingreso),MINUTE(jl.hora_ingreso),SECOND(jl.hora_ingreso),DAY(jl.fecha_salida),MONTH(jl.fecha_salida),YEAR(jl.fecha_salida),HOUR(jl.hora_salida),MINUTE(jl.hora_salida),SECOND(jl.hora_salida),jl.fecha_salida,jl.hora_salida FROM jornada_laboral AS jl INNER JOIN orden_de_produccion AS op ON jl.orden_de_produccion_numero=op.numero";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                JornadaLaboral j = new JornadaLaboral();
                j.setFechaInicio(new Fecha(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
                j.setHoraInicio(new Hora(rs.getInt(4),rs.getInt(5),rs.getInt(6)));
                if(rs.getDate(13) != null && rs.getTime(14) != null){
                    j.setFechaFin(new Fecha(rs.getInt(7),rs.getInt(8),rs.getInt(9)));
                    j.setHoraFin(new Hora(rs.getInt(10),rs.getInt(11),rs.getInt(12)));
                }
                
                lista.add(j);
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        return lista;
    }
    
    public int consultarSemaforo(OrdenDeProduccion op, String td){
        String sql = "SELECT COUNT(de.tipo_defecto) FROM detalle_defecto AS de INNER JOIN defecto AS d ON de.idDet=d.detalle_defecto_idDet INNER JOIN incidencia AS i on d.incidencia_idincidencia=i.idincidencia INNER JOIN jornada_laboral AS jl ON i.jornada_laboral_idJornadaLaboral=jl.idJornadaLaboral INNER JOIN orden_de_produccion AS op ON jl.orden_de_produccion_numero=op.numero WHERE op.numero=" + op.getNumero() + ",de.tipo_defecto=" + "'" + td.toUpperCase() + "'" + " GROUP BY de.tipo_defecto;";
        int sem = 0;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            sem = rs.getInt(1);
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
        }
        
        return sem;
    }
    
    public List<Ranking> rankingDefectos(OrdenDeProduccion ops, String td){
        List<Ranking> lista = new ArrayList();
        
        String sql = "SELECT de.descripcion,COUNT(de.idDet) AS apariciones FROM defecto AS d INNER JOIN detalle_defecto AS de ON d.detalle_defecto_idDet=de.idDet INNER JOIN incidencia AS i ON d.incidencia_idincidencia=i.idincidencia INNER JOIN jornada_laboral as jl ON i.jornada_laboral_idJornadaLaboral=jl.idJornadaLaboral INNER JOIN orden_de_produccion AS op ON op.numero=jl.idJornadaLaboral WHERE op.numero=" + ops.getNumero() + " AND de.tipo_defecto=" + td.toUpperCase() + "GROUP BY de.idDet ORDER BY apariciones";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Ranking ra = new Ranking();
                ra.setEvento(rs.getString(1));
                ra.setNumero(rs.getInt(2));
                lista.add(ra);
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error." + e.getMessage());
            return null;
        }
        
        return lista;
    }
}
