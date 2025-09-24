package udistrital.avanzada.taller1.modelo;
import java.util.ArrayList;
/**
 * @author mauricio
 * 23/9/2025
 * Clase que administra todo sobre los usuarios
 */
public class Administrador extends Persona {
    private ArrayList<Publicacion> posts;

    public Administrador() {
        this.posts = new ArrayList<Publicacion>();
    }

    public Administrador(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        this.posts = new ArrayList<Publicacion>();
    }
    
     /**
 * método para añadir post a la lista de post
 * @param post
 */
    public void addPost(Publicacion post) {
        this.posts.add(post);
    }
/**
 * método para eliminar amigo a la lista de amigos
 * @param post 
 */
    public void delPost(Publicacion post) {
        this.posts.remove(post);
    }
}
