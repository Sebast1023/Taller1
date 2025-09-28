/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.modelo.Administrador;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Proveedor;
import udistrital.avanzada.taller1.modelo.Publicacion;

/**
 *
 * author mauri
 */
public class ServicioPublicador {
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
}
