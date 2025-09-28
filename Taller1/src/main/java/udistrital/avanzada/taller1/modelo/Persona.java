package udistrital.avanzada.taller1.modelo;

/**
 * Clase abstracta que representa a una persona dentro del sistema.
 * 
 * Esta clase es la superclase de Usuario, Proveedor y Administrador,
 * siguiendo el principio de sustitución de Liskov (LSP) dentro del 
 * modelo de herencia.
 * 
 * Proporciona atributos y métodos comunes a todas las personas,
 * así como operaciones generales como autenticación y representación textual.
 * 
 * author mauricio
 * version 1.1
 * date 23/09/2025
 * 
 * @modified Diego
 * @modificationDate 27/09/2025
 * Se agregaron métodos para:
 * - obtener el rol de la persona (getRol)
 * - sobrescribir toString() para una descripción legible
 * - mejorar documentación y cumplir con SOLID
 */
public abstract class Persona {
    
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String numero;
    protected String correo;
    
    /** Membresía o tipo de afiliación */
    protected String membresia;
    protected String contraseña;
    
    public Persona() {
    }

    /**
     * Constructor completo de la clase Persona.
     *
     * @param nombre      Nombre de la persona
     * @param apellido    Apellido de la persona
     * @param cedula      Documento de identidad
     * @param numero      Número de teléfono
     * @param correo      Correo electrónico
     * @param membresia   Tipo de membresía o afiliación
     * @param contraseña  Contraseña de acceso
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

    /**
     * Método abstracto que devuelve el rol del tipo de persona.
     * 
     * Cada subclase (Usuario, Proveedor, Administrador) deberá implementar este método.
     * 
     * @return Rol de la persona (ejemplo: "Usuario", "Proveedor", "Administrador")
     */
    public abstract String getRol();

    /**
     * Retorna una representación legible de la persona.
     * No muestra la contraseña para proteger la privacidad.
     * 
     * @return Cadena con nombre completo, cédula, teléfono, correo y membresía
     */
    @Override
    public String toString() {
        return nombre + " " + apellido +
               " | Cédula: " + cedula +
               " | Teléfono: " + numero +
               " | Correo: " + correo +
               " | Membresía: " + membresia;
    }
}
