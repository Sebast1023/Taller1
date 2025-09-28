package udistrital.avanzada.taller1.control;

/**
 * Clase Launcher.
 * 
 * Punto de entrada principal de la aplicación. 
 * Su única responsabilidad es inicializar la lógica de negocio
 * mediante la creación de una instancia de {@link LogicaNegocio}.
 * 
 * Normalmente se usa como clase ejecutable para arrancar el programa.
 * 
 * author sebas
 * date 23/09/2025
 */

public class Launcher {
    /**
     * Método principal (main).
     * 
     * Es el encargado de iniciar la aplicación llamando
     * a la clase {@link LogicaNegocio}.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main (String [] args){
        new LogicaNegocio();
    }
}
