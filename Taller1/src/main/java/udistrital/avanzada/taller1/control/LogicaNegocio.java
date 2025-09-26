package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Persona;

public class LogicaNegocio {
    
    private ControlVentana gVentana;
    private ControlPersona controlPersona;
    
    public LogicaNegocio() {
        controlPersona = new ControlPersona();
        gVentana = new ControlVentana(this);
    }
    
    public void crearUsuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña){
        controlPersona.crearPersonaAdministrador(nombre, apellido, cedula, numero, correo, membresia, contraseña);
    }
    
    public Persona login (String cedula, String contraseña){
        return controlPersona.validarIniciodeSesion(cedula, contraseña);
    }
    
}
