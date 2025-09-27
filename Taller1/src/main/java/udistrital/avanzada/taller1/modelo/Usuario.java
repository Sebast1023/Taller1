/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * @author mauricio 
 * 23/9/2025 
 * La clase Usuario es para clientes Puede tener un
 * lista de amigos cada uno del tipo Usuario y una lista de vehiculos
 */
public class Usuario extends Persona {

    private ArrayList<Usuario> amigos;
    private ArrayList<Vehiculo> vehiculos;
    // bandera para saber si el usuario esta activo o aprovado
    private boolean activo;

    /**
     * contructor con los siguientes parametros
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña 
     */

    public Usuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        //Se instancian los grupos que almacenaran los objetos respectivos
        this.amigos = new ArrayList<Usuario>();
        this.vehiculos = new ArrayList<Vehiculo>();
        this.activo = false;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * método para añadir amigo a la lista de amigos
     *
     * @param amigo usuario a añadir a lista de amigos de tipo Usuario
     */
    public void addAmigo(Usuario amigo) {
        this.amigos.add(amigo);
    }

    /**
     * método para eliminar amigo a la lista de amigos
     *
     * @param amigo usuario a remover de la lista de tipo Usuario
     */
    public void delAmigo(Usuario amigo) {
        this.amigos.remove(amigo);
    }
    
    /**
     * método para añadir vehiculo a la lista de vehiculos
     *
     * @param vehiculo vehiculo a añadir a lista
     */
    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    /**
     * método para eliminar vehiculo a la lista de vehiculos
     *
     * @param vehiculo vehiculo a remover de la lista
     */
    public void delVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
