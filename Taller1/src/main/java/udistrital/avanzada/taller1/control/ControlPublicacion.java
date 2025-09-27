package udistrital.avanzada.taller1.control;

import java.time.LocalDate;
import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Publicacion;
import udistrital.avanzada.taller1.modelo.Publicador;

/**
 * @author mauricio
 * 25/9/2025
 * Clase que maneja los objetos tipo Publicacion dentro del sistema
 */
public class ControlPublicacion {
    private ArrayList<Publicacion> publicaciones;
    private int contador;
    
    public ControlPublicacion() {
        this.publicaciones = new ArrayList<Publicacion>();
        this.contador = 0;
    }        
    /**
     * metodo para obtener una publicacion por su atributo id
     * @param id
     * @return objeto tipo publicacion si es encontrado caso contrario null
     */
    public Publicacion getPublicaion(int id){
        Publicacion post = null;
        for (Publicacion publicacion : publicaciones) {
            if(publicacion.getId() == id){
                post = publicacion;
            }
        }
        return post;
    }
    /**
     * crear publicacion con los siguientes parametros
     * @param descripcion
     * @param titulo
     * @param creador
     * @param imagen url en este caso ubicaion local de la imagen     
     */
    public void crearPublicacion(String descripcion, String titulo, Persona creador, String imagen){        
        // Persona no es un publicador entonces salir de la funcion
        if(!(creador instanceof Publicador)){
            return;
        }
        // para que cada publicacion tenga un identificado unico entonces 
        // se aumenta el contador en uno
        contador += 1;
        // crear publicacion
        Publicacion aux = new Publicacion(titulo, descripcion, imagen, creador, contador, imagen, LocalDate.now());        
        // Añadir a lista de publicaciones
        publicaciones.add(aux);
    }
    /**
     * metodo para editar una publicacion
     * @param titulo
     * @param descripcion
     * @param contenido
     * @param imagen
     * @param target id de la publicacion a editar
     */
    public void editarPublicacion(String titulo, String descripcion, String contenido, String imagen, int target){
        //buscar publicacion por el id
        Publicacion aux = getPublicaion(target);
        //no existe publicacion salir de la funcion
        if(aux == null){
            return;
        }
        // Actualizar atributos
        aux.setTitulo(titulo);
        aux.setDescripcion(descripcion);
        aux.setContenido(contenido);
        aux.setImagen(imagen);
        // actulizar fecha de modificacion
        aux.setFechaActualizacion(LocalDate.now());
    }
    /**
     * metodo para eliminar una publicacion de la lista con el id
     * @param target id de la publicacion
     */
    public void eliminarPublicacion(int target){
        Publicacion aux = getPublicaion(target);
        //no existe publicacion salir de la funcion
        if(aux == null){
            return;
        }
        publicaciones.remove(aux);
    }
    /**
     * metodo sobrecargado para eliminar una publicacion pasando
     * el objeto a eliminar
     * @param post 
     */
    public void eliminarPublicacion(Publicacion post){
        publicaciones.remove(post);
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
        
}
