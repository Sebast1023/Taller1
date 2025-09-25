package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * @author mauricio 
 * 23/9/2025
 * Clase Proveedor tipo Servicios que solo maneja servicios
 */
public class ProveedorServicios extends Proveedor {

    private ArrayList<Servicio> servicios;
    /**
     * Constructor ProveedorServicios con los siguientes parametros
     * @param nombre
     * @param apellido
     * @param cedula
     * @param numero
     * @param correo 
     * @param membresia de la asociacion
     * @param contraseña
     * @param empresa nombre de la empresa
     * @param nit numero de identificacion tributaria
     */
    public ProveedorServicios(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, int nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        //Se instancia el grupo que almacenara los objetos
        this.servicios = new ArrayList<Servicio>();
    }

    /**
     * método para eliminar servicio de la lista de servicios
     *
     * @param servicio servicio a agregar
     */
    public void addInsumo(Servicio servicio) {
        servicios.add(servicio);
    }

    /**
     * método para eliminar servicio a la lista de servicios
     *
     * @param servicio servicio a remover de la lista servicios
     */
    public void delServicio(Servicio servicio) {
        servicios.remove(servicio);
    }

    /**
     * método para obtener lista de servicios
     *
     * @return Lista de de los servicios que tiene el proveedor
     */
    public ArrayList<Servicio> getInsumos() {
        return servicios;
    }

}
