package be.vdab.util;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public final class Datum implements Serializable, Comparable {
    final int dag;
    final int maand;
    final int jaar;
    final Date datum;
    
    public Datum(int dag, int maand, int jaar) throws DatumException {
        try {
            if (jaar < 1583 || jaar > 4099) 
                throw new DatumException("Foutief/ongeldig jaartal opgegeven");
            if (maand < 1 || maand > 12) 
                throw new DatumException("Ongeldige maand opgegeven");
            if (dag < 1 || dag > 31) 
                throw new DatumException("Ongeldige dag opgegeven");
                
            LocalDate.of(jaar, maand, dag);
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
            Calendar kalender = Calendar.getInstance();
            kalender.set(jaar, maand -1, dag);
            this.datum = kalender.getTime();
        } catch (DateTimeException ex) {
            throw new DatumException(ex);
        }
    }
    
    public int getDag() { return dag; }
    public int getMaand() { return maand; }
    public int getJaar() { return jaar; }
    public Date getDatum() { return datum; }
    
    public String getDatumString() {
        String SDag = Integer.toString(dag);
        String SMaand = Integer.toString(maand);
        String SJaar = Integer.toString(jaar);
        
        StringBuilder date = new StringBuilder();
        if (dag < 10) {
            date.append("0");
            date.append(SDag);
        } else {
            date.append(SDag);
        }
        date.append("/");
        
        if (maand < 10) {
            date.append("0");
            date.append(SMaand);
        } else {
            date.append(SMaand);
        }
        date.append("/");
        date.append(SJaar);
        
        return date.toString();
    }
    
    @Override
    public String toString() { 
        return getDatumString(); 
    }
    
    @Override
    public int hashCode() {
        return getDatumString().hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Datum)) {
            return false;
        }
       Datum d = (Datum) o;
       
       return datum.equals(d.getDatum());
    }
    
    @Override
    public int compareTo(Object o) {
        Datum d = (Datum) o;
        
        return datum.compareTo(d.getDatum());
    }
}
