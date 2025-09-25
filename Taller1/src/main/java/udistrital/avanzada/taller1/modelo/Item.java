/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.util.Date;

/**
 * @author mauricio
 * 24/09/2025
 * Clase Item es superclase para Producto y Servicio que pueden
 * publicar los proveedores
 */
public abstract class Item {
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected Date fechaCreacion;
    protected Date fechaActualizacion;    
    //Nos dice si la Persona tipo Usuario puede ver el Servicio
    protected boolean visibidad;    
    //TODO prop imagen

    public Item(String nombre, String descripcion, double precio, Date fechaCreacion, boolean visibidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaCreacion;
        this.visibidad = visibidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public boolean isVisibidad() {
        return visibidad;
    }

    public void setVisibidad(boolean visibidad) {
        this.visibidad = visibidad;
    }
    
    
    
}
