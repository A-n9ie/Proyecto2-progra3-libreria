/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import java.util.Calendar;

/**
 *
 * @author angie
 */
public class Fecha_Hora {
    static Calendar date = Calendar.getInstance();
    static Calendar hour = Calendar.getInstance();
    
    public static String horaActual(){
        int hora, minutos, segundos;
        hora = hour.get(Calendar.HOUR_OF_DAY);
        minutos = hour.get(Calendar.MINUTE);
        segundos = hour.get(Calendar.SECOND);
        return hora + ":" + minutos + ":" + segundos;
    } 
    
    public static String fechaActual(){
        int dia, mes, agno;
        dia = date.get(Calendar.DATE);
        mes = date.get(Calendar.MONTH) + 1;
        agno = date.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + agno;
    }
    
    
}
