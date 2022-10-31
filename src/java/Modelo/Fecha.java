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
public class Fecha{
    Calendar fecha = new GregorianCalendar();
    private int dia;
    private int mes;
    private int year;
    

    public Fecha() {
        this.dia = fecha.get(Calendar.DAY_OF_MONTH);
        this.mes = fecha.get(Calendar.MONTH);
        this.year = fecha.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getYear() {
        return year;
    }
    
    public String getFecha(){
        return "Fecha: " + dia + " / " + (mes + 1)+ " / " + year;
    }

    @Override
    public String toString() {
        return "\n  Fecha: " + dia + " / " + (mes + 1)+ " / " + year;
    }
    
    
    
}