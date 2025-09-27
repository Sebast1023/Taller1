/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Administrador;
import udistrital.avanzada.taller1.modelo.Item;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.ProveedorInsumos;
import udistrital.avanzada.taller1.modelo.ProveedorServicios;
import udistrital.avanzada.taller1.modelo.Publicacion;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 *
 * @author mauricio
 * 25/09/2025
 */
public class ControlPersona {
    private ArrayList<Persona> personas;
    private ServicioUsuario servicioUsuario;
    private ServicioPublicador servicioPublicador;
    private ServicioProveedor servicioProveedor;
    //Constructor
    public ControlPersona() {        
        // se instancia el grupo que tendra las personas
        this.personas = new ArrayList<Persona>();        
        this.servicioUsuario = new ServicioUsuario();
        this.servicioPublicador = new ServicioPublicador();
        this.servicioProveedor = new ServicioProveedor();
    }
    
    /**
     * metodo para obtener una persona por la cedula
     * @param cedula
     * @return persona si es que la encontro de lo contrario null
     */
    public Persona getPersona(String cedula){
        // inicializamos la variable a null
        Persona aux = null;
        // Iterramos y buscamos en la lista
        for (Persona persona : personas) {
            // si la cedula es igual entonces se guarda la referencia en
            // la variable
            if(persona.getCedula().equalsIgnoreCase(cedula)){
                aux = persona;
                break;
            }
        }
        return aux;
    }
    /**
     * metodo para crear una Persona tipo Usuario
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña 
     */
    public void crearPersonaUsuario(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña){
        //si ya existe la persona salir de la funcion
        if(!(getPersona(cedula)== null)){return;} 
        Persona usuario = new Usuario(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        personas.add(usuario);
    }
    /**
     * metodo para crear una persona tipo Administrador
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña 
     */
    public void crearPersonaAdministrador(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña){
        //si ya existe la persona salir de la funcion
        if(!(getPersona(cedula)== null)){return;} 
        Persona administrador = new Administrador(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        personas.add(administrador);
    }
    /**
     * metodo para crear proveedor insumos
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña
     * @param empresa
     * @param nit 
     */
    public void crearPersonaProveedorInsumos(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, int nit){
        //si ya existe la persona salir de la funcion
        if(!(getPersona(cedula)== null)){return;} 
        Persona proveedorInsumos = new ProveedorInsumos(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        personas.add(proveedorInsumos);
    }
    /**
     * metodo para creear un proveedor de tipo servicios
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo
     * @param membresia
     * @param contraseña
     * @param empresa
     * @param nit 
     */
    public void crearPersonaProveedorServicios(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, int nit){
        //si ya existe la persona salir de la funcion
        if(!(getPersona(cedula)== null)){return;} 
        Persona proveedorServicios = new ProveedorServicios(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        personas.add(proveedorServicios);
    }
    /**
     * metodo para agregar publicacion a lista de publicaciones que tienen
     * las clases Adminstrador y Proveedor
     * @param publicacion
     * @param publicador 
     */
    public void agregarPublicacion(Publicacion publicacion, Persona publicador){
        servicioPublicador.agregarPublicacion(publicacion, publicador);
    }
    /**
     * metodo para eliminar publicacion a lista de publicaciones que tienen
     * las clases Administrador y Proveedor
     * @param publicacion
     * @param publicador 
     */
    public void eliminarPublicacion(Publicacion publicacion, Persona publicador){
        servicioPublicador.eliminarPublicacion(publicacion, publicador);
    }
    /**
     * medoto para agregar un Item a un proveedor
     * @param item
     * @param creador 
     */
    public void agregarItem(Item item, Persona creador){ 
        servicioProveedor.agregarItem(item, creador);
    }
    /**
     * medoto para eliminar un Item a un proveedor
     * @param item
     * @param creador 
     */
    public void eliminarItem(Item item, Persona creador){ 
        servicioProveedor.eliminarItem(item, creador);
    }  
    /**
     * metodo para agregar un vehiculo a lista de vehiculos de una persona tipo Usuario
     * @param vehiculo
     * @param persona 
     */
    public void agregarVehiculo(Vehiculo vehiculo, Persona persona){ 
        servicioUsuario.agregarVehiculo(vehiculo, persona);
    }
    /**
     * metodo para eliminar un vehiculo a lista de vehiculos de una persona tipo Usuario
     * @param vehiculo
     * @param persona 
     */
    public void eliminarVehiculo(Vehiculo vehiculo, Persona persona){ 
        servicioUsuario.eliminarVehiculo(vehiculo, persona);
    }
    /**
     * metodo para agregar un amigo a lista de amigos de una persona tipo Usuario
     * @param amigo
     * @param persona 
     */
    public void agregarAmigo(Persona amigo, Persona persona){ 
        servicioUsuario.agregarAmigo(amigo, persona);
    }
    /**
     * metodo para eliminar un amigo a lista de amigos de una persona tipo Usuario
     * @param amigo
     * @param persona 
     */
    public void eliminarAmigo(Persona amigo, Persona persona){ 
        servicioUsuario.eliminarAmigo(amigo, persona);
    }
    
}
