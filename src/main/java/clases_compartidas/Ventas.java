/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.plot.PlotOrientation;
/**
 *
 * @author angie
 */
public class Ventas {

    public Ventas() {
    }
    
    public Map<String, Map<String, Double>> calcularVentasPorCategoriaYMes(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin) {
    Map<String, Map<String, Double>> ventasPorCategoriaYMes = new HashMap<>();

    for (Factura factura : facturas) {
        LocalDate fechaFactura = factura.getLocalFecha();

        // Verificar si la factura está dentro del rango de fechas
        if ((fechaFactura.isEqual(fechaInicio) || fechaFactura.isAfter(fechaInicio)) &&
            (fechaFactura.isEqual(fechaFin) || fechaFactura.isBefore(fechaFin))) {

            String mes = factura.getMes();
            
            // Procesar los detalles de la venta de la factura
            for (DetalleVenta detalle : factura.getDetalles()) {
                String categoria = detalle.getProducto().getCategoria().getNombre(); 
                double cantidadVendida = detalle.getCantidad(); 
                
                // Obtener las ventas para esa categoría
                Map<String, Double> ventasPorMes = ventasPorCategoriaYMes.getOrDefault(categoria, new HashMap<>());
                double totalMes = ventasPorMes.getOrDefault(mes, 0.0);
                
                // Sumar la cantidad vendida en el mes para esa categoría
                ventasPorMes.put(mes, totalMes + cantidadVendida);
                ventasPorCategoriaYMes.put(categoria, ventasPorMes);
            }
        }
    }
    return ventasPorCategoriaYMes;  // Devuelve un mapa de categorías con ventas por mes
}
    
    public void llenarTabla(DefaultTableModel modeloTabla, Map<String, Map<String, Double>> ventasPorCategoriaYMes) {
    modeloTabla.setRowCount(0); // Limpiar la tabla

    for (String categoria : ventasPorCategoriaYMes.keySet()) {
        Map<String, Double> ventasPorMes = ventasPorCategoriaYMes.get(categoria);

        Object[] fila = new Object[4]; // Asumimos que hay 3 meses
        fila[0] = categoria;
        fila[1] = ventasPorMes.getOrDefault("2024-7", 0.0);
        fila[2] = ventasPorMes.getOrDefault("2024-8", 0.0);
        fila[3] = ventasPorMes.getOrDefault("2024-9", 0.0);

        modeloTabla.addRow(fila);
    }
}
    
public DefaultCategoryDataset crearDatasetVentasPorCategoria(Map<String, Map<String, Double>> ventasPorCategoriaYMes) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (String categoria : ventasPorCategoriaYMes.keySet()) {
        Map<String, Double> ventasPorMes = ventasPorCategoriaYMes.get(categoria);

        for (String mes : ventasPorMes.keySet()) {
            double ventas = ventasPorMes.get(mes);
            dataset.addValue(ventas, categoria, mes);
        }
    }

    return dataset;
}
    
  public JFreeChart crearGraficaPorCategoria(CategoryDataset dataset) {
    JFreeChart lineChart = ChartFactory.createLineChart(
            "Ventas por mes",  // Título del gráfico
            "Mes",             // Etiqueta del eje X
            "Ventas",          // Etiqueta del eje Y
            dataset,           // Datos para la gráfica
            PlotOrientation.VERTICAL, // Orientación
            true,              // Incluir leyenda
            true,              // Incluir tooltips
            false              // Excluir URLs
    );

    return lineChart;
}



}
