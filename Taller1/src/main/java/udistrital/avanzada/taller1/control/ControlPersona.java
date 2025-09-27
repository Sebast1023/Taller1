package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

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
 *    - Se agregó el método buscarPersonaPorCedula(String) para facilitar búsquedas.
 *    - Se añadió el método getPersonas() para exponer la lista interna de personas.
 *    - Se clarificó la responsabilidad de ControlPersona: ahora sólo gestiona
 *      personas y autenticación; la gestión administrativa queda separada.
 */

/* Fecha de Modificacion: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 002
 * Descripción de la modificación:
 *    - Se trasladó la validación de aprobación de usuario desde ControlPersona hacia LogicaNegocio.
 *       Ahora ControlPersona solo se encarga de verificar credenciales,
 *       mientras que LogicaNegocio valida el estado de aprobación del usuario.
 */
public class ControlPersona {
    
    // Lista general de personas registradas en el sistema
    private ArrayList<Persona> personas;

    // Constructor: inicializa la lista de personas
    public ControlPersona() {        
        this.personas = new ArrayList<>();
    }

 /**
 * Valida las credenciales de inicio de sesión de una persona.
 * <p>
 * Este método solo verifica que la cédula y la contraseña coincidan con una persona registrada.
 * La validación de aprobación (en caso de los usuarios) se realiza en {@link LogicaNegocio}.
 * </p>
 * 
 * @param cedula Cédula de la persona
 * @param contrasena Contraseña ingresada
 * @return La persona encontrada si las credenciales son válidas, 
 *         o {@code null} si no se encuentra coincidencia.
 */

    public Persona validarInicioSesion(String cedula, String contrasena) {
    for (Persona p : personas) {
        if (p.getCedula().equals(cedula) && p.getContraseña().equals(contrasena)) {
            return p; // Login Exitoso
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
        Usuario usuario = new Usuario(nombre, apellido, cedula, telefono, correo, membresia, contraseña);
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

