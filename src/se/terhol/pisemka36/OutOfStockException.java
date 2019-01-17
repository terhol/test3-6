package se.terhol.pisemka36;

/**
 * Product is not in the automat in required quantity.
 * 
 * @author Radek Oslejsek
 * @version 2011-02-08
 */
public class OutOfStockException extends AutomatException {

    /**
     * Creates a new instance of <code>OutOfStockException</code> without detail message.
     */
    public OutOfStockException() {
        super("Out of stock");
    }

    /**
     * Creates a new instance of <code>OutOfStockException</code> with detail message.
     * @param msg the detail message.
     */
    public OutOfStockException(String msg) {
        super(msg);
    }
}
