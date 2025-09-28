/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.taller1.control;

import java.time.LocalDate;
import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Insumo;
import udistrital.avanzada.taller1.modelo.Item;
import udistrital.avanzada.taller1.modelo.Proveedor;
import udistrital.avanzada.taller1.modelo.Servicio;

/**
 *
 * author mauricio
 * Clase encarga del manejo de los objetos tipo Item
 */
public class ControlItem {
    private ArrayList<Item> items;
    private int contador;
    
    public ControlItem() {
        this.items = new ArrayList<Item>();
        this.contador = 0;
    }        
    /**
     * metodo para obtener un item por su atributo id
     * @param id
     * @return objeto tipo item si es encontrado caso contrario null
     */
    public Item getItem(int id){
        Item aux = null;
        for (Item item : items) {
            if(item.getId() == id){
                aux = item;
            }
        }
        return aux;
    }
    /**
     * metodo para crear item tipo servicio con los siguinetes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param visibidad
     * @param duracion
     * @param proveedor
     * @param imagen URL o en este caso ubicacion local
     */
    public void crearItemServicio(String nombre, String descripcion, double precio, boolean visibidad, int duracion, Proveedor proveedor,String imagen){               
        // para que cada publicacion tenga un identificado unico entonces 
        // se aumenta el contador en uno
        contador += 1;
        // crear publicacion
        Item aux = new Servicio(nombre, descripcion, precio, LocalDate.now(), visibidad, duracion, proveedor, contador, imagen);        
        // Añadir a lista de items
        items.add(aux);
    }
    /**
     * metodo para editar item tipo servicio con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param visibidad
     * @param duracion
     * @param proveedor
     * @param imagen
     * @param target 
     */
    public void editarItemServicio(String nombre, String descripcion, double precio, boolean visibidad, int duracion, Proveedor proveedor,String imagen, int target){        
        //buscar item por el id
        Item aux = getItem(target);
        //no existe item salir de la funcion
        if(aux == null){
            return;
        }
        // Actualizar atributos
        new ControlServicio().editarServicio((Servicio)aux, nombre, descripcion, precio, LocalDate.now(), visibidad, duracion, imagen);
          
    }
    /**
     * metodo para crear item tipo Insumo con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param visibidad
     * @param disponibidad
     * @param proveedor
     * @param imagen 
     */
    public void crearItemInsumo(String nombre, String descripcion, double precio, boolean visibidad, int disponibidad, Proveedor proveedor, String imagen){               
        // para que cada item tenga un identificado unico entonces 
        // se aumenta el contador en uno
        contador += 1;
        // crear Insumo
        Item aux = new Insumo(nombre, descripcion, precio, LocalDate.now(), visibidad, disponibidad, proveedor, contador, imagen);
        // Añadir a lista de items
        items.add(aux);
    }
    /**
     * metodo para editar un item tipo Insumo con los siguientes parametros
     * @param nombre
     * @param descripcion
     * @param precio
     * @param visibidad
     * @param disponibilidad
     * @param imagen
     * @param target 
     */
    public void editarItemInsumo(String nombre, String descripcion, double precio, boolean visibidad, int disponibilidad, String imagen, int target){        
        //buscar item por el id
        Item aux = getItem(target);
        //no existe item salir de la funcion
        if(aux == null){
            return;
        }
        // Actualizar atributos
        new ControlInsumo().editarInsumo((Insumo) aux, nombre, descripcion, precio, LocalDate.now(), visibidad, disponibilidad, imagen);
          
    }
    /**
     * metodo para eliminar un item de la lista con el id
     * @param target id del item
     */
    public void eliminarItem(int target){
        Item aux = getItem(target);
        //no existe publicacion salir de la funcion
        if(aux == null){
            return;
        }
        items.remove(aux);
    }
    /**
     * metodo sobrecargado para eliminar el item de las lista pasando
     * el objeto a eliminar
     * @param item 
     */
    public void eliminarItem(Item item){        
        items.remove(item);
    }

    public ArrayList<Item> getPublicaciones() {
        return items;
    }
}
