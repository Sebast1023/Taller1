package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import udistrital.avanzada.taller1.modelo.Persona;

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

    public void limpiarCampos() {
        ventana.panelRegistro.cNombre.setText("");
        ventana.panelRegistro.cApellido.setText("");
        ventana.panelRegistro.cCedula.setText("");
        ventana.panelRegistro.cCorreo.setText("");
        ventana.panelRegistro.cNumero.setText("");
        ventana.panelRegistro.cMembresia.setText("");
        ventana.panelRegistro.cContrasena.setText("");
        ventana.panelLogin.cContrasena.setText("");
        ventana.panelLogin.cUsuario.setText("");
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
                String nombre = ventana.panelRegistro.cNombre.getText();
                String apellido = ventana.panelRegistro.cApellido.getText();
                String cedula = ventana.panelRegistro.cCedula.getText();
                String numero = ventana.panelRegistro.cNumero.getText();
                String correo = ventana.panelRegistro.cCorreo.getText();
                String membresia = ventana.panelRegistro.cMembresia.getText();
                String contraseña = ventana.panelRegistro.cContrasena.getText();
                logica.crearUsuario(nombre, apellido, cedula, numero, correo, membresia, contraseña);
                ventana.mostrarPanel("LOGIN_PANEL");
                limpiarCampos();
                break;
            case "Iniciar Sesion":
                String cedula1 = ventana.panelLogin.cUsuario.getText();
                String contrasena = new String(ventana.panelLogin.cContrasena.getPassword());

                Persona p = logica.login(cedula1, contrasena);
                
                if (p != null) {
                    ventana.mostrarPanel("VEHICULO_PANEL");
                    limpiarCampos();
                }
                else{
                    JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos");
                }
        }
    }

}
