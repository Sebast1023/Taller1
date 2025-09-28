/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Insumo;
import udistrital.avanzada.taller1.modelo.Item;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Proveedor;
import udistrital.avanzada.taller1.modelo.ProveedorInsumos;
import udistrital.avanzada.taller1.modelo.ProveedorServicios;
import udistrital.avanzada.taller1.modelo.Servicio;

/**
 *
 * author mauri
 */
public class ServicioProveedor {
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
    /**
     * medoto para eliminar un Item a un proveedor
     * @param item
     * @param creador 
     */
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
}
