/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fabri
 */
public enum Estado {
    INICIADA , PAUSADA , FINALIZADA;
    
    public static Estado getEstado(String e){
        if(e.toUpperCase().equals("INICIADA")){return Estado.INICIADA;}
        if(e.toUpperCase().equals("PAUSADA")){return Estado.PAUSADA;}
        if(e.toUpperCase().equals("FINALIZADA")){return Estado.FINALIZADA;}
        else{return null;}
    }
}
