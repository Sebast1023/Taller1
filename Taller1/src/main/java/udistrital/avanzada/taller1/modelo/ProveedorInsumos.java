package udistrital.avanzada.taller1.modelo;

import java.util.ArrayList;

/**
 * @author mauricio 
 * 23/9/2025
 */
public class ProveedorInsumos extends Proveedor {

    private ArrayList<Insumo> insumos;

    public ProveedorInsumos(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, String nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña, empresa, nit);
        //Se instancia el grupo que almacenara los objetos
        this.insumos = new ArrayList<Insumo>();
    }

    /**
     * método para agregar producto a la lista de insumos
     *
     * @param insumo producto a agregar a la lista
     */
    public void addInsumo(Insumo insumo) {
        insumos.add(insumo);
    }

    /**
     * método para eliminar insumo a la lista de insumos
     *
     * @param insumo producto a remover de la lista de insumos
     */
    public void delInsumo(Insumo insumo) {
        insumos.remove(insumo);
    }

    /**
     * método para obtener lista de insumos
     *
     * @return Lista de de los insumos que tiene el proveedor
     */
    public ArrayList<Insumo> getInsumos() {
        return insumos;
    }
}
