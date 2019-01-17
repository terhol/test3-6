package se.terhol.pisemka36;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;


/**
 * Cigarette automat.
 * 
 * @author Radek Oslejsek
 * @version 2011-02-08
 */

public interface ICigaretteAutomat
{
    /**
     * Sells required number of cigarette packs to the customer (and reduces available number 
     * of packs in the automat).
     * 
     * @param cigarette cigarette brand to be sold
     * @param numPacks number of required packs
     * @throws IllegalArgumentException If the "numPacks" paramater is <= 0
     * @throws UnknownProductException If this automat does not sell this type of cigarettes
     * @throws OutOfStockException If there is not enough packs of required cigarettes in the automat
     */
    void sell(CigaretteBrand cigarette, int numPacks) throws UnknownProductException, OutOfStockException;

    /**
     * Restocks the automat (either adds a new cigarette brand or increases number of 
     * available packs of existing brand).
     * 
     * @param cigarette cigarette to be restocked
     * @param numPacks number of packs to be inserted into the automat
     * @throws NullPointerException if the cigarette parameter is null
     * @throws IllegalArgumentException if the numPacks parameter is less than zero
     */
    void restock(CigaretteBrand cigarette, int numPacks);

    /**
     * Writes cigarettes to given output stream. Data are written in text mode.
     * Each line consists of three records separated by single white space: 
     * (1) number of packs available in the automat, (2) price and 
     * (3) label of the cigarette brand. Example follows:
     * 
     * 3 28 Marlboro
     * 19 34 Lucky Strike
     * 
     * @param OutputStream os
     * @throws IOException on I/O failure
     */
    void save(OutputStream os) throws IOException;
    
    /**
     * Reads information about cigarettes from given input stream and inserts cigarette packs
     * to the automat. Data format: see the save() method.
     * 
     * @param InputStream is
     * @throws IOException on I/O failure or wrong format
     */
    void load(InputStream is) throws IOException;
}
