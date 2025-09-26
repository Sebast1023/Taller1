/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.util.Date;

/**
 * @author mauricio
 * 24/9/2025
 * Clase de servicio para los Proveedores tipo servicio
 */
public class Servicio extends Item{    
    //duracion aproximada en minutos del servicio
    private int duracion;
    /**
     * Constructor con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaCreacion
     * @param visibidad
     * @param duracion duracion aproximada en minutos del servicio
     * @param proveedor
     * @param id
     * @param imagen 
     */
    public Servicio(String nombre, String descripcion, double precio, Date fechaCreacion, boolean visibidad, int duracion, Proveedor proveedor, int id, String imagen) {
        super(nombre, descripcion, precio, fechaCreacion, visibidad, proveedor, id, imagen);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
