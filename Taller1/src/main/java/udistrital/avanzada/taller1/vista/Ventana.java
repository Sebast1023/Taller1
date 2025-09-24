package udistrital.avanzada.taller1.vista;


import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    public JLabel tituloVentana;
    public JLabel lUsuario;
    public JLabel lContrasena;
    public JTextField cUsuario;
    public JPasswordField cContrasena;
    public JButton bIniciarSesion;
    public JButton bRegistrarse;
    public JLabel lCrearCuenta;
    public JButton bMostrarContrasena;
    
    public Ventana(String title) {
        super(title);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        panel1 = new JPanel();
        tituloVentana = new JLabel("Iniciar sesion");
        panel1.add(tituloVentana);
        
        panel2 = new JPanel();
        lUsuario = new JLabel("Usuario     ");
        cUsuario = new JTextField(15);
        lContrasena = new JLabel("Contraseña");
        cContrasena = new JPasswordField(15);
        bMostrarContrasena = new JButton("👁");
        bMostrarContrasena.setActionCommand("mostrarContrasena");
        bIniciarSesion = new JButton("Iniciar Sesion");
        bIniciarSesion.setActionCommand("Iniciar Sesion");
        
        panel2.add(lUsuario);
        panel2.add(cUsuario);
        panel2.add(lContrasena);
        panel2.add(cContrasena);
        panel2.add(bMostrarContrasena);
        panel2.add(bIniciarSesion);
        
        panel3 = new JPanel();
        lCrearCuenta = new JLabel("¿Aun no tiene cuenta?");
        bRegistrarse = new JButton("Registrese");
        bRegistrarse.setActionCommand("Registrese");

        panel3.add(lCrearCuenta);
        panel3.add(bRegistrarse);
        
        panel4 = new JPanel();
        
        panel5 = new JPanel();
        
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        this.add(panel4, BorderLayout.WEST);
        this.add(panel5, BorderLayout.EAST);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

}