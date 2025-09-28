package udistrital.avanzada.taller1.modelo;

/**
 * Representa un Vehículo dentro del sistema Taller1.
 * <p>
 * Un vehículo contiene información básica como marca, modelo, año, potencia, 
 * color, placa única y tipo de vehículo, además de estar asociado a un {@link Usuario}.
 * </p>
 * 
 * <p>
 * La placa se utiliza como identificador único para garantizar que 
 * no existan dos vehículos registrados con la misma matrícula.
 * </p>
 * 
 * author Diego
 * version 1.0
 * date 26/09/2025
 */

/* Fecha de Modificación: 26/09/2025
 * Modificado por: Diego
 * Descripción de la modificación:
 *    - Se cambiaron los tipos de datos de los atributos "ano" y "potencia" 
 *      de int a String, para facilitar el manejo flexible de valores.
 *    - Se eliminó el atributo "carga", ya que no era requerido en la especificación actual.
 *    - Se añadió el atributo "tipoVehiculo" para identificar el tipo de vehículo (por el momento scooter y motos eléctricas). 
 *     
 */

public class Vehiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String potencia;
    private String color;
    private String tipoVehiculo; // nuevo atributo
    private String placa;
    private Usuario usuario;

    public Vehiculo(String marca, String modelo, String ano, String potencia, 
                    String color, String tipoVehiculo, String placa, Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.usuario = usuario;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

