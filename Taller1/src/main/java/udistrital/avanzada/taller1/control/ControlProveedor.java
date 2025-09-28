package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.ProveedorInsumos;
import udistrital.avanzada.taller1.modelo.ProveedorServicios;
import udistrital.avanzada.taller1.modelo.Publicacion;

/**
 * Controlador que gestiona los proveedores dentro del sistema.
 * <p>
 * Permite registrar proveedores de insumos y servicios, buscar proveedores,
 * eliminar proveedores y administrar las publicaciones asociadas a cada uno.
 * </p>
 * 
 * Esta clase sigue el patrón MVC y mantiene la separación de responsabilidades,
 * centralizando la gestión de proveedores en un único lugar.
 * 
 * author Diego
 * version 1.0
 * date 27/09/2025
 */
public class ControlProveedor {

    /** Lista de proveedores de insumos registrados */
    private ArrayList<ProveedorInsumos> proveedoresInsumos;

    /** Lista de proveedores de servicios registrados */
    private ArrayList<ProveedorServicios> proveedoresServicios;

    /**
     * Constructor: inicializa las listas de proveedores.
     */
    public ControlProveedor() {
        this.proveedoresInsumos = new ArrayList<>();
        this.proveedoresServicios = new ArrayList<>();
    }

    /**
     * Registra un nuevo proveedor de insumos en el sistema.
     * 
     * @param proveedor ProveedorInsumos a registrar
     */
    public void registrarProveedorInsumos(ProveedorInsumos proveedor) {
        proveedoresInsumos.add(proveedor);
    }

    /**
     * Registra un nuevo proveedor de servicios en el sistema.
     * 
     * @param proveedor ProveedorServicios a registrar
     */
    public void registrarProveedorServicios(ProveedorServicios proveedor) {
        proveedoresServicios.add(proveedor);
    }

    /**
     * Busca un proveedor de insumos por su nombre de empresa.
     * 
     * @param empresa Nombre de la empresa
     * @return ProveedorInsumos si se encuentra, null si no existe
     */
    public ProveedorInsumos buscarProveedorInsumos(String empresa) {
        for (ProveedorInsumos p : proveedoresInsumos) {
            if (p.getEmpresa().equalsIgnoreCase(empresa)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Busca un proveedor de servicios por su nombre de empresa.
     * 
     * @param empresa Nombre de la empresa
     * @return ProveedorServicios si se encuentra, null si no existe
     */
    public ProveedorServicios buscarProveedorServicios(String empresa) {
        for (ProveedorServicios p : proveedoresServicios) {
            if (p.getEmpresa().equalsIgnoreCase(empresa)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina un proveedor de insumos registrado.
     * 
     * @param proveedor ProveedorInsumos a eliminar
     */
    public void eliminarProveedorInsumos(ProveedorInsumos proveedor) {
        proveedoresInsumos.remove(proveedor);
    }

    /**
     * Elimina un proveedor de servicios registrado.
     * 
     * @param proveedor ProveedorServicios a eliminar
     */
    public void eliminarProveedorServicios(ProveedorServicios proveedor) {
        proveedoresServicios.remove(proveedor);
    }

    /**
     * Agrega una publicación al proveedor de insumos especificado.
     * 
     * @param proveedor ProveedorInsumos al que se agregará la publicación
     * @param publicacion Publicacion a agregar
     */
    public void agregarPublicacionProveedorInsumos(ProveedorInsumos proveedor, Publicacion publicacion) {
        proveedor.addPost(publicacion);
    }

    /**
     * Agrega una publicación al proveedor de servicios especificado.
     * 
     * @param proveedor ProveedorServicios al que se agregará la publicación
     * @param publicacion Publicacion a agregar
     */
    public void agregarPublicacionProveedorServicios(ProveedorServicios proveedor, Publicacion publicacion) {
        proveedor.addPost(publicacion);
    }

    /**
     * Obtiene la lista de todos los proveedores de insumos registrados.
     * 
     * @return ArrayList de ProveedorInsumos
     */
    public ArrayList<ProveedorInsumos> getProveedoresInsumos() {
        return proveedoresInsumos;
    }

    /**
     * Obtiene la lista de todos los proveedores de servicios registrados.
     * 
     * @return ArrayList de ProveedorServicios
     */
    public ArrayList<ProveedorServicios> getProveedoresServicios() {
        return proveedoresServicios;
    }
}

