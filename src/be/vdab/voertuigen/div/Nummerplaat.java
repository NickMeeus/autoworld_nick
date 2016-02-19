package be.vdab.voertuigen.div;

import java.io.Serializable;

public class Nummerplaat implements Serializable, Comparable {
    private static final long serialVersionUID = 1L;
    
    private final String plaat;

    protected Nummerplaat(String plaat) { 
        this.plaat = plaat;
    }
    
    public String getPlaat() { 
        return plaat; 
    }
    
    @Override
    public String toString() {
        return plaat;
    }
    
    @Override
    public int hashCode() {
        return plaat.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Nummerplaat)) {
            return false;
        }
       Nummerplaat n = (Nummerplaat) o;
       return plaat.equals(n.getPlaat());
    }
    
    @Override
    public int compareTo(Object o) {
        Nummerplaat n = (Nummerplaat) o;
        return plaat.compareTo(n.getPlaat());
    }
}
