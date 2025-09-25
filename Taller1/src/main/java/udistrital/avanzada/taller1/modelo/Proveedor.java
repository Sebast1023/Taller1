package udistrital.avanzada.taller1.modelo;

/**
 * @author mauricio
 * 23/9/2025
 * Super clase de Proveedor tipo insumo y tipo servicio
 */
public abstract class Proveedor extends Persona{
    // nombre de la empresa
    protected String empresa;
    // numero de identificacion tributaria
    protected int nit;
    
    public Proveedor(String nombre, String apellido, String cedula, String numero, String correo, String membresia, String contraseña, String empresa, int nit) {
        super(nombre, apellido, cedula, numero, correo, membresia, contraseña);
        this.empresa = empresa;
        this.nit = nit;
    }
}
