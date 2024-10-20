package Clases_compartidas;

import jakarta.xml.bind.annotation.*;


@XmlRootElement
public class Cajero extends Persona{

    public Cajero() {
        super("indefinido","indefinido");
    }

    public Cajero(String cedula, String Nombre) {
        super(cedula, Nombre);
    }
    
    public String[] getDatosCajero(){
        String[] dataCustomer = {"cedula", "nombre"};
        
        return dataCustomer;
    }
    
    public String[] getDatos(){
        String[] data = {cedula, nombre};
        return data;
    }
    
     public String[] getDataCajero(){
        String[] dataCajero = {"identificacion", "nombre"};
        return dataCajero;
    }
    
    public String[] getData(){
        String[] data = {cedula, nombre};
        return data;
    }
    @Override
    public String toString() {
        return nombre + " _ " + cedula;
    }
}
