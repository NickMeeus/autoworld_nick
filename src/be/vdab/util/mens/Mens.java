package be.vdab.util.mens;

import java.util.EnumSet;

public class Mens implements Comparable {
    String naam;
    EnumSet<Rijbewijs> rijbewijzen;
    boolean geenRijbewijzen = false;
    
    public Mens(String naam) {
        setNaam(naam);
        geenRijbewijzen = true;
    }
    
    public Mens(String naam, Rijbewijs rijbewijs) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2, Rijbewijs rijbewijs3) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2, rijbewijs3);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2, Rijbewijs rijbewijs3, Rijbewijs rijbewijs4) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2, rijbewijs3, rijbewijs4);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2, Rijbewijs rijbewijs3, Rijbewijs rijbewijs4, Rijbewijs rijbewijs5) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2, rijbewijs3, rijbewijs4, rijbewijs5);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2, Rijbewijs rijbewijs3, Rijbewijs rijbewijs4, Rijbewijs rijbewijs5, Rijbewijs rijbewijs6) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2, rijbewijs3, rijbewijs4, rijbewijs5, rijbewijs6);
    }
    
    public Mens(String naam, Rijbewijs rijbewijs1, Rijbewijs rijbewijs2, Rijbewijs rijbewijs3, Rijbewijs rijbewijs4, Rijbewijs rijbewijs5, Rijbewijs rijbewijs6, Rijbewijs rijbewijs7) {
        setNaam(naam);
        rijbewijzen = EnumSet.of(rijbewijs1, rijbewijs2, rijbewijs3, rijbewijs4, rijbewijs5, rijbewijs6, rijbewijs7);
    }
    
    public void setNaam(String naam) { this.naam = naam; }
    
    public String getNaam() { return naam; }
    
    public Object[] getRijbewijs() {
        return rijbewijzen.toArray();
    }
    
    @Override
    public String toString() {
        if (geenRijbewijzen) return naam;
        
        StringBuilder builder = new StringBuilder();
        int i = 1;
        boolean eerste = true;
        
        builder.append("(");
        for (Rijbewijs r : rijbewijzen) {
            if (i < rijbewijzen.size() && i++ != 1 && !r.toString().equals("A")) {
                if (eerste) {
                    builder.append(", ");
                    eerste = false;
                }
                builder.append(r);
                builder.append(", ");
            } else {
                builder.append(r);
            }
        }
        builder.append(")");
        
        return naam + builder.toString();
    }
    
    @Override
    public int hashCode() {
        return naam.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Mens)) {
            return false;
        }
        Mens m = (Mens) o;
       
        if (naam.equals(m.getNaam())) {
            if (getRijbewijs().length == m.getRijbewijs().length) {
                String mens1[] = new String[getRijbewijs().length];
                for (int i=0;i<getRijbewijs().length;i++) mens1[i]=getRijbewijs()[i].toString();
                
                String mens2[] = new String[m.getRijbewijs().length];
                for (int i=0;i<m.getRijbewijs().length;i++) mens2[i]=m.getRijbewijs()[i].toString();
                
                if (mens1[getRijbewijs().length - 1].equals(mens2[m.getRijbewijs().length - 1])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public int compareTo(Object o) {
        Mens m = (Mens) o;
        int i = naam.compareTo(m.getNaam());
        if (i != 0) return i;
        
        return getRijbewijs().length - m.getRijbewijs().length;              
    }
}
