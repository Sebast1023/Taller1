package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * @author mauricio
 * 25/9/2025
 * La interfaz Publicador es para que class que puedan hacer post tengan metodos
 * comunes para agregar y quitar post de sus propia lista local de objetos de
 * tipo Publicacion
 */
public interface Publicador {
    public void addPost(Publicacion post);
    public void delPost(Publicacion post);
    public ArrayList<Publicacion> getPosts();
}
