/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.time.LocalDate;
import udistrital.avanzada.taller1.modelo.Servicio;

/**
 *
 * @author mauri
 */
public class ControlServicio {
    /**
     * metodo para editar campos del Servicio
     * @param servicio
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaActualizacion
     * @param visibidad
     * @param duracion
     * @param imagen 
     */
    public void editarServicio(Servicio servicio,String nombre, String descripcion, double precio, LocalDate fechaActualizacion, boolean visibidad, int duracion,String imagen){
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setPrecio(precio);
        servicio.setFechaActualizacion(fechaActualizacion);
        servicio.setVisibidad(visibidad);
        servicio.setDuracion(duracion);
    }
}
