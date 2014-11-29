/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Lalo
 */
public class ExcepcionObjetoDesconocido extends Exception {

    /**
     *En caso de que un objeto no se encuentre en memoria, se lanza esta excepción.
     */
    public ExcepcionObjetoDesconocido() {
        super("Objeto desconocido, el objeto que quiere no se encuentra actualmente en la memoria");
    }
}
