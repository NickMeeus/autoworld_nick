package be.vdab.voertuigen;


import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;

public class Pickup extends Personenwagen implements Laadbaar {
    Volume laadvolume;
    
    public Pickup(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Volume laadvolume, Mens bestuurder) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur, bestuurder);
        setLaadvolume(laadvolume);
    }
    
    public Pickup(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Volume laadvolume, Mens bestuurder, Mens... inzittenden) {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur, bestuurder, inzittenden);
        setLaadvolume(laadvolume);
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
        return super.toString() + " " + laadvolume;
    }
    
    @Override
    public int getMAX_ZITPLAATSEN() {
        return MAX_ZITPLAATSEN;
    }
    
    @Override
    public Rijbewijs[] getToegestaneRijbewijzen() {
        return super.getToegestaneRijbewijzen();
    }
}
