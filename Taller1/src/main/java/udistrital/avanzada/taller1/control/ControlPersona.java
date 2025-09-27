package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;

/**
 * Controlador encargado de manejar las operaciones generales
 * relacionadas con las personas dentro del sistema (usuarios,
 * proveedores, administradores).
 * 
 * Su responsabilidad principal es validar inicios de sesión y 
 * almacenar las personas registradas.
 * 
 * @author mauricio
 * @version 1.0
 * @date 25/09/2025
 */

/* Fecha de Modificacion: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción de la modificación:
 *    - Se añadió validación en validarInicioSesion() para impedir el acceso
 *      a usuarios que no hayan sido aprobados por un administrador.
 *    - Se agregó el método buscarPersonaPorCedula(int) para facilitar búsquedas.
 *    - Se añadió el método getPersonas() para exponer la lista interna de personas.
 *    - Se clarificó la responsabilidad de ControlPersona: ahora sólo gestiona
 *      personas y autenticación; la creación/registro de proveedores y la gestión
 *      administrativa quedan en ControlAdministrador (separación de responsabilidades).
 */
public class ControlPersona {
    
    // Lista general de personas registradas en el sistema
    private ArrayList<Persona> personas;

    // Constructor: inicializa la lista de personas
    public ControlPersona() {        
        this.personas = new ArrayList<>();
    }

    /**
     * Valida el inicio de sesión de una persona en el sistema.
     * Si las credenciales son correctas y el usuario está aprobado,
     * devuelve el objeto Persona correspondiente.
     * 
     * @param cedula     Cédula del usuario
     * @param contrasena Contraseña del usuario
     * @return Persona si las credenciales son válidas, null en caso contrario
     */
    public Persona validarInicioSesion(String cedula, String contrasena) {
        for (Persona p : personas) {
            if (p.getCedula().equals(cedula) && p.getContraseña().equals(contrasena)) {

                // Si es usuario, validamos si fue aprobado
                if (p instanceof Usuario u) {
                    if (!u.isAprobado()) {
                        System.out.println("El usuario aún no ha sido aprobado por un administrador.");
                        return null;
                    }
                }
                return p; // Login exitoso
            }
        }
        return null; // No coincide
    }

    /**
     * Crea una persona tipo Usuario (pendiente de aprobación).
     * 
     * @param cedula     Cédula del usuario
     * @param nombre     Nombre del usuario
     * @param apellido   Apellido del usuario
     * @param telefono   Teléfono de contacto
     * @param correo     Correo electrónico
     * @param membresia  Membresia del usuario 
     * @param contraseña   Contraseña de acceso
     */
    public void crearPersonaUsuario(String cedula, String nombre, String apellido, String telefono, String correo, String membresia, String contraseña) {
        Usuario usuario = new Usuario(cedula, nombre, apellido, telefono, correo, membresia, contraseña);
        personas.add(usuario);
    }

    /**
     * Retorna la lista de todas las personas registradas.
     * 
     * @return Lista de personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * Busca una persona por su cédula.
     * 
     * @param cedula Cédula de la persona a buscar
     * @return Persona si existe, null si no se encuentra
     */
    public Persona buscarPersonaPorCedula(String cedula) {
        for (Persona p : personas) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }
}

