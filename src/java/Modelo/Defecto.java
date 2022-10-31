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
public class Defecto {
    private String descripcion;
    private TipoDescripcion tipoDescripcion;

    public Defecto() {
    }

    public Defecto(String descripcion, TipoDescripcion tipoDescripcion) {
        this.descripcion = descripcion;
        this.tipoDescripcion = tipoDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDescripcion getTipoDescripcion() {
        return tipoDescripcion;
    }

    public void setTipoDescripcion(TipoDescripcion tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }
    
}
