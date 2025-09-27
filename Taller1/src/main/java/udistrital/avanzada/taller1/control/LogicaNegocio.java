package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Persona;

public class LogicaNegocio {

    private ControlVentana gVentana;
    private ControlPersona controlPersona;
    private Persona usuarioActivo;

    public LogicaNegocio() {
        controlPersona = new ControlPersona();
        gVentana = new ControlVentana(this);
    }

    public void crearUsuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        controlPersona.crearPersonaAdministrador(nombre, apellido, cedula, numero, correo, membresia, contraseña);
    }

    public Persona login(String cedula, String contraseña) {
        Persona persona1 = controlPersona.validarIniciodeSesion(cedula, contraseña);
        if (persona1 != null) {
            usuarioActivo = persona1;   
        }
        return persona1;
    }

    public Persona getUsuarioActivo() {
        return usuarioActivo;
    }

}
