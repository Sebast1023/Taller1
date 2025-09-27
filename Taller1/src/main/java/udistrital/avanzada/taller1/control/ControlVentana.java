package udistrital.avanzada.taller1.control;

import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;

/**
 * Clase ControlVentana
 * 
 * Controla la interacción entre la interfaz gráfica {@link Ventana} y la lógica del negocio.
 * Se encarga de escuchar los eventos de los botones en los diferentes paneles,
 * gestionar el flujo de navegación entre ellos y comunicarse con la capa lógica
 * para operaciones como el inicio de sesión o el registro de usuarios.
 * 
 * @author Diego
 * @version 1.0
 * @date 26/09/2025
 */

/* Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Descripción de la modificación:
 *    - Se eliminó la dependencia del método {@code getUsuarioActivo()} en la clase {@link LogicaNegocio}.
 *    - Ahora se utiliza directamente el objeto {@link Persona} retornado por el método {@code login()} 
 *      para mostrar los datos del usuario autenticado en el panel de menú.
 *    - Se simplificó el flujo de autenticación, reduciendo la necesidad de mantener un usuario activo
 *      en la lógica de negocio y mejorando la legibilidad del código.
 */

public class ControlVentana implements ActionListener {

    // Ventana principal del sistema
    private Ventana ventana;
    
    // Instancia de la lógica de negocio que maneja los datos del sistema
    private LogicaNegocio logica;
    
    // Variable que indica si la contraseña se está mostrando o no
    private boolean mostrando = false;

    /**
     * Constructor de ControlVentana.
     * 
     * Inicializa la interfaz gráfica y registra los listeners para todos los botones
     * de los diferentes paneles (Login, Registro, Menú y Vehículo).
     * 
     * @param logica instancia de la clase LogicaNegocio que maneja los procesos del sistema
     */
    public ControlVentana(LogicaNegocio logica) {
        this.logica = logica;
        ventana = new Ventana("ROLA PET");
        ventana.setSize(400, 350);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        // Asignación de eventos a los botones
        ventana.panelLogin.bMostrarContrasena.addActionListener(this);
        ventana.panelLogin.bIniciarSesion.addActionListener(this);
        ventana.panelLogin.bRegistrarse.addActionListener(this);
        ventana.panelRegistro.bRegistrar.addActionListener(this);
        ventana.panelVehiculo.bMoto.addActionListener(this);
        ventana.panelVehiculo.bScooter.addActionListener(this);
        ventana.panelMenu.bSalir.addActionListener(this);
        ventana.panelMenu.bVehiculos.addActionListener(this);
        ventana.panelVehiculo.bAtras.addActionListener(this);
        
        ventana.setVisible(true);
    }

    /**
     * Limpia los campos de texto en todos los paneles de la interfaz.
     * 
     * Este método se utiliza para evitar que queden datos anteriores en los
     * formularios después de un registro o un inicio/cierre de sesión.
     */
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
        ventana.panelVehiculo.cAno.setText("");
        ventana.panelVehiculo.cColor.setText("");
        ventana.panelVehiculo.cMarca.setText("");
        ventana.panelVehiculo.cPotencia.setText("");
    }
    /**
     * Metodo para mostra panel segun tipo de usuario
     * que se haya logeado
     * @param persona 
     */
    public void mostrarPanel(Persona persona){
        switch (persona.getRol()) {
            case "Proveedor de Insumos":                
               break;
            case "Proveedor de Servicios":                           
               break;
            case "Administrador":
               break;
            case "Usuario":
                //si usuario no activo entonces mostra dialogo
                // metodo debee cambiar
                boolean aprobado = ((Usuario) persona).isAprobado();
                if(!aprobado){
                    break;
                }
                ventana.mostrarPanel("MENU_PANEL");
                limpiarCampos();
                // Mostrar información del usuario
                ventana.panelMenu.cNombre.setText(persona.getNombre());
                ventana.panelMenu.cApellido.setText(persona.getApellido());
                ventana.panelMenu.cCedula.setText(persona.getCedula());
                ventana.panelMenu.cCorreo.setText(persona.getCorreo());
                ventana.panelMenu.cNumero.setText(persona.getNumero());
                ventana.panelMenu.cMembresia.setText(persona.getMembresia());

                // Hacer los campos no editables
                ventana.panelMenu.cNombre.setEditable(false);
                ventana.panelMenu.cApellido.setEditable(false);
                ventana.panelMenu.cCedula.setEditable(false);
                ventana.panelMenu.cCorreo.setEditable(false);
                ventana.panelMenu.cNumero.setEditable(false);
                ventana.panelMenu.cMembresia.setEditable(false);     
               break;
            default:
                break;
             
        }
    }

    /**
     * Método que responde a los eventos generados por los botones de la interfaz.
     * 
     * Dependiendo del comando recibido, se realiza una acción específica como:
     * mostrar u ocultar la contraseña, registrar un nuevo usuario, iniciar sesión
     * o navegar entre paneles.
     * 
     * @param e evento que representa la acción ejecutada por el usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Evento para mostrar u ocultar la contraseña
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
        // Comando de quien disaparo el evento
        String cmd = e.getActionCommand();

        switch (cmd) {
            
            case "Registrese":
                ventana.mostrarPanel("REGISTRO_PANEL");
                break;

            case "Registrar":
                // Obtención de datos del formulario de registro
                String nombre = ventana.panelRegistro.cNombre.getText();
                String apellido = ventana.panelRegistro.cApellido.getText();
                String cedula = ventana.panelRegistro.cCedula.getText();
                String numero = ventana.panelRegistro.cNumero.getText();
                String correo = ventana.panelRegistro.cCorreo.getText();
                String membresia = ventana.panelRegistro.cMembresia.getText();
                String contraseña = ventana.panelRegistro.cContrasena.getText();

                // Creación del usuario en la capa lógica
                logica.crearUsuario(nombre, apellido, cedula, numero, correo, membresia, contraseña);
                limpiarCampos();
                ventana.mostrarPanel("LOGIN_PANEL");
                break;

            case "Iniciar Sesion":
                // Validación de credenciales de usuario
                String cedula1 = ventana.panelLogin.cUsuario.getText();
                String contrasena = new String(ventana.panelLogin.cContrasena.getPassword());
                Persona p = logica.login(cedula1, contrasena);
                

                if (p != null) {
                    // Si el login es correcto, mostrar panel de menú 
                    // llamar al metodo mostraPanel  para saber que panel mostrar segun tipo de usuario
                    mostrarPanel(p);
                } 
                else {
                    // login incorrecto mostrar mensaje avisando de que esta incorrecto                    
                    ventana.mostrarMensajeDialogo(ventana, "Usuario o contraseña incorrectos");
                }
                break;

            case "Vehiculos":
                ventana.mostrarPanel("VEHICULO_PANEL");
                break;

            case "Scooter":
            case "Moto":
                ventana.mostrarPanel("LOGIN_PANEL");
                limpiarCampos();
                break;

            case "Salir":
                ventana.mostrarPanel("LOGIN_PANEL");
                break;

            case "Atras":
                ventana.mostrarPanel("MENU_PANEL");
                break;
        }
    }
}
