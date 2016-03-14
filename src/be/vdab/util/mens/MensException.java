package be.vdab.util.mens;

public class MensException extends RuntimeException {
    public MensException() {}
    
    public MensException(String melding) { 
        super(melding); 
    }
    
    public MensException(Throwable oorzaak) { 
        super(oorzaak); 
    }
    
    public MensException(String melding, Throwable oorzaak) { 
        super(melding, oorzaak);
    }
}
