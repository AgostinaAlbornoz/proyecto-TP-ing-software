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
public class Color {
    private String codColor;
    private String descripcion;
    

    public Color() {
    }

    public Color(String codColor, String descripcion) {
        this.codColor = codColor;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodColor() {
        return codColor;
    }

    public void setCodColor(String codColor) {
        this.codColor = codColor;
    }

    @Override
    public String toString() {
        return "Color{" + "descripcion=" + descripcion + ", codColor=" + codColor + '}';
    }
    
}
