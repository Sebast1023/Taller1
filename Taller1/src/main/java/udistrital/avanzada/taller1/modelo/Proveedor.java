package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * author mauricio
 * 23/9/2025
 * Super clase de Proveedores tipo insumo y tipo servicio
 * Implementa la interfaz publicador para que los proveedore manejen
 * publicaciones
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
        // se instancia el grupo donde se guardan las publicaciones
        this.posts = new ArrayList<Publicacion>();
    }
    /**
    * método implementado la de la interfaz Publicador
    * para añadir publiccion a la lista de post
    * @param post
    */
    @Override
    public void addPost(Publicacion post) {
        this.posts.add(post);
    }
    /**
     * método implementado la de la interfaz Publicador
     * para eliminar publicacion de la lista de post
     * @param post 
     */
    @Override
    public void delPost(Publicacion post) {
        this.posts.remove(post);
    }
    /**
     * método implementado la de la interfaz Publicador
     * que retorna las publicaciones del proveedor
     * @return  lista de objetos tipo Publicacion
     */
    @Override
    public ArrayList<Publicacion> getPosts() {
        return posts;
    }
}
