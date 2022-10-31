/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.time.LocalDateTime;
import java.util.*;
/**
 *
 * @author fabri
 */
public class Hora {
    LocalDateTime locaDate = LocalDateTime.now();
    private int hora;
    private int minutos;
    private int segundos;
    
    public Hora(){
        this.hora = locaDate.getHour();
        this.minutos = locaDate.getMinute();
        this.segundos = locaDate.getSecond();
    }
    
    public Hora(int hora, int minutos, int segundos){
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "Hora:" + hora + " : " + minutos + " : " + segundos;
    }
    
    
}
