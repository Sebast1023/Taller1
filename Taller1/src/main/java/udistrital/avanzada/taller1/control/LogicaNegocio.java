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
 * @version 1.6
 * @date 27/09/2025
 */

/* 
 * ------------------------------------------------------------
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001-006
 * Descripción:
 *    - 001: Se añadió validación de mensajes claros en login.
 *    - 002: Se creó administrador predeterminado.
 *    - 003: Se ajustó constructor del admin “quemado”.
 *    - 004: Se centralizó la gestión de mensajes de login con getUltimoMensajeLogin().
 *    - 005: Se agregó atributo ultimoMensajeLogin para almacenar el mensaje.
 *    - 006: Mejor documentación de métodos y flujo de aprobación de usuarios.
 * ------------------------------------------------------------
 */
public class LogicaNegocio {

    private ControlVentana gVentana;
    private ControlPersona controlPersona;
    private ControlAdministrador controlAdministrador;

    // Mensaje del último intento de login (para mostrar en la vista)
    private String ultimoMensajeLogin;

    public LogicaNegocio() {
        controlPersona = new ControlPersona();
        controlAdministrador = new ControlAdministrador();
        gVentana = new ControlVentana(this);

        crearAdministradorPorDefecto();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    public void crearUsuario(String nombre, String apellido, String cedula, String numero,
            String correo, String membresia, String contraseña) {
        controlPersona.crearPersonaUsuario(cedula, nombre, apellido, numero, correo, membresia, contraseña);
        ultimoMensajeLogin = "Registro exitoso. Espere la aprobación del administrador.";
    }

    /**
     * Valida el inicio de sesión de una persona.
     *
     * @param cedula Cédula del usuario
     * @param contraseña Contraseña del usuario
     * @return Persona si las credenciales son válidas y aprobadas, null si no
     */
    public Persona login(String cedula, String contraseña) {
        Persona persona = controlPersona.validarInicioSesion(cedula, contraseña);

        if (persona == null) {
            ultimoMensajeLogin = "Usuario o contraseña incorrectos.";
            return null;
        }

        if (persona instanceof Usuario usuario) {
            if (!usuario.isAprobado()) {
                ultimoMensajeLogin = "Tu cuenta aún no ha sido aprobada por el administrador.";
                return null;
            }
        }

        // Login exitoso
        ultimoMensajeLogin = null;
        return persona;
    }

    /**
     * Devuelve el mensaje del último intento de login.
     *
     * @return mensaje de error o null si login fue exitoso
     */
    public String getUltimoMensajeLogin() {
        return ultimoMensajeLogin;
    }

    /**
     * Crea un administrador predeterminado "quemado" si no existe.
     */
    private void crearAdministradorPorDefecto() {
        String nombre = "Admin";
        String apellido = "General";
        String cedula = "0001";
        String numero = "123456789";
        String correo = "admin@correo.com";
        String membresia = "Activa";
        String contraseña = "admin123";

        Administrador existente = controlAdministrador.buscarAdministrador(cedula);
        if (existente == null) {
            Administrador admin = new Administrador(nombre, apellido, cedula, numero, correo, membresia, contraseña);
            controlAdministrador.agregarAdministrador(admin);
            controlPersona.getPersonas().add(admin);

            System.out.println("✅ Administrador predeterminado creado correctamente.");
            System.out.println("   Cédula: " + cedula + " | Contraseña: " + contraseña);
        } else {
            System.out.println("ℹ️ El administrador predeterminado ya existe.");
        }
    }
}


