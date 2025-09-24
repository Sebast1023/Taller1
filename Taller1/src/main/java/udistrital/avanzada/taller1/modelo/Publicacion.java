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
    Persona creador;

    public Publicacion() {
        this.likes = 0;
    }
    
    public Publicacion(String descripocion, String titulo, Persona creador) {
        this.titulo = titulo;
        this.Contenido = descripocion;
        this.likes = 0;
        this.creador = creador;
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

    public Persona getCreador() {
        return creador;
    }

    public void setCreador(Persona creador) {
        this.creador = creador;
    }
    
}
