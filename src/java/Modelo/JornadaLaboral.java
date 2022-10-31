/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author fabri
 */
public class JornadaLaboral {
    private Fecha fechaInicio;
    private Hora horaInicio;
    private Fecha fechaFin;
    private Hora horaFin;
    private Alerta alerta;
    private ArrayList<Incidencia> incidencias;

    public JornadaLaboral() {
        this.incidencias = new ArrayList();
    }

    public JornadaLaboral(Fecha fechaInicio, Hora horaInicio, Fecha fechaFin, Hora horaFin) {
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.incidencias = new ArrayList();
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Hora getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }

    public ArrayList<Incidencia> getIncidencias() {
        return incidencias;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    
    public void generarAlerta(){
        alerta = new Alerta();
    }
    
    public void agregarIncidencia(Incidencia i){
        incidencias.add(i);
    }
    
    public void eliminarIncidencia(Incidencia i){
        incidencias.remove(i);
    }

    @Override
    public String toString() {
        return "JornadaLaboral{" + "fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", fechaFin=" + fechaFin + ", horaFin=" + horaFin + '}';
    }
    
    
}
