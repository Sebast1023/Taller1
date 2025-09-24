/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Usuario extends Persona{
    private ArrayList<Persona> amigos;

    public Usuario() {
        this.amigos = new ArrayList<>();
    }
    
    public Usuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        this.amigos = new ArrayList<>();
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);        
    }
}
