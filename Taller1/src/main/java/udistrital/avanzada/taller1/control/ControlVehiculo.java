package udistrital.avanzada.taller1.control;

import java.util.ArrayList;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.modelo.Vehiculo;

/**
 * Clase de control que gestiona los objetos Vehiculo dentro del sistema.
 * 
 * La clase ControlVehiculo.java permite crear, consultar, modificar y eliminar 
 * vehículos asociados a usuarios registrados en el sistema.
 * 
 * @author Diego
 * @version 1.0
 * @date 26/09/2025
 */
public class ControlVehiculo {
    private ArrayList<Vehiculo> vehiculos;

    
    // Constructor: inicializa la lista de vehículos
     
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
     * @param carga capacidad de carga
     * @param color color del vehículo
     * @param placa placa única (no se puede repetir)
     * @param usuario usuario propietario del vehículo
     */
    public void crearVehiculo(String marca, String modelo, int ano, int potencia, int carga, String color, String placa, Usuario usuario) {
        // Validamos que no exista ya un vehículo con la misma placa
        if (buscarVehiculo(placa) == null) {
            Vehiculo vehiculo = new Vehiculo(marca, modelo, ano, potencia, carga, color, placa, usuario);
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
     * @param nuevaCarga nueva capacidad de carga
     * @param nuevoColor nuevo color
     */
    public void modificarVehiculo(String placa, String nuevaMarca, String nuevoModelo, int nuevoAno, int nuevaPotencia, int nuevaCarga, String nuevoColor) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            vehiculo.setMarca(nuevaMarca);
            vehiculo.setModelo(nuevoModelo);
            vehiculo.setAno(nuevoAno);
            vehiculo.setPotencia(nuevaPotencia);
            vehiculo.setCarga(nuevaCarga);
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

