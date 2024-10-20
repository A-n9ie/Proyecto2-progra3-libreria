/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import jakarta.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@XmlRootElement
public class DetalleVenta {
    private int cantidad;
    private Producto producto;
    //private LocalDate fecha;

    public DetalleVenta() {
        this.cantidad = 0;
        this.producto = new Producto();
        //this.fecha = LocalDate.now();
    }

    public DetalleVenta(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        //this.fecha = LocalDate.now();
    }
@XmlElement
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
@XmlElement(name = "producto")
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    /*
     @XmlElement
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @XmlElement
    public String getMes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        return fecha.format(formatter);
    }
    */
    @XmlElement
    public String getCategoria(){
        return producto.getCategoria().getNombre();
    }
    
    public float importe(){
        return precioNeto() * cantidad;
    }
    
    public float precioNeto(){
        float neto = producto.getPrecio() - (producto.getPrecio() * producto.getDescuento());
        return neto;
    }

    @Override
    public String toString() {
        return "\"Producto: \"" + producto.getDescripcion() + "   \"Precio: \"" + 
               producto.getPrecio() + "   \"Cantidad: \"" + cantidad + "  \"Neto: \"" + 
               precioNeto() + " \"Importe: \"" + importe() + "\n";
    }
    
}
