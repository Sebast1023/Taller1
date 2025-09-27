package udistrital.avanzada.taller1.vista;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    public PanelLogin panelLogin;
    public PanelRegistro panelRegistro;
    public PanelVehiculo panelVehiculo;
    public PanelMenu panelMenu;
    
    public Ventana(String title) {
        super(title);
        inicializar();
    }
    
    public void inicializar(){
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        
        panelLogin = new PanelLogin();
        panelRegistro = new PanelRegistro();
        panelVehiculo = new PanelVehiculo();
        panelMenu = new PanelMenu();
        
        panelPrincipal.add(panelLogin, "LOGIN_PANEL");
        panelPrincipal.add(panelRegistro, "REGISTRO_PANEL");
        panelPrincipal.add(panelVehiculo, "VEHICULO_PANEL");
        panelPrincipal.add(panelMenu, "MENU_PANEL");
                
        this.add(panelPrincipal);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }    
     public void mostrarPanel(String nombre){
        cardLayout.show(panelPrincipal, nombre);
    }
     
     /**
     * metodo para mostrar cuadro de dialogo
     * @param componente
     * @param mensaje 
     */
    public void mostrarMensajeDialogo(Component componente, String mensaje){
        JOptionPane.showMessageDialog(componente, mensaje);
    } 
}