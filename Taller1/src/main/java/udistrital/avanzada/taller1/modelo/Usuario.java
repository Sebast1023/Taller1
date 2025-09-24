/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;
import java.util.ArrayList;

/**
 * @author mauricio
 * 23/9/2025
 * La clase Usuario es para clientes
 * Puede tener un lista de amigos cada uno del tipo Usuario
 */

public class Usuario extends Persona{
    private ArrayList<Usuario> amigos;
    // contructor
    public Usuario() {
        //Se instancia el grupo que almacenara los objetos
        this.amigos = new ArrayList<Usuario>();
    }
    
    public Usuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);        
        //Se instancia el grupo que almacenara los objetos
        this.amigos = new ArrayList<Usuario>();
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }
 /**
 * método para añadir amigo a la lista de amigos
 * @param amigo usuario a añadir a lista de amigos de tipo Usuario
 */
    public void addAmigo(Usuario amigo) {
        this.amigos.add(amigo);
    }
/**
 * método para eliminar amigo a la lista de amigos
 * @param amigo usuario a remover de la lista de tipo Usuario
 */
    public void delAmigo(Usuario amigo) {
        this.amigos.remove(amigo);
    }
}
