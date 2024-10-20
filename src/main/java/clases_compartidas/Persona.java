package Clases_compartidas;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
public abstract class Persona {
    protected String cedula;
    protected String nombre;

    public Persona() {
        cedula = "";
        nombre = "";
    }

    public Persona(String cedula, String Nombre) {
        this.cedula = cedula;
        this.nombre = Nombre;
    }
@XmlAttribute
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
@XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public abstract String toString();
}
