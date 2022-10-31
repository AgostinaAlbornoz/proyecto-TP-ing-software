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
public class OrdenDeProduccion {
    private int numero;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private Estado estado;
    private Color color;
    private Modelo modelo;
    private Linea linea;
    private String objetivos;
    private ArrayList<JornadaLaboral> jornadas;

    public OrdenDeProduccion() {
        this.jornadas = new ArrayList();
    }

    public OrdenDeProduccion(int numero, Fecha fechaInicio, Estado estado, Color color, Modelo modelo, Linea linea) {
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.jornadas = new ArrayList();
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<JornadaLaboral> getJornadas() {
        return jornadas;
    }

    public void setJornadas(ArrayList<JornadaLaboral> jornadas) {
        this.jornadas = jornadas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
    
    public void agregarJornada(JornadaLaboral j){
        jornadas.add(j);
    }
    
    public void mostrarJornadas(){
        jornadas.forEach((j) -> {
            j.toString();
        });
    }
    
    public JornadaLaboral obtenerJornadaActual(){
        int i = jornadas.size();
        return jornadas.get(i - 1);
    }
    
}
