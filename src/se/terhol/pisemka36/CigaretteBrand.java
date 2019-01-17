package se.terhol.pisemka36;

/**
 * Cigarettes (brand).
 * 
 * @author Radek Oslejsek
 * @version 2010-02-08
 */
public class CigaretteBrand {

    private String label;
    private int    price;

    /**
     * @param label label
     * @param price price of this type of cigarettes
     * @throws IllegalArgumentException if label is null or price is less than zero
     */
    public CigaretteBrand(String label, int price) {
        if (label == null) throw new IllegalArgumentException("label");
        if (price < 0) throw new IllegalArgumentException("price");
        this.label = label;
        this.price = price;
    }
    
    /**
     * @return label of this type of cigarettes
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return price of this type of cigarettes
     */
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof CigaretteBrand)) {
            return false;
        }
        
        CigaretteBrand cig = (CigaretteBrand) obj;
        
        return (this.label.equals(cig.label) && this.price == cig.price);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + label.hashCode();
        hash = 31 * hash + price;
        return hash;
    }    
}
