package udistrital.avanzada.taller1.modelo;

public class Moto extends Vehiculo {

    public Moto(String marca, String modelo, int ano, int potencia, int carga, String color, String placa, Usuario usuario) {
        super(marca, modelo, ano, potencia, carga, color, placa, usuario);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", color='" + getColor() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", potencia=" + getPotencia() +
                '}';
    }
}
