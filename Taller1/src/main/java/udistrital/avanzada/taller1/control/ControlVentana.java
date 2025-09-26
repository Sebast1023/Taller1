package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlVentana implements ActionListener {

    private Ventana ventana;
    private LogicaNegocio logica;
    private boolean mostrando = false;

    public ControlVentana(LogicaNegocio logica) {
        this.logica = logica;
        ventana = new Ventana("ROLA PET");
        ventana.setSize(400, 350);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.panelLogin.bMostrarContrasena.addActionListener(this);
        ventana.panelLogin.bIniciarSesion.addActionListener(this);
        ventana.panelLogin.bRegistrarse.addActionListener(this);
        ventana.panelRegistro.bRegistrar.addActionListener(this);
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("mostrarContrasena".equals(e.getActionCommand())) {
            if (mostrando) {
                ventana.panelLogin.cContrasena.setEchoChar('•'); // Ocultar
                ventana.panelLogin.bMostrarContrasena.setText("👁");
                mostrando = false;
            } else {
                ventana.panelLogin.cContrasena.setEchoChar((char) 0); // Mostrar
                ventana.panelLogin.bMostrarContrasena.setText("🔒");
                mostrando = true;
            }
        }
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Registrese":
                ventana.mostrarPanel("REGISTRO_PANEL");
                break;
            case "Registrar":
                ventana.mostrarPanel("LOGIN_PANEL");
                break;
            case "Iniciar Sesion":
                ventana.mostrarPanel("VEHICULO_PANEL");
        }

    }
}
