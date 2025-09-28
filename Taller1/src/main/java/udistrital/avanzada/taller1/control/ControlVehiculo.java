package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 * Clase de control que gestiona los objetos {@link Vehiculo} dentro del sistema.
 * <p>
 * La clase ControlVehiculo permite realizar operaciones CRUD:
 * crear, consultar, modificar y eliminar vehículos registrados,
 * garantizando la unicidad de la placa como identificador.
 * </p>
 * 
 * <p>
 * Además, facilita la interacción entre los vehículos y su asociación con 
 * los propietarios representados por la clase {@link Usuario}.
 * </p>
 * 
 * author Diego
 * version 1.2
 * date 27/09/2025
 */

/* Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Descripción de la modificación:
 *    - Se añadió el parámetro "tipoVehiculo" al método crearVehiculo,
 *      para reflejar la actualización del constructor en la clase Vehiculo.
 *    - Se actualizó la documentación para describir el nuevo parámetro.
 */

public class ControlVehiculo {
    private ArrayList<Vehiculo> vehiculos;

    
    // Constructor: Inicializa la lista de vehículos
     
    public ControlVehiculo() {
        this.vehiculos = new ArrayList<>();
    }

    /**
     * Método para registrar un nuevo vehículo en el sistema
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param ano año de fabricación
     * @param potencia potencia del motor
     * @param color color del vehículo
     * @param tipoVehiculo tipo de vehículo (Moto, Scooter, Auto, etc.)
     * @param placa placa única (no se puede repetir)
     * @param usuario usuario propietario del vehículo
     */
    public void crearVehiculo(String marca, String modelo, String ano, String potencia, 
                              String color, String tipoVehiculo, String placa, Usuario usuario) {
        // Validamos que no exista ya un vehículo con la misma placa
        if (buscarVehiculo(placa) == null) {
            Vehiculo vehiculo = new Vehiculo(marca, modelo, ano, potencia, color, tipoVehiculo, placa, usuario);
            vehiculos.add(vehiculo);
        } else {
            System.out.println("Error: ya existe un vehículo con la placa " + placa);
        }
    }

    /**
     * Método para buscar un vehículo por su placa
     * 
     * @param placa placa del vehículo
     * @return el objeto Vehiculo si existe, null si no se encuentra
     */
    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Método para modificar los datos de un vehículo ya existente
     * 
     * @param placa placa del vehículo a modificar
     * @param nuevaMarca nueva marca (si se deja igual, se mantiene)
     * @param nuevoModelo nuevo modelo
     * @param nuevoAno nuevo año
     * @param nuevaPotencia nueva potencia
     * @param nuevoColor nuevo color
     */
    public void modificarVehiculo(String placa, String nuevaMarca, String nuevoModelo, 
                                  String nuevoAno, String nuevaPotencia, String nuevoColor) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            vehiculo.setMarca(nuevaMarca);
            vehiculo.setModelo(nuevoModelo);
            vehiculo.setAno(nuevoAno);
            vehiculo.setPotencia(nuevaPotencia);
            vehiculo.setColor(nuevoColor);
        } else {
            System.out.println("Error: no se encontró vehículo con placa " + placa);
        }
    }

    /**
     * Método para eliminar un vehículo del sistema
     * 
     * @param placa placa del vehículo a eliminar
     */
    public void eliminarVehiculo(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
        } else {
            System.out.println("Error: no se encontró vehículo con placa " + placa);
        }
    }

    /**
     * Método para obtener la lista de vehículos registrados
     * 
     * @return lista de objetos Vehiculo
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}

