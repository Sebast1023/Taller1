/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Administrador;
import udistrital.avanzada.taller1.modelo.Insumo;
import udistrital.avanzada.taller1.modelo.Item;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Proveedor;
import udistrital.avanzada.taller1.modelo.ProveedorInsumos;
import udistrital.avanzada.taller1.modelo.ProveedorServicios;
import udistrital.avanzada.taller1.modelo.Publicacion;
import udistrital.avanzada.taller1.modelo.Servicio;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 *
 * @author mauricio
 * 25/09/2025
 */
public class ControlPersona {
    private ArrayList<Persona> personas;
    //Constructor
    public ControlPersona() {        
        // se instancia el grupo que tendra las personas
        this.personas = new ArrayList<Persona>();        
    }
    public void personaExiste(){
    
    }
    public Persona getPersona(String cedula){
        Persona aux = null;
        for (Persona persona : personas) {
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
        // Confirmamos que sea un administrador
        if(publicador instanceof Administrador){
            // pasada la confirmacion hacemos casting y agregamos la publicacion
            // a las lista local de Administrador
            ((Administrador) publicador).addPost(publicacion);
        }else if (publicador instanceof Proveedor){
            // pasada la confirmacion hacemos casting y agregamos la publicacion
            // a las lista local de Proveedor
            ((Proveedor) publicador).addPost(publicacion);
        }
    }
    /**
     * metodo para eliminar publicacion a lista de publicaciones que tienen
     * las clases Administrador y Proveedor
     * @param publicacion
     * @param publicador 
     */
    public void eliminarPublicacion(Publicacion publicacion, Persona publicador){
        // Confirmamos que sea un administrador
        if(publicador instanceof Administrador){
            // pasada la confirmacion hacemos casting y eliminamos la publicacion
            // a las lista local de Administrador
            ((Administrador) publicador).delPost(publicacion);
        }else if (publicador instanceof Proveedor){
            // pasada la confirmacion hacemos casting y eliminamos la publicacion
            // a las lista local de Administrador
            ((Proveedor) publicador).delPost(publicacion);
        }
    }
    
    public void agregarItem(Item item, Persona creador){ 
        //si no es proveedor salir de la funcion
        if (!(creador instanceof Proveedor)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        if (item instanceof Servicio && creador instanceof ProveedorServicios){            
            // pasada la confirmacion hacemos casting y agregamos el item
            // a la lista de servicios del ProveedorServicios
            ((ProveedorServicios) creador).addServicio((Servicio) item);
        }
        // Si no confirmamos el tipo del item y proveedor sean de apellido Insumo
        else if (item instanceof Insumo && creador instanceof ProveedorServicios){
            // pasada la confirmacion hacemos casting y agregamos el item
            // a la lista de insumos del ProveedorInsumos
            ((ProveedorInsumos) creador).addInsumo((Insumo) item);
        }        
    }
    
    public void eliminarItem(Item item, Persona creador){ 
        //si no es proveedor salir de la funcion
        if (!(creador instanceof Proveedor)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        if (item instanceof Servicio && creador instanceof ProveedorServicios){            
            // pasada la confirmacion hacemos casting y agregamos el item
            // a la lista de servicios del ProveedorServicios
            ((ProveedorServicios) creador).addServicio((Servicio) item);
        }
        else if (item instanceof Insumo && creador instanceof ProveedorServicios){
            // pasada la confirmacion hacemos casting y agregamos el item
            // a la lista de insumos del ProveedorInsumos
            ((ProveedorInsumos) creador).addInsumo((Insumo) item);
        }        
    }    
    public void agregarVehiculo(Vehiculo vehiculo, Persona persona){ 
        //si no es proveedor salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        ((Usuario)persona).addVehiculo(vehiculo);                
    }
    public void eliminarVehiculo(Vehiculo vehiculo, Persona persona){ 
        //si no es proveedor salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        ((Usuario)persona).delVehiculo(vehiculo);                
    }
    public void agregarAmigo(Persona amigo, Persona persona){ 
        //si no es proveedor salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        if (!(amigo instanceof Usuario)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        ((Usuario)persona).addAmigo((Usuario)amigo);                
    }
    public void eliminarAmigo(Vehiculo vehiculo, Persona persona){ 
        //si no es proveedor salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        ((Usuario)persona).delVehiculo(vehiculo);                
    }
            
}
