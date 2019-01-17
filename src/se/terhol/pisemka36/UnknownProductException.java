package se.terhol.pisemka36;

/**
 * Automat does not sell required product.
 * 
 * @author Radek Oslejsek
 * @version 2011-02-08
 */
public class UnknownProductException extends AutomatException {

    /**
     * Creates a new instance of <code>UnknownProductException</code> without detail message.
     */
    public UnknownProductException() {
        super("Unknown product");
    }
    
    /**
     * Creates a new instance of <code>UnknownProductException</code> with detail message.
     * @param msg the detail message.
     */
    public UnknownProductException(String msg) {
        super(msg);
    }
}
