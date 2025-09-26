/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Publicacion;

/**
 * @author mauricio
 * 25/9/2025
 */
public class ControlPublicacion {
    private ArrayList<Publicacion> publicaciones;
    private int id;

    public ControlPublicacion() {
        this.publicaciones = new ArrayList<Publicacion>();
        this.id = 0;
    }        
    
    public Publicacion crearPublicacion(String descripcion, String titulo, Persona creador, String imagen){
        id += 1;
        Publicacion aux = new Publicacion(titulo, descripcion, imagen, creador, id, imagen);
        publicaciones.add(aux);
        return aux;
    }
    
    public void editarPublicacion(String titulo, String descripcion, String contenido, String imagen, int target){
        Publicacion aux = null;
        for (Publicacion post : publicaciones) {
            if (post.getId() == target) {
                aux = post;
                break;
            }
        }
        // salir de la funcion si no se encontro la publicacion
        if(aux == null){return;}
        // Actualizar atributos
        aux.setTitulo(titulo);
        aux.setDescripcion(descripcion);
        aux.setContenido(contenido);
        aux.setImagen(imagen);        
    }
    
    public void eliminarPublicacion(int target){
        Publicacion aux;
        for (Publicacion post : publicaciones) {
            if (post.getId() == target) {
                aux = post;
                publicaciones.remove(aux);
                break;
            }
        }        
    }
    
}
