package udistrital.avanzada.taller1.modelo;
/**
 * @author mauricio
 * 23/9/2025
 * la clase Persona es la superclase de las clases Usuario, Proveedor y
 * Administrador para la sustitucion de Liskov
 */
public abstract class Persona {
    protected String nombre;    
    protected String apellido;
    protected String cedula;
    protected String numero;
    protected String correo;
    protected String membresia;
    protected String contraseña;
    //contructor
    public Persona() {
    }
    /**
     * Constructor Persona con los siguientes parametros
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo 
     * @param membresia de la asociacion
     * @param contraseña
     */
    public Persona(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numero = numero;
        this.correo = correo;
        this.membresia = membresia;
        this.contraseña = contraseña;
    }
    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
