
package Clases_compartidas;

import jakarta.xml.bind.annotation.*;


@XmlRootElement
public class EstadisticasVenta {
    private String categoria;
    private int mes;
    private int anno;
    private double totalVentas;

    public EstadisticasVenta(String categoria, int mes, int anno, double totalVentas) {
        this.categoria = categoria;
        this.mes = mes;
        this.anno = anno;
        this.totalVentas = totalVentas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
    
    
}
