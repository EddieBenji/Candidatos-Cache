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
public class ExcepcionObjetoDuplicado extends Exception {

    /**
     * En caso de que un objeto ya exista en la memoria, se lanzará esta
     * excepción.
     *
     */
    public ExcepcionObjetoDuplicado() {
        super("El objeto que se intenta ingresar ya existe en la memoria");
    }

}
