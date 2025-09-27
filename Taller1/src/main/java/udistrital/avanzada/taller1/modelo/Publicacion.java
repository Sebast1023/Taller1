package udistrital.avanzada.taller1.modelo;

import java.time.LocalDate;

/**
 * @author mauricio
 * 23/9/2025
 * La clase es para que tanto Administrador como Proveedor publiquen post 
 * de eventos, promociones u otros
 */
public class Publicacion {
    private String titulo;
    private String contenido;
    private String descripcion;
    private Persona creador;
    private String imagen;
    protected LocalDate fechaCreacion;
    protected LocalDate fechaActualizacion;
    private int id;   
    /**
     * Constructor con los siguientes parametros
     * @param titulo
     * @param descripcion
     * @param contenido     
     * @param creador
     * @param id 
     * @param imagen
     * @param fechaCreacion 
     */
    public Publicacion(String titulo, String descripcion, String contenido, Persona creador, int id, String imagen, LocalDate fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.creador = creador;
        this.id = id;
        this.imagen = imagen;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaCreacion;        
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String Contenido) {
        this.contenido = Contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getCreador() {
        return creador;
    }

    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
        
}
