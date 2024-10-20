/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;
import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class Categoria {
    private String nombre;

    public Categoria() {
        this.nombre = "indefinida";
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
@XmlAttribute
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
