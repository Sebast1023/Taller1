package udistrital.avanzada.taller1.modelo;
import java.util.ArrayList;
/**
 * @author mauricio
 * 23/9/2025
 * Clase que administra todo sobre los usuarios
 */
public class Administrador extends Persona implements Publicador {
    private ArrayList<Publicacion> posts;
    // constructor
    public Administrador() {
        this.posts = new ArrayList<Publicacion>();
    }
    /**
     * Constructor Adminstrador con los siguiente parametros
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña 
     */
    public Administrador(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        // se instancia el grupo que almacena las publicaciones
        this.posts = new ArrayList<Publicacion>();
    }
    /**
    * método para añadir publiccion a la lista de post
    * @param post
    */
    @Override
    public void addPost(Publicacion post) {
        this.posts.add(post);
    }
    /**
     * método para eliminar publicacion de la lista de post
     * @param post 
     */
    @Override
    public void delPost(Publicacion post) {
        this.posts.remove(post);
    }
    /**
     * método que retorna las publicaciones del administrador
     * @return  lista de objetos tipo Publicacion
     */
    @Override
    public ArrayList<Publicacion> getPosts() {
        return posts;
    }
}
