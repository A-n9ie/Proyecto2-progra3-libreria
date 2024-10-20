/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author angie
 */
public class PDF {
    Factura factura;

    public PDF(Factura factura) {
        this.factura = factura;
    }
    
    public void generarPDF(){
        Document document = new Document();
        try {
            // crea el archivo "ejemplo.pdf" con PdfWriter
            PdfWriter.getInstance(document, new FileOutputStream("Factura_" + factura.getNumFactura() + ".pdf"));
            //abre el documento
            document.open();
            //escribe en el documento
            document.add(new Paragraph("Factura #" + factura.getNumFactura()));
            document.add(new Paragraph("Fecha: " + factura.getFecha() + 
                    "                                             Hora: " + factura.getHora()));
            document.add(new Paragraph("Cliente     " + factura.getCliente().getNombre() 
                    + "                         Cedula: " + factura.getCliente().getCedula()));
            document.add(new Paragraph("Cajero     " + factura.getCajero().getNombre() 
                    + "                         Cedula: " + factura.getCajero().getCedula()));
            document.add(new Paragraph ("                                                       "));
            
            String[] table = {"Codigo", "Producto", "Cantidad", "Precio", "Descuento", "Neto", "Importe"};
                     
            PdfPTable pdfTable = new PdfPTable(table.length);
                    pdfTable.setWidthPercentage(88.8f); //ancho de la tabla
                    
            // Agregar encabezados
            for (String table1 : table) {
                pdfTable.addCell(new Phrase(table1));
            }

            for (DetalleVenta detalle : factura.getDetalles()) {
                String[] info = {detalle.getProducto().getCodigo(), detalle.getProducto().getDescripcion(),
                    String.valueOf(detalle.getCantidad()), String.valueOf(detalle.getProducto().getPrecio()),
                    String.valueOf(detalle.getProducto().getDescuento()), String.valueOf(detalle.precioNeto()),
                    String.valueOf(detalle.importe())};
                for (String table1 : info) {
                    Object value = table1;
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }
            
            String[] table2 = {"Cantidad total", "Subtotal", "Descuento Cliente", "Total"};
            String[] table2Info = {String.valueOf(factura.cantidadTotal()),
                String.valueOf(factura.subtotal()), String.valueOf(factura.getCliente().getDescuento()),
                String.valueOf(factura.montoTotal())};    
            
            PdfPTable pdfTableTotal = new PdfPTable(table2.length);
            pdfTableTotal.setWidthPercentage(88.8f);
            // Agregar encabezados
            for (String table1 : table2) {
                pdfTableTotal.addCell(new Phrase(table1));
            }
             for (String table1 : table2Info) {
                    Object value = table1;
                    pdfTableTotal.addCell(value != null ? value.toString() : "");
                }
             
             for(MetodoPago pago : factura.getPagos()){
             document.add(new Paragraph (pago.toString()));
              document.add(new Paragraph ("                                                       "));
             }
             document.add(new Paragraph ("                                                       "));
            
            //
            // Agrega la tabla PDF al documento y cierra el documento.
            document.add(pdfTable);
            document.add(pdfTableTotal);
            // cierra el documento
            document.close();
            System.out.println("El PDF se ha creado exitosamente.");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
