package org.vista;

import org.modelo.GestorDelJuego;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private static VentanaPrincipal miVentanaPrincipal;

    private JPanel panelTableros;
    private JPanel panelControladoresPrincipal;

    private PanelTablero tableroJugador;
    private PanelTablero tableroEnemigo;

    private JPanelBarcos panelBarcos;
    private PanelOpciones panelMisiles;

    private VentanaPrincipal(){
        super("SUNKEN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(0, 0, 900, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        setLayout(new BorderLayout());

        // incluir los modulos de la vista
        panelTableros = new JPanel();
        panelControladoresPrincipal=new JPanel();

        panelTableros.setLayout(new GridLayout(2, 1, 0, 10));
        panelControladoresPrincipal.setLayout(new GridLayout(2,4,0,0));

        add(panelControladoresPrincipal,BorderLayout.EAST);
        add(panelTableros, BorderLayout.CENTER);

        tableroJugador = new PanelTablero(false);
        panelTableros.add(tableroJugador);

        tableroEnemigo = new PanelTablero(true);
        panelTableros.add(tableroEnemigo);

        panelBarcos = new JPanelBarcos();
        panelControladoresPrincipal.add(panelBarcos, BorderLayout.CENTER);

        panelMisiles = new PanelOpciones();
        panelControladoresPrincipal.add(panelMisiles, BorderLayout.CENTER);


        setVisible(true);

        GestorDelJuego.getInstance().actualizarIntefaz();
    }

    public static VentanaPrincipal getInstance(){
        if(VentanaPrincipal.miVentanaPrincipal==null){
            VentanaPrincipal.miVentanaPrincipal=new VentanaPrincipal();
        }
        return VentanaPrincipal.miVentanaPrincipal;
    }


}
