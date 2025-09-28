package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Administrador;
import udistrital.avanzada.taller1.modelo.ProveedorInsumos;
import udistrital.avanzada.taller1.modelo.ProveedorServicios;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Publicacion;

/**
 * Controlador encargado de manejar las operaciones relacionadas con los administradores
 * dentro del sistema.
 * <p>
 * Permite agregar nuevos administradores, buscar por cédula, eliminar y listar todos
 * los administradores registrados. También permite registrar proveedores y validar usuarios.
 * </p>
 * 
 * author Diego
 * version 1.0
 * date 27/09/2025
 */
public class ControlAdministrador {

    // Lista de administradores registrados en el sistema
    private ArrayList<Administrador> administradores;

    // Constructor: inicializa la lista de administradores
    public ControlAdministrador() {
        this.administradores = new ArrayList<>();
    }

    // CRUD de Administradores
    
    /**
    * Agrega un nuevo administrador a la lista de administradores registrados.
    * 
    * @param admin objeto Administrador a agregar
    */
    public void agregarAdministrador(Administrador admin) {
        administradores.add(admin);
    }
    
    /**
    * Busca un administrador por su cédula.
    * 
    * @param cedula cédula del administrador a buscar
    * @return Administrador si se encuentra, null en caso contrario
    */
    public Administrador buscarAdministrador(String cedula) {
        for (Administrador a : administradores) {
            if (a.getCedula().equals(cedula)) {
                return a;
            }
        }
        return null;
    }
    
    /**
    * Elimina un administrador de la lista según su cédula.
    * 
    * @param cedula cédula del administrador a eliminar
    * @return true si se eliminó correctamente, false si no se encontró
    */
    public boolean eliminarAdministrador(String cedula) {
        Administrador admin = buscarAdministrador(cedula);
        if (admin != null) {
            administradores.remove(admin);
            return true;
        }
        return false;
    }
    
    /**
    * Retorna la lista de administradores registrados.
    * 
    * @return ArrayList de objetos Administrador
    */

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    /** Gestión de publicaciones */
    
    /**
    * Agrega una publicación al administrador indicado por su cédula.
    * 
    * @param publicacion objeto Publicacion a agregar
    * @param cedulaAdmin cédula del administrador que realiza la publicación
    */    
    public void agregarPublicacion(Publicacion publicacion, String cedulaAdmin) {
        Administrador admin = buscarAdministrador(cedulaAdmin);
        if (admin != null) {
            admin.addPost(publicacion);
        } else {
            System.out.println("Error: administrador no encontrado");
        }
    }
    
    /**
    * Elimina una publicación del administrador indicado por su cédula.
    * 
    * @param publicacion objeto Publicacion a eliminar
    * @param cedulaAdmin cédula del administrador dueño de la publicación
    */
    public void eliminarPublicacion(Publicacion publicacion, String cedulaAdmin) {
        Administrador admin = buscarAdministrador(cedulaAdmin);
        if (admin != null) {
            admin.delPost(publicacion);
        } else {
            System.out.println("Error: administrador no encontrado");
        }
    }


    /**
     * Registra un proveedor de insumos
     * 
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña
     * @param empresa
     * @param nit
     * @return el proveedor creado
     */
    public ProveedorInsumos registrarProveedorInsumos(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, String nit) {
        ProveedorInsumos proveedor = new ProveedorInsumos(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, Integer.parseInt(nit));
        return proveedor;
    }

    /**
     * Registra un proveedor de servicios
     * 
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña
     * @param empresa
     * @param nit
     * @return el proveedor creado
     */
    public ProveedorServicios registrarProveedorServicios(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, String nit) {
        ProveedorServicios proveedor = new ProveedorServicios(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, Integer.parseInt(nit));
        return proveedor;
    }

    /**
     * Valida un usuario pendiente de aprobación
     * 
     * @param usuario objeto Usuario a validar
     */
    public void validarUsuario(Usuario usuario) {
        usuario.setAprobado(true);
    }
}

