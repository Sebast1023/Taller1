package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlVentana implements ActionListener{
    
    private Ventana ventana;
    private LogicaNegocio logica;
    private boolean mostrando = false;
    
    public ControlVentana(LogicaNegocio logica) {
        this.logica = logica;
        ventana = new Ventana("ROLA PET");
        ventana.setSize(330, 250);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.bMostrarContrasena.addActionListener(this);
        ventana.bIniciarSesion.addActionListener(this);
        ventana.bRegistrarse.addActionListener(this);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("mostrarContrasena".equals(e.getActionCommand())){
           if (mostrando) {
                    ventana.cContrasena.setEchoChar('•'); // Ocultar
                    ventana.bMostrarContrasena.setText("👁");
                    mostrando = false;
                } else {
                    ventana.cContrasena.setEchoChar((char) 0); // Mostrar
                    ventana.bMostrarContrasena.setText("🔒");
                    mostrando = true;
                }
        }
    }
}