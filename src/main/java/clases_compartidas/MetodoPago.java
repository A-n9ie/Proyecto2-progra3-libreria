/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import jakarta.xml.bind.annotation.*;


@XmlSeeAlso({Tarjeta.class, Efectivo.class, Cheque.class, Sinpe.class})
public abstract class MetodoPago {
    protected String metodo;
    protected float monto;

    public MetodoPago() {
        this.metodo = "indefinido";
        this.monto = 0.0f;
    }

    public MetodoPago(float monto) {
        this.monto = monto;
    }
@XmlAttribute
    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
@XmlElement
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public abstract String[] getDatosPago();
    public abstract String[] getDatos();
    @Override
    public abstract String toString();
}
