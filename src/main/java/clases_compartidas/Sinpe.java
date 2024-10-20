/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;


import jakarta.xml.bind.annotation.*;


@XmlRootElement
public class Sinpe extends MetodoPago {

    public Sinpe() {
    }

    public Sinpe(float monto) {
        super(monto);
        this.metodo = "Sinpe";
    }
    
    @Override
    public String[] getDatosPago() {
        String[] dataPago = {"metodo", "monto", "telefono"};
        return dataPago;
    }

    @Override
    public String[] getDatos() {
      String mo = String.valueOf(monto);
      String[] dataPago = {metodo, mo};
        return dataPago;
    }

    @Override
    public String toString() {
        return "Metodo de pago -> " + metodo + 
                "\nMonto pagado: " + monto + "\n"
                ;}
    
}
