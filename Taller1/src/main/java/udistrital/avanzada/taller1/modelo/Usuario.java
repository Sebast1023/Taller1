package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un Usuario dentro del sistema.
 * 
 * Un usuario es una persona registrada que puede tener una lista de amigos
 * (otros usuarios) y una lista de vehículos asociados. Los usuarios deben
 * ser aprobados por un administrador antes de poder acceder completamente
 * a las funcionalidades del sistema.
 * 
 * Cumple con el principio de sustitución de Liskov (LSP), ya que puede
 * ser tratado como una Persona en cualquier contexto.
 * 
 * @author mauricio
 * @version 1.1
 * @date 23/09/2025
 * 
 * 
 * @modifiedBy Diego – Se agregó el atributo aprobado, sus métodos,
 *                  y se mejoró la documentación de la clase.
 * @date 27/09/2025
 */
public class Usuario extends Persona {

    /** Lista de amigos del usuario (otros usuarios del sistema) */
    private ArrayList<Usuario> amigos;

    /** Lista de vehículos registrados por el usuario */
    private ArrayList<Vehiculo> vehiculos;

    /** Indica si el usuario fue aprobado por un administrador */
    private boolean aprobado;
    
    /**
     * Constructor por defecto.
     * Inicializa las listas de amigos y vehículos.
     */
    public Usuario() {
        this.amigos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.aprobado = false;
    }

    /**
     * Constructor completo con parámetros.
     * 
     * @param nombre     Nombre del usuario
     * @param apellido   Apellido del usuario
     * @param cedula     Cédula del usuario
     * @param numero     Número de contacto
     * @param correo     Correo electrónico
     * @param membresia  Tipo de membresía
     * @param contraseña Contraseña del usuario
     */
    public Usuario(String nombre, String apellido, String cedula, String numero, 
                   String correo, String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        this.amigos = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.aprobado = false;
    }

    /**
     * Indica si el usuario fue aprobado por un administrador.
     * 
     * @return true si el usuario fue aprobado, false en caso contrario.
     */
    public boolean isAprobado() {
        return aprobado;
    }

    /**
     * Establece el estado de aprobación del usuario.
     * 
     * @param aprobado true si fue aprobado, false si aún no lo ha sido.
     */
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    /**
     * Retorna el rol correspondiente al usuario dentro del sistema.
     * 
     * Este método permite identificar el tipo de persona que está
     * utilizando el sistema. En este caso, devuelve siempre "Usuario",
     * ya que pertenece a esta subclase.
     * 
     * @return Cadena de texto que indica el rol: "Usuario"
     */
    @Override
    public String getRol() {
        return "Usuario";
    }

    /**
     * Retorna la lista de amigos del usuario.
     * 
     * @return Lista de amigos
     */
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * Añade un amigo a la lista de amigos del usuario.
     *
     * @param amigo Usuario a añadir
     */
    public void addAmigo(Usuario amigo) {
        this.amigos.add(amigo);
    }

    /**
     * Elimina un amigo de la lista de amigos del usuario.
     *
     * @param amigo Usuario a eliminar
     */
    public void delAmigo(Usuario amigo) {
        this.amigos.remove(amigo);
    }

    // =====================
    // Métodos de vehículos
    // =====================

    /**
     * Retorna la lista de vehículos del usuario.
     * 
     * @return Lista de vehículos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Añade un vehículo a la lista de vehículos del usuario.
     *
     * @param vehiculo Vehículo a añadir
     */
    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    /**
     * Elimina un vehículo de la lista de vehículos del usuario.
     *
     * @param vehiculo Vehículo a eliminar
     */
    public void delVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }
}

