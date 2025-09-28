package udistrital.avanzada.taller1.modelo;

/**
 * Clase que representa un scooter dentro del sistema Taller1.
 * <p>
 * Hereda de la clase {@link Vehiculo}, reutilizando sus atributos y
 * comportamientos generales, pero adaptados al tipo de vehículo "Scooter".
 * </p>
 * 
 * <p>
 * La clase fue renombrada desde {@code Patineta} a {@code Scooter} para
 * estandarizar la nomenclatura y reflejar mejor su propósito dentro del
 * sistema, ya que se trata de un vehículo motorizado y no de una patineta manual.
 * </p>
 * 
 * @author Diego
 * @version 1.2
 * @date 27/09/2025
 */

/* Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Descripción de la modificación:
 *    - Se cambió el nombre de la clase de "Patineta" a "Scooter" para mayor claridad conceptual.
 *    - Se reemplazaron los tipos de datos primitivos {@code int} por {@code String}
 *      para los atributos relacionados con el vehículo.
 *    - Se eliminó el atributo {@code carga}, ya que no aplica para este tipo de vehículo.
 *    - Se añadió el parámetro {@code tipoVehiculo} en el constructor, conforme a la nueva
 *      estructura de la clase base {@link Vehiculo}.
 */

public class Scooter extends Vehiculo {

    /**
     * Constructor de la clase Scooter.
     * 
     * @param marca         Marca del scooter
     * @param modelo        Modelo del scooter
     * @param ano           Año del modelo (como cadena)
     * @param potencia      Potencia del motor (como cadena)
     * @param color         Color del scooter
     * @param tipoVehiculo  Tipo del vehículo (por ejemplo, "Scooter")
     * @param placa         Placa única del scooter
     * @param usuario       Propietario del vehículo
     */
    public Scooter(String marca, String modelo, String ano, String potencia, 
                   String color, String tipoVehiculo, String placa, Usuario usuario) {
        super(marca, modelo, ano, potencia, color, tipoVehiculo, placa, usuario,"/udistrital/avanzada/taller1/vista/Scooter.png");
    }

    /**
     * Devuelve una representación en texto del objeto Scooter.
     * 
     * @return Cadena con la información detallada del scooter
     */
    @Override
    public String toString() {
        return "Scooter{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano='" + getAno() + '\'' +
                ", color='" + getColor() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", potencia='" + getPotencia() + '\'' +
                ", tipoVehiculo='" + getTipoVehiculo() + '\'' +
                '}';
    }
}
