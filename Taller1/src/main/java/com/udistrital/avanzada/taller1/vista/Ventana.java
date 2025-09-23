package com.udistrital.avanzada.taller1.vista;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(String title) {
        super(title);
    }

    @Override
    protected void frameInit() {
        super.frameInit();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

}