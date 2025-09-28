package udistrital.avanzada.taller1.modelo;

/**
 * Clase que representa una motocicleta eléctrica dentro del sistema Taller1.
 * <p>
 * Hereda de la clase {@link Vehiculo}, utilizando sus atributos
 * y comportamientos comunes, pero adaptados al tipo de vehículo "Moto".
 * </p>
 * 
 * <p>
 * La motocicleta se identifica mediante su placa única, y contiene
 * información relevante como marca, modelo, año, potencia, color
 * y tipo de vehículo.
 * </p>
 * 
 * author Mauricio
 * version 1.2
 * date 27/09/2025
 */

/* Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Descripción de la modificación:
 *    - Se reemplazaron los tipos primitivos {@code int} por {@code String}
 *      en los atributos del vehículo, para mayor flexibilidad.
 *    - Se eliminó el atributo {@code carga}, ya que no aplica para este tipo.
 *    - Se actualizó el constructor para incluir el nuevo atributo "tipoVehiculo",
 *      definido en la clase base {@link Vehiculo}.
 */

public class Moto extends Vehiculo {

    /**
     * Constructor de la clase Moto.
     * 
     * @param marca         Marca de la motocicleta
     * @param modelo        Modelo de la motocicleta
     * @param ano           Año del modelo (como cadena)
     * @param potencia      Potencia del motor (como cadena)
     * @param color         Color de la motocicleta
     * @param tipoVehiculo  Tipo del vehículo (por ejemplo, "Moto")
     * @param placa         Placa única de la motocicleta
     * @param usuario       Propietario del vehículo
     */
    public Moto(String marca, String modelo, String ano, String potencia, 
                String color, String tipoVehiculo, String placa, Usuario usuario) {
        super(marca, modelo, ano, potencia, color, tipoVehiculo, placa, usuario,"/udistrital/avanzada/taller1/vista/moto.png");
    }

    /**
     * Devuelve una representación en texto del objeto Moto.
     * 
     * @return Cadena con la información detallada de la motocicleta
     */
    @Override
    public String toString() {
        return "Moto{" +
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
