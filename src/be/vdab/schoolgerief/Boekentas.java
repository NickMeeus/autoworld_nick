package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Serializable, Laadbaar {
    private static final long serialVersionUID = 1L;
    
    Volume laadvolume;
    String kleur;
    
    public Boekentas(String kleur, Volume laadvolume) {
        setLaadvolume(laadvolume);
        setKleur(kleur);
    }
    
    public void setKleur(String kleur) { 
        if (kleur == null)
            throw new IllegalArgumentException();
        this.kleur = kleur; 
    }
    
    public String getKleur() { return kleur; }
    
    @Override
    public void setLaadvolume(Volume laadvolume) { 
        if (laadvolume == null)
            throw new IllegalArgumentException();
        this.laadvolume = laadvolume; 
    }
    
    @Override 
    public Volume getLaadvolume() { return laadvolume; }
    
    @Override
    public String toString() {
        return "boekentas " + kleur + " " + laadvolume;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(kleur, laadvolume);
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Boekentas)) {
            return false;
        }
        Boekentas b = (Boekentas) o;
       
        return kleur.equals(b.kleur) && laadvolume.equals(b.laadvolume);
    }
}
