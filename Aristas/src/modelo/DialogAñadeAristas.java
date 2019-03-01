/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo
 */
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

//Diálogo que permite introducir las aristas a añadir 
public class DialogAñadeAristas extends JDialog {

    // Botones
    private JButton bAceptar = new JButton("Aceptar");
    private JButton bOtroPto = new JButton("Otro Punto");
// campos de texto y etiquetas: su número no es fijo, ya que se 
// pueden crear con el botón bOtroPto 
    private LinkedList<JTextField> camposTexto = new LinkedList<JTextField>();
    private LinkedList<JLabel> etiquetas = new LinkedList<JLabel>();
// almacena los puntos introducidos en el diálogo y retornados 
// a la ventana principal 
    private int[] puntos = null;

//Constructor */
    public DialogAñadeAristas(JFrame owner) {
        super(owner, "Introduce aristas", true);

        setLayout(new GridLayout(0, 2));
// crea los campos de texto y las etiquetas de los 2 primeros puntos
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 0"));
        camposTexto.add(new JTextField());
        etiquetas.add(new JLabel("Punto 1"));

// distribuye componentes 
        add(bAceptar);
        add(bOtroPto);
        add(etiquetas.get(0));
        add(camposTexto.get(0));
        add(etiquetas.get(1));
        add(camposTexto.get(1));
// añade manejadores
        bAceptar.addActionListener(new ManejadorBotónAceptar());
        bOtroPto.addActionListener(new ManejadorBotónOtroPunto());
// fin de la configuración del diálogo 
        pack();
        setResizable(false);

    }
//muestra el diálogo
//@return puntos introducidos o nuil si el usuario cancela el
//diálogo 

    public int[] muestra() {
// pone los puntos a null. Se cambia su valor en el manejador del botón aceptar.
        puntos = null;
// hace visible el diálogo 
        setVisible(true);
// elimina posibles campos de texto creados por el usuario para 
// que la siguiente vez que aparezca el diálogo sólo tenga dos 
        while (camposTexto.size() > 2) {
            remove(camposTexto.removeLast());
            remove(etiquetas.removeLast());
        }
        pack(); // ajusta el diálogo a los nuevos componentes
// cuando se cierra los puntos introducidos están en "puntos" 
        return puntos;
    }

//Manejador del botón aceptar 
    private class ManejadorBotónAceptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            puntos = new int[camposTexto.size()];
            int i = 0;
            try {
                for (i = 0; i < camposTexto.size(); i++) {
                    puntos[i] = Integer.parseInt(camposTexto.get(i).getText());
                }
            } catch (NumberFormatException except) {
// tratamiento de errores (no exigido en el examen) 
                puntos = null;
                JOptionPane.showMessageDialog(null, "Error en punto " + i,
                        "Error en los datos", JOptionPane.ERROR_MESSAGE);
                return; // NO hace invisible el diálogo
            }
// hace invisible el diálogo 
            setVisible(false);
        }
    }

//Manejador del botón otro punto 
    private class ManejadorBotónOtroPunto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
// añade otra etiqueta y otro campo de texto 
            JLabel l = new JLabel("Punto " + camposTexto.size());
            etiquetas.add(l);
            add(l);
            JTextField tf = new JTextField();
            camposTexto.add(tf);
            add(tf);
// ajusta el tamaño del diálogo para que se vean los 
// nuevos componentes 
            pack();
        }
    }

}
