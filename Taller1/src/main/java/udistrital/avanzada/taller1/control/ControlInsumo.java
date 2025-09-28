/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.time.LocalDate;
import udistrital.avanzada.taller1.modelo.Insumo;

/**
 *
 * author mauricio
 */
public class ControlInsumo {
    /**
     * metodo para editar campoas de insumo
     * @param insumo
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaCreacion
     * @param visibidad
     * @param disponibilidad
     * @param imagen 
     */
    public void  editarInsumo(Insumo insumo, String nombre, String descripcion, double precio, LocalDate fechaCreacion, boolean visibidad, int disponibilidad, String imagen){
        insumo.setDescripcion(descripcion);
        insumo.setDisponibidad(disponibilidad);
        insumo.setFechaActualizacion(fechaCreacion);
        insumo.setNombre(nombre);
        insumo.setVisibidad(visibidad);
        insumo.setPrecio(precio);
    }
}
