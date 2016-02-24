package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Voertuig implements Comparable {
    final Nummerplaat NUMMERPLAAT;
    final int zitplaatsen;
    String merk;
    int aankoopprijs;
    Set<Mens> inzittenden = new TreeSet<>();
    Datum datumEersteIngebruikname;
    Mens bestuurder;
    
    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder) throws MensException {
        this.zitplaatsen = zitplaatsen;
        setMerk(merk);
        setBestuurder(bestuurder);
        NUMMERPLAAT = DIV.INSTANCE.getNummerplaat();
        this.datumEersteIngebruikname = datumEersteIngebruikname;
        setAankoopprijs(aankoopprijs);
    }
    
    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... inzittenden) throws MensException {
        this.zitplaatsen = zitplaatsen;
        setMerk(merk);
        setBestuurder(bestuurder);
        NUMMERPLAAT = DIV.INSTANCE.getNummerplaat();
        setDatumEersteIngebruikname(datumEersteIngebruikname);
        setAankoopprijs(aankoopprijs);
        for (Mens m : inzittenden) {
            addIngezetene(m);
        }
    }
    
    protected String getMerk() { return merk; }
    protected void setMerk(String merk) { this.merk = merk; }
    
    protected int getAankoopprijs() { return aankoopprijs; }
    protected void setAankoopprijs(int aankoopprijs) { this.aankoopprijs = aankoopprijs; }
    
    protected abstract int getMAX_ZITPLAATSEN();
    
    protected int getZitplaatsen() { return zitplaatsen; }

    protected Mens getBestuurder() { return bestuurder; }
    
    protected void setBestuurder(Mens bestuurder) throws MensException { 
        if (inzittenden.contains(bestuurder)) {
            if (getToegestaneRijbewijzen().length == 0) {
                throw new MensException("Deze persoon beschikt niet over het juiste rijbewijs.");
            }
            this.bestuurder = bestuurder;
        } else {
            if (inzittenden.size() == zitplaatsen)
                throw new MensException("Er is geen ruimte meer voor een extra persoon.");
        
            if (getToegestaneRijbewijzen().length == 0) {
                throw new IllegalArgumentException();
            } else {
                this.bestuurder = bestuurder;
                addIngezetene(bestuurder);
            }
        }
    }
    
    protected Date getDatumEersteIngebruikname() { return datumEersteIngebruikname.getDatum(); }
    
    protected void setDatumEersteIngebruikname(Datum datumEersteIngebruikname) { this.datumEersteIngebruikname = datumEersteIngebruikname; }
    
    protected Nummerplaat getNummerplaat() { return NUMMERPLAAT; }
    
    protected Set<Mens> getIngezetenen() { return inzittenden; }
    
    protected void addIngezetene(Mens inzittende) throws MensException { 
        if (inzittenden.contains(inzittende)) {
            
        } else {
            if (inzittenden.size() == zitplaatsen)
                throw new MensException("Er is geen ruimte meer voor een extra persoon.");
            this.inzittenden.add(inzittende); 
        }
    }
    
    protected List<Mens> getIngezeteneExclusiefBestuurder() { 
        List<Mens> exclusief = new ArrayList<>();
        boolean eerste = true;
        for (Mens m : inzittenden) {
            if (!eerste)
                exclusief.add(m);
            eerste = false;
        }
        return exclusief;
    }
    protected boolean isIngezetene(Mens persoon) {
        for (Mens m : inzittenden) {
            if (persoon.equals(m))
                return true;
        }
        return false;
    }
    
    protected abstract Rijbewijs[] getToegestaneRijbewijzen();
    
    public interface SerializableComparator<T> extends Serializable, Comparator<T>{}
    
    public static SerializableComparator<Voertuig> getMerkComparator() {
        return new SerializableComparator<Voertuig>() {
            @Override
            public int compare(Voertuig v1, Voertuig v2) {
                return v1.getMerk().compareTo(v2.getMerk());
            }
        };
    }
    
    public static SerializableComparator<Voertuig> getAankoopprijsComparator() {
        return new SerializableComparator<Voertuig>() {
            @Override
            public int compare(Voertuig v1, Voertuig v2) {
                if (v1.getAankoopprijs() > v2.getAankoopprijs())
                    return 1;
                if (v1.getAankoopprijs() < v2.getAankoopprijs())
                    return -1;
                return 0;
            }
        };
    }
    
    @Override
    public String toString() {
        return merk + ", " + datumEersteIngebruikname + ", " + aankoopprijs + ", " + zitplaatsen + ", " + bestuurder + ", " + inzittenden; 
    }
    
    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Voertuig)) {
            return false;
        }
        Voertuig v = (Voertuig) o;
        return getNummerplaat().equals(v.getNummerplaat());
    }
    
    @Override
    public int hashCode() {
        return NUMMERPLAAT.hashCode();
    }
    
    @Override
    public int compareTo(Object o) {
        Voertuig v = (Voertuig) o;
        return getNummerplaat().compareTo(v.getNummerplaat());
    }
}
