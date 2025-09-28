package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 * Controlador encargado de gestionar todas las operaciones
 * relacionadas con los usuarios dentro del sistema.
 * <p>
 * Este incluye la gestión de amigos, vehículos y consultas
 * de información de proveedores y servicios disponibles.
 * </p>
 * 
 * author diego
 * version 1.0
 * date 27/09/2025
 */
public class ControlUsuario {

    // Lista de usuarios registrados en el sistema
    private ArrayList<Usuario> usuarios;

    // Constructor: inicializa la lista de usuarios
    public ControlUsuario() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Agrega un usuario a la lista de usuarios registrados.
     * 
     * @param usuario Objeto Usuario a registrar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Busca un usuario por su cédula.
     * 
     * @param cedula Cédula del usuario a buscar
     * @return Usuario si se encuentra, null si no existe
     */
    public Usuario buscarUsuarioPorCedula(String cedula) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equals(cedula)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Permite agregar un amigo a la lista de amigos del usuario.
     * Solo se agregará si el amigo existe en el sistema y no está duplicado.
     * 
     * @param usuario Usuario que desea agregar el amigo
     * @param cedulaAmigo Cédula del amigo a agregar
     * @return true si se agregó exitosamente, false si no se encontró o ya existe
     */
    public boolean agregarAmigo(Usuario usuario, String cedulaAmigo) {
        Usuario amigo = buscarUsuarioPorCedula(cedulaAmigo);
        if (amigo != null && !usuario.getAmigos().contains(amigo)) {
            usuario.addAmigo(amigo);
            return true;
        }
        return false;
    }

    /**
     * Permite eliminar un amigo de la lista de amigos del usuario.
     * 
     * @param usuario Usuario que desea eliminar al amigo
     * @param cedulaAmigo Cédula del amigo a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    public boolean eliminarAmigo(Usuario usuario, String cedulaAmigo) {
        Usuario amigo = buscarUsuarioPorCedula(cedulaAmigo);
        if (amigo != null && usuario.getAmigos().contains(amigo)) {
            usuario.delAmigo(amigo);
            return true;
        }
        return false;
    }

    /**
     * Permite agregar un vehículo al usuario.
     * 
     * @param usuario Usuario propietario del vehículo
     * @param vehiculo Vehículo a agregar
     */
    public void agregarVehiculo(Usuario usuario, Vehiculo vehiculo) {
        usuario.addVehiculo(vehiculo);
    }

    /**
     * Permite eliminar un vehículo del usuario.
     * 
     * @param usuario Usuario propietario del vehículo
     * @param vehiculo Vehículo a eliminar
     */
    public void eliminarVehiculo(Usuario usuario, Vehiculo vehiculo) {
        usuario.delVehiculo(vehiculo);
    }

    /**
     * Retorna la lista de usuarios registrados en el sistema.
     * 
     * @return Lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public ArrayList<Vehiculo> getVehiculos(Usuario usuario) {        
        return usuario.getVehiculos();
    }
}
