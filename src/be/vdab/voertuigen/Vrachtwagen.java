package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.util.Set;
import java.util.TreeSet;

public class Vrachtwagen extends Voertuig implements Laadbaar {
    static final int MAX_ZITPLAATSEN = 3;
    Volume laadvolume;
    int maximaalToegelatenMassa;
    int aantalAssen;
    
    public Vrachtwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen, Mens bestuurder) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder);
        if (zitplaatsen > MAX_ZITPLAATSEN)
            throw new IllegalArgumentException();
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }
    
    public Vrachtwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen, Mens bestuurder, Mens... inzittenden) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, inzittenden);
        if (zitplaatsen > MAX_ZITPLAATSEN)
            throw new IllegalArgumentException();
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }
    
    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }
    
    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }
    
    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }
    
    public int getAantalAssen() {
        return aantalAssen;
    }
    
    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }
    
    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + "assen:" + aantalAssen + ", maximaal toegelaten massa:" + maximaalToegelatenMassa + ", laadvolume:" + laadvolume;
    }
    
    @Override
    public int getMAX_ZITPLAATSEN() {
        return MAX_ZITPLAATSEN;
    }
    
    @Override
    public Rijbewijs[] getToegestaneRijbewijzen() {
        Set<Rijbewijs> r = new TreeSet();
        r.add(Rijbewijs.C);
        r.add(Rijbewijs.CE);
        return (Rijbewijs[])r.toArray(new Rijbewijs[r.size()]);
    }
}
