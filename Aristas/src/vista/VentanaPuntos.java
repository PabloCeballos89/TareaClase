/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Arista;
import modelo.Aristas;
import modelo.DialogAñadeAristas;
import modelo.PanelPuntos;
import modelo.Puntos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class VentanaPuntos extends JFrame {

    // modelo
    private Puntos puntos = new Puntos();
    private Aristas aristas = new Aristas();
// componentes
    private JButton bAñadeAristas = new JButton("Añade Aristas");
    private PanelPuntos panelPuntos = new PanelPuntos(puntos, aristas);

// diálogo para añadir aristas
    private DialogAñadeAristas diálogoAñadeArista = new DialogAñadeAristas(this);

    /**
     *
     *
     * Constructor de la ventana
     */
    public VentanaPuntos() {
        super("Une Puntos");
// distribuye componentes (no se pedía en el examen)
// Panel en el centro
        add(panelPuntos, BorderLayout.CENTER);
// Botón en el sur dentro de un flow 
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAñadeAristas);
        add(pB, BorderLayout.SOUTH);

// añade manejadores
        bAñadeAristas.addActionListener(new manejadorBotónAñade());

// finaliza configuración de la ventana 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

//Manejador del botón que permite añadir aristas 
    private class manejadorBotónAñade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
// muestra el diálogo
            int[] ptos = diálogoAñadeArista.muestra();
// si retorna null es porqué el usuario ha cancelado el // diálogo o ha ocurrido algún otro problema 
            if (ptos != null) {
                for (int i = 0; i < ptos.length - 1; i++) // añade cada arista
                {
                    aristas.añade(new Arista(puntos.punto(ptos[i]), puntos.punto(ptos[i + 1])));
                }

// repinta el panel 
                panelPuntos.repaint();
            }
        }

    }
//Método main. Crea la ventana principal de la aplicación */

    public static void main(String[] args) {
        new VentanaPuntos();

    }

}
