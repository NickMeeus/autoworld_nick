package be.vdab.util;

public class VolumeException extends RuntimeException {
    public VolumeException() {}
    
    public VolumeException(String melding) { 
        super(melding); 
    }
    
    public VolumeException(Throwable oorzaak) { 
        super(oorzaak); 
    }
    
    public VolumeException(String melding, Throwable oorzaak) { 
        super(melding, oorzaak);
    } 
}
