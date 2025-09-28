package udistrital.avanzada.taller1.vista;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase ventana que extiende de JFrame y sirve como contenedor principal de la 
 * aplicación.
 * Se hace uso de un CardLayout para manejar diferentes paneles de la interfaz
 * gráfica.
 * 
 * author sebas
 * date 23/09/2025
 */
public class Ventana extends JFrame {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    public PanelLogin panelLogin;
    public PanelRegistro panelRegistro;
    public PanelVehiculo panelVehiculo;
    public PanelMenu panelMenu;
    public PanelAdmin panelAdmin;
    public PanelVehiculos panelVehiculos;
    public PanelServicio panelServicio;
    public PanelAceptarUsuario panelAceptar;

    
    /**
     * Constructor de la clase ventana.
     * Inicializa el JFrame con un título y configura la interfaz.
     * 
     * @param title Título de la ventana.
     */
    public Ventana(String title) {
        super(title);
        inicializar();
    }
    /**
     * Método encargado de inicializar los componentes principales de la ventana.
     * Configura el CardLayout, crea los paneles y los añade al contenedor 
     * principal.
     * También establece el comportamiento al cerrar la ventana.
     */
    public void inicializar(){
        // Se define el layout como CardLayout para manejar paneles intercambiables.
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        
        // Inicialización de cada panel de la aplicación.
        panelLogin = new PanelLogin();
        panelRegistro = new PanelRegistro();
        panelVehiculo = new PanelVehiculo();
        panelMenu = new PanelMenu();
        panelAdmin = new PanelAdmin();
        panelVehiculos = new PanelVehiculos();
        panelServicio = new PanelServicio();
        panelAceptar = new PanelAceptarUsuario();
        
        //Se añaden los paneles al panel principal con un texto identificador.
        panelPrincipal.add(panelLogin, "LOGIN_PANEL");
        panelPrincipal.add(panelRegistro, "REGISTRO_PANEL");
        panelPrincipal.add(panelVehiculo, "VEHICULO_PANEL");
        panelPrincipal.add(panelMenu, "MENU_PANEL");
        panelPrincipal.add(panelAdmin, "ADMIN_PANEL");
        panelPrincipal.add(panelVehiculos, "PANEL_VEHICULOS_USUARIO");
        panelPrincipal.add(panelServicio, "SERVICIO_PANEL");
        panelPrincipal.add(panelAceptar,"ACEPTAR_PANEL");
        
        //Se agrega el panel principal al JFrame.
        this.add(panelPrincipal);
        
        // Se añade un listener para cerrar la aplicación cuando se cierre la ventana.
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }    
    
    /**
     * Método para mostrar un panel específico de la aplicación.
     * 
     * @param nombre Identificador del panel a mostrar
     */
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