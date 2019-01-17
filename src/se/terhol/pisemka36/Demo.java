package se.terhol.pisemka36;

import java.io.IOException;
import java.io.File;

public class Demo
{
    public static void main(String[] args) throws IOException, AutomatException {
        ICigaretteAutomat automat = new CigaretteAutomat(new File("init.txt"));
        
        automat.restock(new CigaretteBrand("Petra", 31), 2);
        automat.restock(new CigaretteBrand("Petra", 25), 2);
        automat.sell(new CigaretteBrand("Petra", 31), 3);
        try {
            automat.sell(new CigaretteBrand("Petra", 31), 3);
        } catch(OutOfStockException ex) {
            // ok
        }

        automat.save(System.out);
    }
}
