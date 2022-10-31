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
public class Alerta {
    private Fecha fecha;
    private Hora hora;

    public Alerta() {
        this.fecha = new Fecha();
        this.hora = new Hora();
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Alerta{" + "fecha=" + fecha + ", hora=" + hora + '}';
    }
    
}
