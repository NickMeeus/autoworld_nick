package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class Personenwagen extends Voertuig {
    static final int MAX_ZITPLAATSEN = 8;
    Color kleur;
    
    public Personenwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder);
        if (zitplaatsen > MAX_ZITPLAATSEN)
            throw new IllegalArgumentException();
        setKleur(kleur);
    }
    
    public Personenwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... inzittenden) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, inzittenden);
        setKleur(kleur);
    }
    
    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }
    
    public Color getKleur() {
        return kleur;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + super.getZitplaatsen();
    }
    
    @Override
    public int getMAX_ZITPLAATSEN() {
        return MAX_ZITPLAATSEN;
    }
    
    @Override
    public Rijbewijs[] getToegestaneRijbewijzen() {
        Set<Rijbewijs> r = new TreeSet();
        r.add(Rijbewijs.B);
        r.add(Rijbewijs.BE);
        return (Rijbewijs[])r.toArray(new Rijbewijs[r.size()]);
    }
}
