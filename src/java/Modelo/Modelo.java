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
public class Modelo {
    private int sku;
    private String denominacion;
    private int limiteInferiorReproceso;
    private int limiteSuperiorReproceso;
    private int limiteInferiorObservado;
    private int limiteSuperiorObservado;

    public Modelo() {
    }

    public Modelo(int sku, String denominacion, int limiteInferiorReproceso, int limiteSuperiorReproceso, int limiteInferiorObservado, int limiteSuperiorObservado) {
        this.sku = sku;
        this.denominacion = denominacion;
        this.limiteInferiorReproceso = limiteInferiorReproceso;
        this.limiteSuperiorReproceso = limiteSuperiorReproceso;
        this.limiteInferiorObservado = limiteInferiorObservado;
        this.limiteSuperiorObservado = limiteSuperiorObservado;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getLimiteInferiorReproceso() {
        return limiteInferiorReproceso;
    }

    public void setLimiteInferiorReproceso(int limiteInferiorReproceso) {
        this.limiteInferiorReproceso = limiteInferiorReproceso;
    }

    public int getLimiteSuperiorReproceso() {
        return limiteSuperiorReproceso;
    }

    public void setLimiteSuperiorReproceso(int limiteSuperiorReproceso) {
        this.limiteSuperiorReproceso = limiteSuperiorReproceso;
    }

    public int getLimiteInferiorObservado() {
        return limiteInferiorObservado;
    }

    public void setLimiteInferiorObservado(int limiteInferiorObservado) {
        this.limiteInferiorObservado = limiteInferiorObservado;
    }

    public int getLimiteSuperiorObservado() {
        return limiteSuperiorObservado;
    }

    public void setLimiteSuperiorObservado(int limiteSuperiorObservado) {
        this.limiteSuperiorObservado = limiteSuperiorObservado;
    }

    @Override
    public String toString() {
        return "Modelo{" + "sku=" + sku + ", denominacion=" + denominacion + ", limiteInferiorReproceso=" + limiteInferiorReproceso + ", limiteSuperiorReproceso=" + limiteSuperiorReproceso + ", limiteInferiorObservado=" + limiteInferiorObservado + ", limiteSuperiorObservado=" + limiteSuperiorObservado + '}';
    }
  
}
