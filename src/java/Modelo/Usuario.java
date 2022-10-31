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
public class Usuario {
    int idUsuario;
    String usuario;
    String clave;
    int dni;

    public Usuario(int idUsuario, String usuario, String clave, int dni) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.dni = dni;
    }

    public Usuario() {
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public int getDni() {
        return dni;
    }
    
    
}
