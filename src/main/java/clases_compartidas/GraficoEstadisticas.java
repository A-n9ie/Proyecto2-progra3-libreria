package Clases_compartidas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GraficoEstadisticas {

    public JPanel crearGraficoEstadisticas(List<Factura> facturas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Double> totalVentasPorCategoria = new HashMap<>();
        
        for (Factura factura : facturas) {
            for (DetalleVenta detalle : factura.getDetalles()) {
                String categoria = detalle.getProducto().getCategoria().getNombre();
                double totalVenta = detalle.importe();

                // Sumar las ventas por categoría
                totalVentasPorCategoria.merge(categoria, totalVenta, Double::sum);
            }
        }
        
        // Agregar los totales al dataset por categoría y mes
        for (Map.Entry<String, Double> entry : totalVentasPorCategoria.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), "Mes");
        }
        
        JFreeChart barChart = ChartFactory.createBarChart(
                "Ventas Mensuales",        // Título del gráfico
                "Categoría",               // Etiqueta del eje X
                "Total Ventas",            // Etiqueta del eje Y
                dataset,                   // Datos
                PlotOrientation.VERTICAL,  // Orientación del gráfico
                true,                      // Incluir leyenda
                true,                      // Incluir tooltips
                false                      // No usar URLs
        );

        return new ChartPanel(barChart);
    }
}