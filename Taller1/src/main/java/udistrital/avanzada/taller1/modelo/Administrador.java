package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * author mauricio
 * date 23/09/2025
 * 
 * Clase que representa a un Administrador dentro del sistema.
 * 
 * La clase Administrador hereda de Persona e implementa la interfaz Publicador,
 * lo que le permite crear, eliminar y administrar publicaciones.
 * 
 * Se encarga exclusivamente de las publicaciones y la gestión administrativa del sistema.
 * 
 * ------------------------------------------------------------
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción de la modificación:
 *    Se añadió el método getRol() para identificar el rol del administrador
 *    dentro del sistema. Se mejoró la documentación de la clase y métodos.
 * ------------------------------------------------------------
 */
public class Administrador extends Persona implements Publicador {

    /** Lista de publicaciones realizadas por el administrador */
    private ArrayList<Publicacion> posts;

    /**
     * Constructor por defecto de la clase Administrador.
     * Inicializa la lista de publicaciones vacía.
     */
    public Administrador() {
        this.posts = new ArrayList<Publicacion>();
    }

    /**
     * Constructor que permite crear un administrador con datos específicos.
     * 
     * @param nombre nombre del administrador
     * @param apellido apellido del administrador
     * @param cedula número de identificación
     * @param numero número de contacto
     * @param correo correo electrónico
     * @param membresia membresía dentro de la asociación
     * @param contraseña clave de acceso al sistema
     */
    public Administrador(String nombre, String apellido, String cedula, String numero, String correo, 
                         String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        // Se instancia el grupo que almacenará las publicaciones del administrador
        this.posts = new ArrayList<Publicacion>();
    }

    /**
     * Método implementado de la interfaz Publicador.
     * Permite añadir una publicación a la lista del administrador.
     * 
     * @param post publicación a agregar
     */
    @Override
    public void addPost(Publicacion post) {
        this.posts.add(post);
    }

    /**
     * Método implementado de la interfaz Publicador.
     * Permite eliminar una publicación de la lista del administrador.
     * 
     * @param post publicación a eliminar
     */
    @Override
    public void delPost(Publicacion post) {
        this.posts.remove(post);
    }

    /**
     * Método implementado de la interfaz Publicador.
     * Devuelve la lista de publicaciones realizadas por el administrador.
     * 
     * @return lista de publicaciones
     */
    @Override
    public ArrayList<Publicacion> getPosts() {
        return posts;
    }

    /**
     * Método que devuelve el rol del usuario dentro del sistema.
     * 
     * @return una cadena que identifica el rol del usuario como "Administrador"
     */
    @Override
    public String getRol() {
        return "Administrador";
    }
}
