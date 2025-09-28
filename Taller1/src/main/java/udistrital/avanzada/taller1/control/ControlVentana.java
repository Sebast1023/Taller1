package udistrital.avanzada.taller1.control;

import java.awt.Component;
import udistrital.avanzada.taller1.vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import udistrital.avanzada.taller1.modelo.Persona;
import udistrital.avanzada.taller1.modelo.Usuario;
import udistrital.avanzada.taller1.vista.PanelItemVehiculo;

/**
 * Clase ControlVentana
 *
 * Controla la interacción entre la interfaz gráfica {@link Ventana} y la lógica
 * del negocio. Se encarga de escuchar los eventos de los botones en los
 * diferentes paneles, gestionar el flujo de navegación entre ellos y
 * comunicarse con la capa lógica para operaciones como el inicio de sesión o el
 * registro de usuarios.
 *
 * author Diego
 * author sebas
 * version 1.2
 * date 23/09/2025
 */

/* Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 001
 * Descripción de la modificación:
 *    - Resolución de conflicto merge: unificación del flujo de login.
 *    - El Control solicita el resultado a LogicaNegocio y la Vista muestra los mensajes.
 *    - Se preserva la responsabilidad: LogicaNegocio decide el mensaje, Ventana lo muestra.
 *
*/

/* 
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 002
 * Descripción:
 *    - Se añadió la validación de campos vacíos en los formularios
 *      de registro e inicio de sesión para evitar errores de entrada.
 *    - Ahora se muestran mensajes de advertencia cuando el usuario
 *      intenta continuar con campos incompletos.
 *    - Se añadió confirmación visual al registrar un usuario con éxito.
 *
 */

/* 
 * ------------------------------------------------------------
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 003
 * Descripción:
 *    - 001: Se eliminó dependencia de getUsuarioActivo(), ahora login usa directamente Persona.
 *    - 002: Se eliminó mensaje duplicado "Usuario o contraseña incorrectos".
 *    - 003: Se simplificó flujo de autenticación y mejorada legibilidad.
 *    - 004: Se añadieron validaciones de campos vacíos en login y registro.
 *    - 005: Se corrigió carga de datos en panel de menú para usuarios y administradores.
 * ------------------------------------------------------------
 */

/* 
 * Fecha de Modificación: 27/09/2025
 * Modificado por: Diego
 * Nro. Orden de Trabajo: 004
 * Descripción:
 *    - Se añadió la validación de campos vacíos en los formularios
 *      de registro e inicio de sesión para evitar errores de entrada.
 *    - Ahora se muestran mensajes de advertencia cuando el usuario
 *      intenta continuar con campos incompletos.
 *    - Se añadió confirmación visual al registrar un usuario con éxito.
 *
 */

public class ControlVentana implements ActionListener {

    private Ventana ventana;
    private LogicaNegocio logica;
    private boolean mostrando = false; // Para mostrar u ocultar contraseña

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
        ventana.pack(); // Ajusta la ventana al tamaño de sus componentes
        ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventana.setVisible(true); // Siempre después de pack()
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
        // eventos a tarjetas de vehiculo
        for (Component comp : ventana.panelVehiculos.panelContenido.getComponents()) {
            if (comp instanceof PanelItemVehiculo panelItemVehiculo) {
                panelItemVehiculo.bBorrar.addActionListener(this);
                panelItemVehiculo.bEditar.addActionListener(this);
            }
        }
        
        ventana.setVisible(true);
    }

    /**
     * Limpia los campos de texto en todos los paneles de la interfaz.
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
     * Muestra el panel correspondiente según el tipo de usuario.
     * 
     * @param persona Persona autenticada (Usuario, Administrador, etc.)
     */
    public void mostrarPanel(Persona persona){
        switch (persona.getRol()) {
            case "Proveedor de Insumos":                
                // Implementación futura
                break;
            case "Proveedor de Servicios":                           
                // Implementación futura
                break;
            case "Administrador":
                // Mostrar panel de menú con datos del administrador
                ventana.mostrarPanel("MENU_PANEL");
                ventana.panelMenu.cNombre.setText(persona.getNombre());
                ventana.panelMenu.cApellido.setText(persona.getApellido());
                ventana.panelMenu.cCedula.setText(persona.getCedula());
                ventana.panelMenu.cCorreo.setText(persona.getCorreo());
                ventana.panelMenu.cNumero.setText(persona.getNumero());
                ventana.panelMenu.cMembresia.setText(persona.getMembresia());

                ventana.panelMenu.cNombre.setEditable(false);
                ventana.panelMenu.cApellido.setEditable(false);
                ventana.panelMenu.cCedula.setEditable(false);
                ventana.panelMenu.cCorreo.setEditable(false);
                ventana.panelMenu.cNumero.setEditable(false);
                ventana.panelMenu.cMembresia.setEditable(false);
                break;
            case "Usuario":
                boolean aprobado = ((Usuario) persona).isAprobado();
                if(!aprobado){
                    // No mostrar panel si usuario no aprobado
                    ventana.mostrarMensajeDialogo(ventana, "Tu cuenta aún no ha sido aprobada por el administrador.");
                    break;
                }
                ventana.mostrarPanel("MENU_PANEL");

                ventana.panelMenu.cNombre.setText(persona.getNombre());
                ventana.panelMenu.cApellido.setText(persona.getApellido());
                ventana.panelMenu.cCedula.setText(persona.getCedula());
                ventana.panelMenu.cCorreo.setText(persona.getCorreo());
                ventana.panelMenu.cNumero.setText(persona.getNumero());
                ventana.panelMenu.cMembresia.setText(persona.getMembresia());

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
     * Responde a los eventos generados por los botones de la interfaz.
     * 
     * @param e evento generado por el usuario
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Mostrar u ocultar contraseña
        if ("mostrarContrasena".equals(e.getActionCommand())) {
            if (mostrando) {
                ventana.panelLogin.cContrasena.setEchoChar('•');
                ventana.panelLogin.bMostrarContrasena.setText("👁");
                mostrando = false;
            } else {
                ventana.panelLogin.cContrasena.setEchoChar((char) 0);
                ventana.panelLogin.bMostrarContrasena.setText("🔒");
                mostrando = true;
            }
        }

        String cmd = e.getActionCommand();
        /**
         * el comado subespecializado nos dice que hay una accion
         * con un dato que es un identificador unico o como lo definan
         * en la implementacion.
         * primero las palabras del comando pegadas y separadas
         * del dato por un guion "-"
         * Ejemplo: EditarCarro-1
         * Comando EidtarCarro y 1 en este caso el id del carro a editar
         */        
        String[] comandosubespecializado = {"",""};
        if(cmd.contains("-")){
            // guardamos la informacion del comando
            comandosubespecializado = cmd.split("-");
            // si hay mas de dos elementos significa que el comando esta bien hecho
            if(comandosubespecializado.length > 1){
                // el comando se asigna, siempre estara en la primera posicion            
                cmd = comandosubespecializado[0];
            }
            
        }
        
        switch (cmd) {
            case "Registrese":
                ventana.mostrarPanel("REGISTRO_PANEL");
                break;

            case "Registrar":
                String nombre = ventana.panelRegistro.cNombre.getText().trim();
                String apellido = ventana.panelRegistro.cApellido.getText().trim();
                String cedula = ventana.panelRegistro.cCedula.getText().trim();
                String numero = ventana.panelRegistro.cNumero.getText().trim();
                String correo = ventana.panelRegistro.cCorreo.getText().trim();
                String membresia = ventana.panelRegistro.cMembresia.getText().trim();
                String contraseña = ventana.panelRegistro.cContrasena.getText().trim();

                if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || numero.isEmpty()
                        || correo.isEmpty() || membresia.isEmpty() || contraseña.isEmpty()) {
                    ventana.mostrarMensajeDialogo(ventana, "Por favor complete todos los campos antes de registrarse.");
                    break;
                }

                logica.crearUsuario(nombre, apellido, cedula, numero, correo, membresia, contraseña);
                limpiarCampos();
                ventana.mostrarPanel("LOGIN_PANEL");
                ventana.mostrarMensajeDialogo(ventana, "Registro exitoso. Espere la aprobación del administrador.");
                break;

            case "Iniciar Sesion":
                String cedula1 = ventana.panelLogin.cUsuario.getText().trim();
                String contrasena = new String(ventana.panelLogin.cContrasena.getPassword()).trim();

                if (cedula1.isEmpty() || contrasena.isEmpty()) {
                    ventana.mostrarMensajeDialogo(ventana, "Debe ingresar su cédula y contraseña para continuar.");
                    break;
                }

                Persona p = logica.login(cedula1, contrasena);

                if (p != null) {
                    mostrarPanel(p);
                } else {
                    String mensaje = logica.getUltimoMensajeLogin();
                    if (mensaje == null || mensaje.isBlank()) {
                        mensaje = "Error en el inicio de sesión.";
                    }
                    ventana.mostrarMensajeDialogo(ventana, mensaje);
                }
                break;

            case "Vehiculos":
                ventana.mostrarPanel("PANEL_VEHICULOS_USUARIO");
                break;
            case "Vehiculo":
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
            case "ActualizarListaVehiculosUsuario":
                // repintar la interfaz
                break;             
            // comando subespecializado
            case "BorrarVehiculo":
                String vehiculoABorrar = comandosubespecializado[1];                
                break;
            case "EditarVehiculo":
                String vehiculoAEditar = comandosubespecializado[1];                
                break;
             
        }
    }
}
