package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Persona;

/**
 * Clase que centraliza la lógica de negocio del sistema.
 * <p>
 * Gestiona la comunicación entre la interfaz gráfica 
 * y los controladores de datos (usuarios, administradores, proveedores, etc.).
 * </p>
 * 
 * <p>
 * Se encarga de operaciones como registro de usuarios
 * y validación de inicio de sesión.
 * </p>
 * 
 * @author diego
 * @version 1.1
 * @date 27/09/2025
 */
public class LogicaNegocio {
    
    /** Controlador de la ventana principal de la interfaz */
    private ControlVentana gVentana;
    
    /** Controlador para la gestión de personas */
    private ControlPersona controlPersona;
    
    /**
     * Constructor: inicializa los controladores de la aplicación
     */
    public LogicaNegocio() {
        controlPersona = new ControlPersona();
        gVentana = new ControlVentana(this);
    }
    
    /**
     * Registra un nuevo usuario en el sistema.
     * <p>
     * Este método delega la creación del usuario al 
     * {@link ControlPersona}.
     * </p>
     * 
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param cedula Cédula del usuario
     * @param numero Número de contacto
     * @param correo Correo electrónico
     * @param membresia Tipo de membresía
     * @param contraseña Contraseña de acceso
     */
    public void crearUsuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña){
        controlPersona.crearPersonaUsuario(cedula, nombre, apellido, numero, correo,membresia, contraseña);
    }
    
    /**
     * Valida el inicio de sesión de una persona en el sistema.
     * <p>
     * Llama al método {@link ControlPersona#validarInicioSesion(int, String)}
     * para verificar las credenciales.
     * </p>
     * 
     * @param cedula Cédula del usuario
     * @param contraseña Contraseña del usuario
     * @return Persona si las credenciales son válidas, null si no
     */
    public Persona login(String cedula, String contraseña){
        return controlPersona.validarInicioSesion(cedula, contraseña);
    }
}
