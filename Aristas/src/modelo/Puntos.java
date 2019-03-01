/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class Puntos {

    private ArrayList<Punto> puntos = new ArrayList<Punto>();

    /**
     * Crea una lista de puntos
     */
    public Puntos() {
//Lee los puntos existentes y les almacena en la lista "puntos"
    }

    /**
     * Retorna el punto que ocupa la posición i-ésima en la lista
     *
     * @param i posición del punto en la lista
     * @return el i-ésimo punto o null en caso de que el valor de i no
     * corresponda a ningún punto
     */
    public Punto punto(int i) {
        if (i < 0 || i >= puntos.size()) {
            return null;
        }
        return puntos.get(i);
    }

}
