package udistrital.avanzada.taller1.modelo;

/**
 * @author mauricio
 * 23/9/2025
 * La clase es para que tanto Administrador como Proveedor publiquen post de eventos
 * o promociones
 */
public class Publicacion {
    String titulo;
    String Contenido;    
    int likes;

    public Publicacion() {
        this.likes = 0;
    }
    
    public Publicacion(String descripocion, String titulo) {
        this.titulo = titulo;
        this.Contenido = descripocion;
        this.likes = 0;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    
}
