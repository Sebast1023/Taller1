/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.time.LocalDate;

/**
 * author mauricio
 * 24/09/2025
 * Clase Item es superclase para Producto y Servicio que pueden
 * crear los proveedores
 */
public abstract class Item {
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected LocalDate fechaCreacion;
    protected LocalDate fechaActualizacion;    
    //visibilidad dice si puede ser visible a otras personas tipo Usuario o Proveedor
    //Administrador puede verla sin importar el estado
    protected boolean visibidad; 
    //El Proveedor que creo el Item
    private Proveedor proveedor;
    //Identificador unico
    private int id;
    // URL de la imagen en este caso seria una ruta local
    private String imagen;
    /**
     * Constructor con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param fechaCreacion
     * @param visibidad se puede ver por otros usuarios
     * @param proveedor creador del item
     * @param imagen URL de la imagen en este caso seria una ruta local
     * @param id identificador unico
     */
    public Item(String nombre, String descripcion, double precio, LocalDate fechaCreacion, boolean visibidad, Proveedor proveedor, int id, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaCreacion;
        this.visibidad = visibidad;
        this.proveedor = proveedor;
        this.id = id;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public boolean isVisibidad() {
        return visibidad;
    }

    public void setVisibidad(boolean visibidad) {
        this.visibidad = visibidad;
    }        

    public Proveedor getProveedor() {
        return proveedor;
    }

    public int getId() {
        return id;
    }
}
