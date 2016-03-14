package be.vdab.util.mens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Mens implements Serializable, Comparable {
    private static final long serialVersionUID = 1L;
    
    String naam;
    Set<Rijbewijs> rijbewijzen = new TreeSet();
    Collection collection = new ArrayList();
    
    public Mens(String naam, Rijbewijs ... r1) {
        setNaam(naam);
        rijbewijzen.addAll(Arrays.asList(r1));
    }
  
    public void setNaam(String naam) { this.naam = naam; }
    public String getNaam() { return naam; }
    
    public Rijbewijs[] getRijbewijs() {
        return rijbewijzen.toArray(new Rijbewijs[rijbewijzen.size()]);
    }
    
    //"Ammelie(B, B+E, C, C+E)"
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(naam);
        if(!rijbewijzen.isEmpty()){
            builder.append("(").append(StringUtils.join(rijbewijzen,", ")).append(")");
        }
        return builder.toString();
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
       
        if (naam.equals(m.naam)) {
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
        return naam.compareTo(m.naam);             
    }
}
