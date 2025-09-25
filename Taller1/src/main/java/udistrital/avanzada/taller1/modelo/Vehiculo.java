package udistrital.avanzada.taller1.modelo;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int ano;
    private int potencia;
    private int carga;
    private String color;
    // placa sera el atributo unico nadie más debe tenerlo
    private String placa;
    private Usuario usuario;

    public Vehiculo(String marca, String modelo, int ano, int potencia, int carga, String color, String placa, Usuario usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.carga = carga;
        this.color = color;
        this.placa = placa;
        this.usuario = usuario;
    }

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
