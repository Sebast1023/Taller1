package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un proveedor de tipo Insumos, el cual maneja
 * exclusivamente productos físicos.
 * 
 * Hereda de la clase Proveedor e incorpora una lista de insumos que el
 * proveedor ofrece. Cada insumo se modela como un objeto de la clase Insumo.
 * 
 * author mauricio
 * version 1.0
 * date 23/09/2025
 * 
 * Fecha de Modificación: 27/09/2025  
 * Modificado por: Diego  
 * Nro. Orden de Trabajo: 001  
 * Descripción de la modificación:  
 *   - Se añadió el método getRol() para identificar el tipo de proveedor.
 *   - Se añadio el método getEmpresa() para identificar la empresa del proveedor.
 *   - Se mejoró la documentación general y por método
 */
public class ProveedorInsumos extends Proveedor {

    /** Lista de insumos que el proveedor ofrece */
    private ArrayList<Insumo> insumos;

    /**
     * Constructor de la clase ProveedorInsumos.
     * 
     * @param nombre      Nombre del proveedor
     * @param apellido    Apellido del proveedor
     * @param cedula      Documento de identidad
     * @param numero      Número de contacto
     * @param correo      Correo electrónico
     * @param membresia   Membresía de la asociación
     * @param contraseña  Contraseña de acceso
     * @param empresa     Nombre de la empresa
     * @param nit         NIT de la empresa
     */
    public ProveedorInsumos(String nombre, String apellido, String cedula, String numero, 
                            String correo, String membresia, String contraseña, 
                            String empresa, int nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        this.insumos = new ArrayList<>();
    }

    /**
     * Agrega un insumo a la lista de insumos del proveedor.
     *
     * @param insumo Insumo a agregar a la lista
     */
    public void addInsumo(Insumo insumo) {
        insumos.add(insumo);
    }

    /**
     * Elimina un insumo de la lista de insumos del proveedor.
     *
     * @param insumo Insumo a eliminar de la lista
     */
    public void delInsumo(Insumo insumo) {
        insumos.remove(insumo);
    }

    /**
     * Obtiene la lista completa de insumos del proveedor.
     *
     * @return Lista de insumos
     */
    public ArrayList<Insumo> getInsumos() {
        return insumos;
    }
    
    /**
    * Obtiene el nombre de la empresa del proveedor.
    * 
    * @return Nombre de la empresa asociada al proveedor
    */
    public String getEmpresa() {
        return this.empresa;
    }


    /**
     * Retorna el rol correspondiente a este tipo de persona dentro del sistema.
     * 
     * Permite identificar que este objeto es un "Proveedor de Insumos"
     * cuando se consultan roles de forma polimórfica.
     * 
     * @return Cadena "Proveedor de Insumos"
     */
    @Override
    public String getRol() {
        return "Proveedor de Insumos";
    }
}

