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
public class createException extends Exception {

    /**
     * Creates a new instance of <code>createException</code> without detail
     * message.
     */
    public createException() {
    }

    /**
     * Constructs an instance of <code>createException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public createException(String msg) {
        super(msg);
    }
}
