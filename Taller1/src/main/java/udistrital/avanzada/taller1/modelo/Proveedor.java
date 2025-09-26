package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * @author mauricio
 * 23/9/2025
 * Super clase de Proveedor tipo insumo y tipo servicio
 */
public abstract class Proveedor extends Persona implements Publicador{
    // nombre de la empresa
    protected String empresa;
    // numero de identificacion tributaria
    protected int nit;
    private ArrayList<Publicacion> posts;
    
    public Proveedor(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, int nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        this.empresa = empresa;
        this.nit = nit;
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
     * método que retorna las publicaciones del proveedor
     * @return  lista de objetos tipo Publicacion
     */
    @Override
    public ArrayList<Publicacion> getPosts() {
        return posts;
    }
}
