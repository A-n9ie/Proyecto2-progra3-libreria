/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class GraficasVentas {
    
     public static float ventasCategoriaMes(List<Factura> facturas, Categoria categoria, int mes) {
         float ventasCategoria = 0.0f;
         for(Factura fact: facturas){
             if(fact.getLocalFecha().getMonthValue() == mes){
                for(DetalleVenta v: fact.getDetalles()){
                    if(v.getCategoria().equals(categoria.getNombre())){
                        ventasCategoria += v.importe();
                    }
                }
             }
         }
         return ventasCategoria;
     }
    
     public static List<Factura> filtrarFacturasPorFechaYCategoria(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin, List<String> categoriasSeleccionadas) {
        return facturas.stream()
                .filter(factura -> factura.getLocalFecha().isAfter(fechaInicio.minusDays(1)) && factura.getLocalFecha().isBefore(fechaFin.plusDays(1)))
                .filter(factura -> factura.getDetalles().stream()
                        .anyMatch(detalle -> categoriasSeleccionadas.contains(detalle.getCategoria())))
                .collect(Collectors.toList());
    }
    
   public static void crearYMostrarGraficaEnPanel(List<Factura> facturasFiltradas, JPanel panel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Factura factura : facturasFiltradas) {
            String mes = factura.getLocalFecha().getMonthValue() + "-" + factura.getLocalFecha().getYear(); // Mes y año
            for (DetalleVenta detalle : factura.getDetalles()) {
                String categoria = detalle.getProducto().getCategoria().getNombre();
                float importe = detalle.importe();
                dataset.addValue(importe, categoria, mes); // Ventas por categoría y mes
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Ventas por Categoría",
                "Mes",
                "Importe",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));

        panel.removeAll(); // Limpiar panel antes de agregar la nueva gráfica
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate(); // Validar cambios en el panel
    }
}
