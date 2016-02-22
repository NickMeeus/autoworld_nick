package be.vdab.util;

public class DatumException extends Exception {
    public DatumException() {}
    
    public DatumException(String melding) { 
        super(melding); 
    }
    
    public DatumException(Throwable oorzaak) { 
        super(oorzaak); 
    }
    
    public DatumException(String melding, Throwable oorzaak) { 
        super(melding, oorzaak);
    }
}
