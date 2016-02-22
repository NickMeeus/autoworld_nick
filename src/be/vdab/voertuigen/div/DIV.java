package be.vdab.voertuigen.div;

public enum DIV {
    INSTANCE;
    private int nummer;
    
    public Nummerplaat getNummerplaat() {
        if (++nummer == 1000) { nummer = 1; }
        
        String StrNr = Integer.toString(nummer);
        StringBuilder plaat = new StringBuilder();
        
        if (StrNr.length() == 1) {
            plaat.append("AAA00");
            plaat.append(StrNr);
        }
        if (StrNr.length() == 2) {
            plaat.append("AAA0");
            plaat.append(StrNr);
        }
        if (StrNr.length() == 3) {
            plaat.append("AAA");
            plaat.append(StrNr);
        }
        
        Nummerplaat nummerplaat = new Nummerplaat(plaat.toString());
        
        return nummerplaat;
    }
}
