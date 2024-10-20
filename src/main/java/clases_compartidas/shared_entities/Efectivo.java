/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_compartidas.shared_entities;

import jakarta.xml.bind.annotation.*;


@XmlRootElement
public class Efectivo extends MetodoPago {
    private float pago;
    private float cambio;

    public Efectivo() {
    }

    public Efectivo(float pago, float monto) {
        super(monto);
        this.metodo = "Efectivo";
        this.pago = pago;
        this.cambio = pago - monto;
    }
@XmlElement
    public double getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }
@XmlElement
    public double getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
    
    @Override
    public String[] getDatosPago() {
        String[] dataPago = {"metodo", "monto", "pago", "cambio"};
        return dataPago;
    }

    @Override
    public String[] getDatos() {
        String mo = String.valueOf(monto);
        String pa = String.valueOf(pago);
        String ca = String.valueOf(cambio);
        String[] data = {metodo, mo, pa, ca};
        return data;
    }

    @Override
    public String toString() {
        return "Metodo de pago -> " + metodo +
                "\nPago: " + monto +
                "\nCambio: "+ cambio + "\n";
    } 
    
}
