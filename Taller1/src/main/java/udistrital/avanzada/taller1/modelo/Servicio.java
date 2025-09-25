/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.util.Date;

/**
 * @author mauricio
 * 24/9/2025
 * Clase de servicio
 */
public class Servicio extends Item{    
    private int duracion;
    public Servicio(String nombre, String descripcion, double precio, Date fechaCreacion, boolean visibidad, int duracion) {
        super(nombre, descripcion, precio, fechaCreacion, visibidad);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}
