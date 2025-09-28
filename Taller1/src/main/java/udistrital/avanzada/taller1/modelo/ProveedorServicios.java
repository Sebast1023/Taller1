package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * author mauricio 
 * date 23/09/2025
 * 
 * Clase ProveedorServicios representa a un proveedor que ofrece servicios dentro del sistema.
 * Hereda de la clase Proveedor e incluye una lista de servicios asociados.
 * 
 * Su función es administrar los servicios pertenecientes a este proveedor.
 * 
 * ------------------------------------------------------------
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción de la modificación:
 *    Se añadió el método getRol() para identificar el tipo de proveedor.
 *    Se añadio el método getEmpresa() para identificar la empresa del proveedor.
 *    dentro del sistema. Se mejoró la documentación general.
 * ------------------------------------------------------------
 */
public class ProveedorServicios extends Proveedor {

    private ArrayList<Servicio> servicios;

    /**
     * Constructor de la clase ProveedorServicios.
     * 
     * @param nombre nombre del proveedor
     * @param apellido apellido del proveedor
     * @param cedula número de identificación del proveedor
     * @param numero número de contacto
     * @param correo correo electrónico del proveedor
     * @param membresia membresía dentro de la asociación
     * @param contraseña clave de acceso al sistema
     * @param empresa nombre de la empresa
     * @param nit número de identificación tributaria
     */
    public ProveedorServicios(String nombre, String apellido, String cedula, String numero, String correo, 
                              String membresia, String contraseña, String empresa, int nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        // Se instancia el grupo que almacenará los objetos Servicio
        this.servicios = new ArrayList<Servicio>();
    }

    /**
     * Método para agregar un servicio a la lista de servicios del proveedor.
     *
     * @param servicio servicio a agregar
     */
    public void addServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    /**
     * Método para eliminar un servicio de la lista de servicios del proveedor.
     *
     * @param servicio servicio a remover
     */
    public void delServicio(Servicio servicio) {
        servicios.remove(servicio);
    }

    /**
     * Método para obtener la lista de servicios asociados al proveedor.
     *
     * @return lista de servicios registrados por este proveedor
     */
    public ArrayList<Servicio> getServicios() {
        return servicios;
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
     * Método para obtener el rol del usuario dentro del sistema.
     * 
     * @return una cadena de texto indicando el rol: "Proveedor de Servicios"
     */
    @Override
    public String getRol() {
        return "Proveedor de Servicios";
    }
}

