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

    public Insumo(String nombre, String descripcion, double precio, Date fechaCreacion, boolean visibidad, int disponibidad) {
        super(nombre, descripcion, precio, fechaCreacion, visibidad);
        this.disponibidad = disponibidad;
    }

    public int getDisponibidad() {
        return disponibidad;
    }

    public void setDisponibidad(int disponibidad) {
        this.disponibidad = disponibidad;
    }
    
}
