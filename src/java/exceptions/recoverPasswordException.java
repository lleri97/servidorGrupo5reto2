/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author 2dam
 */
public class recoverPasswordException extends Exception {

    /**
     * Creates a new instance of <code>recoverPasswordException</code> without
     * detail message.
     */
    public recoverPasswordException() {
    }

    /**
     * Constructs an instance of <code>recoverPasswordException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public recoverPasswordException(String msg) {
        super(msg);
    }
}
