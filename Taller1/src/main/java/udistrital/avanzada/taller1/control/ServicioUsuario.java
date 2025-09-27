/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 *
 * @author mauri
 */
public class ServicioUsuario {
    /**
     * metodo para agregar un amigo a lista de amigos de una persona tipo Usuario
     * @param amigo
     * @param persona 
     */
    public void agregarAmigo(Persona amigo, Persona persona){ 
    // Confirmamos que ambos son tipo usuario        
    //si no es usuario salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        if (!(amigo instanceof Usuario)){return;}        
        //Pasada la comprobacion agregamos amigo a lista
        ((Usuario)persona).addAmigo((Usuario)amigo);                
    }
    /**
     * metodo para eliminar un amigo a lista de amigos de una persona tipo Usuario
     * @param amigo
     * @param persona 
     */
    public void eliminarAmigo(Persona amigo, Persona persona){ 
        // Confirmamos que ambos son tipo usuario        
        //si no es usuario salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        if (!(amigo instanceof Usuario)){return;}                
        //Pasada la comprobacion eliminamos amigo de la lista
        ((Usuario)persona).delAmigo((Usuario)amigo);                
    }
    /**
     * metodo para agregar un vehiculo a lista de vehiculos de una persona tipo Usuario
     * @param vehiculo
     * @param persona 
     */
    public void agregarVehiculo(Vehiculo vehiculo, Persona persona){ 
        //si no es proveedor salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        // Confirmamos el tipo del item y proveedor sean de apellido Servicio
        ((Usuario)persona).addVehiculo(vehiculo);                
    }
    /**
     * metodo para eliminar un vehiculo a lista de vehiculos de una persona tipo Usuario
     * @param vehiculo
     * @param persona 
     */
    public void eliminarVehiculo(Vehiculo vehiculo, Persona persona){ 
        //si no es usuario salir de la funcion
        if (!(persona instanceof Usuario)){return;}
        // Confirmamos el tipo de usuario y eliminamos vehiculo de la lista
        ((Usuario)persona).delVehiculo(vehiculo);
    }
    
    public void activarUsuario(Usuario usuario, boolean activo){
        usuario.setAprobado(activo);
    }
}
