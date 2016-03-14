package be.vdab.util;

import java.io.Serializable;

public class Volume implements Serializable, Comparable {
    private static final long serialVersionUID = 1L;
    
    final int hoogte;
    final int breedte;
    final int diepte;
    final Maat maat;
    
    public Volume(int hoogte, int breedte, int diepte, Maat maat) {
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.diepte = diepte;
        this.maat = maat;
        
        if (hoogte * breedte * diepte < 0)
            throw new VolumeException();
    }
    
    public int getHoogte() { return hoogte; }
    public int getBreedte() { return breedte; }
    public int getDiepte() { return diepte; }
    public Maat getMaat() { return maat; }
    
    public long getVolume() throws VolumeException {
        if (hoogte * breedte * diepte < 0)
            throw new VolumeException();
    
        return hoogte * breedte * diepte;
    }
    
    @Override
    public String toString() {
        return hoogte + "(h)x" + breedte + "(b)x" + diepte + "(d) " + maat;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(getVolume());
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Volume)) {
            return false;
        }
       Volume v = (Volume) o;
       
       return (hoogte == v.getHoogte() && breedte == v.getBreedte() && diepte == v.getDiepte() && maat.equals(v.getMaat()));
    }
    
    @Override
    public int compareTo(Object o) {
        Volume v = (Volume) o;
        long vol1 = getVolume();
        long vol2 = v.getVolume();
        
        if (maat == Maat.decimeter)
            vol1 *= 1000;
        
        if (maat == Maat.meter)
            vol1 *= 1000000;
        
        if (v.getMaat() == Maat.decimeter)
            vol2 *= 1000;
        
        if (v.getMaat() == Maat.meter)
            vol2 *= 1000000;
            
        
        if (vol1 - vol2 < 0) 
            return -1;
        
        if (vol1 - vol2 > 0) 
            return 1;
        
        return 0;
    }
}
