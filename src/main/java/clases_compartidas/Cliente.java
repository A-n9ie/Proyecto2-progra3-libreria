package Clases_compartidas;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class Cliente extends Persona {
    private String correo;
    private String telefono;
    private float descuento;

    public Cliente() {
        super("indefinido","indefinido");
        correo = "indefinido";
        telefono = "indefinido";
        descuento = 0.0f;
    }

    public Cliente(String correo, String telefono, float descuento, String cedula, String name) {
        super(cedula, name);
        this.correo = correo;
        this.telefono = telefono;
        this.descuento = descuento;
    }
@XmlElement
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
@XmlElement
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
@XmlElement
    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    public String[] getDatosCliente(){
        String[] dataCustomer = {"cedula", "nombre", "telefono", "correo", "descuento"};
        
        return dataCustomer;
    }
    
    public String[] getDatos(){
        String discount = String.valueOf(descuento);
        String[] data = {cedula, nombre, telefono,correo, discount};
        return data;
    }

    @Override
    public String toString() {
        return nombre + " _ " + cedula;
    }
}

