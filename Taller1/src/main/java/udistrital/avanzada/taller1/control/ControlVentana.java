package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlVentana {
    
    private Ventana ventana;
    private LogicaNegocio logica;
    
    public ControlVentana(LogicaNegocio logica) {
        this.logica = logica;
        ventana = new Ventana("ROLA PET");
        ventana.setSize(400, 300);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
}