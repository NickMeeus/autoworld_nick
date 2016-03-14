package be.vdab.util;

public enum Maat {
    centimeter, decimeter, meter;
    
    @Override
    public String toString() {
        switch(this) {
            case centimeter: return "centimeter";
            case decimeter: return "decimeter";
            case meter: return "meter";
            default: throw new IllegalArgumentException();
        }
    }   
}
