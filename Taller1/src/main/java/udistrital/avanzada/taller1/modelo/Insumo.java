/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.util.Date;

/**
 * @author mauricio
 * 24/09/2025
 * Clase producto 
 */
public class Insumo extends Item {
    // Cantidad del producto en existencias
    private int disponibidad;
    /**
     * Constructor con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaCreacion
     * @param visibidad
     * @param disponibidad cantidad en existencias del insumo
     * @param proveedor
     * @param id 
     */
    public Insumo(String nombre, String descripcion, double precio, Date fechaCreacion, boolean visibidad, int disponibidad, Proveedor proveedor, int id, String imagen) {
        super(nombre, descripcion, precio, fechaCreacion, visibidad, proveedor, id, imagen);
        this.disponibidad = disponibidad;
    }

    public int getDisponibidad() {
        return disponibidad;
    }

    public void setDisponibidad(int disponibidad) {
        this.disponibidad = disponibidad;
    }
    
}
