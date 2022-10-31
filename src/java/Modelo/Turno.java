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
public class Turno {
    private Hora horaInicio;
    private Hora horaFin;

    public Turno(Hora horaInicio, Hora horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Hora getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Turno{" + "horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
}
