package udistrital.avanzada.taller1.control;

import javax.swing.JOptionPane;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Administrador;

/**
 * Clase que centraliza la lógica de negocio del sistema.
 * <p>
 * Gestiona la comunicación entre la interfaz gráfica y los controladores de
 * datos (usuarios, administradores, proveedores, etc.).
 * </p>
 *
 * <p>
 * Se encarga de operaciones como registro de usuarios, validación de inicio de
 * sesión y creación de un administrador predeterminado.
 * </p>
 *
 * @author Diego
 * @version 1.5
 * @date 27/09/2025
 */

/* 
 * ------------------------------------------------------------
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción:
 *    - Se añadió la validación para mostrar mensajes claros al usuario
 *      cuando sus credenciales sean incorrectas o cuando no haya sido aprobado
 *      por un administrador.
 *    - Ahora esta clase se encarga de manejar todos los mensajes de inicio de sesión,
 *      para mantener la lógica centralizada y evitar duplicaciones en la interfaz.
 * 
 * Nro. Orden de Trabajo: 002
 * Descripción:
 *    - Se añadió la creación automática de un administrador predeterminado al iniciar el sistema.
 *      Este administrador sirve como cuenta principal para aprobar usuarios nuevos.
 * 
 * Nro. Orden de Trabajo: 003
 * Descripción:
 *    - Se ajustó la creación del administrador “quemado” para usar el constructor
 *      correcto de la clase Administrador (que requiere nombre, apellido, cédula,
 *      número, correo, membresía y contraseña).
 *    - Se mejoró la documentación del método crearAdministradorPorDefecto().
 * ------------------------------------------------------------
 */
public class LogicaNegocio {

    // Controlador principal de la interfaz gráfica
    private ControlVentana gVentana;

    // Controlador para la gestión de personas
    private ControlPersona controlPersona;

    // Controlador para la gestión de administradores 
    private ControlAdministrador controlAdministrador;

    /**
     * Constructor: inicializa los controladores de la aplicación.
     * <p>
     * Al iniciar, se crea un administrador "quemado" por defecto si no existe.
     * </p>
     */
    public LogicaNegocio() {
        controlPersona = new ControlPersona();
        controlAdministrador = new ControlAdministrador();
        gVentana = new ControlVentana(this);

        // Crear el administrador predeterminado
        crearAdministradorPorDefecto();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param cedula Cédula del usuario
     * @param numero Número de contacto
     * @param correo Correo electrónico
     * @param membresia Tipo de membresía
     * @param contraseña Contraseña de acceso
     */
    public void crearUsuario(String nombre, String apellido, String cedula, String numero,
            String correo, String membresia, String contraseña) {
        controlPersona.crearPersonaUsuario(cedula, nombre, apellido, numero, correo, membresia, contraseña);
    }

    /**
     * Valida el inicio de sesión de una persona en el sistema.
     * <p>
     * Verifica las credenciales y, en caso de que sea un usuario, comprueba si
     * ha sido aprobado por un administrador.
     * </p>
     *
     * @param cedula Cédula del usuario
     * @param contraseña Contraseña del usuario
     * @return Persona si las credenciales son válidas y aprobadas, null si no
     */
    public Persona login(String cedula, String contraseña) {
        Persona persona = controlPersona.validarInicioSesion(cedula, contraseña);

        // Si no existe o las credenciales son incorrectas
        if (persona == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Usuario o contraseña incorrectos.",
                    "Inicio de sesión",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        // Si es un usuario (no admin ni proveedor), validar aprobación
        if (persona instanceof Usuario usuario) {
            if (!usuario.isAprobado()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Tu cuenta aún no ha sido aprobada por el administrador.",
                        "Acceso denegado",
                        JOptionPane.WARNING_MESSAGE
                );
                return null;
            }
        }

        // Credenciales válidas y usuario aprobado
        return persona;
    }

    /**
     * Crea un administrador predeterminado "quemado" en el sistema, solo si no
     * existe uno con la misma cédula.
     * <p>
     * Este administrador se usa para aprobar usuarios desde el inicio del
     * sistema.
     * </p>
     */
    private void crearAdministradorPorDefecto() {
        String nombre = "Admin";
        String apellido = "General";
        String cedula = "0001"; // Identificador de login
        String numero = "123456789";
        String correo = "admin@correo.com";
        String membresia = "Activa";
        String contraseña = "admin123";

        // Verifica si ya existe un administrador con esa cédula
        Administrador existente = controlAdministrador.buscarAdministrador(cedula);
        if (existente == null) {
            Administrador admin = new Administrador(
                    nombre,
                    apellido,
                    cedula,
                    numero,
                    correo,
                    membresia,
                    contraseña
            );

            // Lo agrega a la lista de administradores
            controlAdministrador.agregarAdministrador(admin);

            // También lo agrega al controlador de personas (para el login)
            controlPersona.getPersonas().add(admin);

            System.out.println("✅ Administrador predeterminado creado correctamente.");
            System.out.println("   Cédula: " + cedula + " | Contraseña: " + contraseña);
        } else {
            System.out.println("ℹ️ El administrador predeterminado ya existe.");
        }
    }

}
