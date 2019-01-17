package se.terhol.pisemka36;

/**
 * Exceptions related to selling goods by means of automat.
 * 
 * @author Radek Oslejsek
 * @version 2011-02-08
 */
public class AutomatException extends Exception {

    /**
     * Constructs an instance of <code>AutomatException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AutomatException(String msg) {
        super(msg);
    }
}