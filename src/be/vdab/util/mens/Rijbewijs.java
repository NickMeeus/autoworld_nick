package be.vdab.util.mens;
import org.apache.commons.lang3.StringUtils;
public enum Rijbewijs {
    A, B, BE, C, CE, D, DE;
    
    @Override
    public String toString() {
        String returnValue=super.toString();
        if(super.toString().length()>1){
            returnValue=new StringBuilder().append(super.toString().charAt(0)+"+"+super.toString().charAt(1)).toString();
        }
        return returnValue;
    }   
}
