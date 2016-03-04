
import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import static be.vdab.voertuigen.Voertuig.getAankoopprijsComparator;
import static be.vdab.voertuigen.Voertuig.getMerkComparator;
import be.vdab.voertuigen.Vrachtwagen;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedSet;
import java.util.TreeSet;


public class HoofdProgramma {

    public static void main(String[] args) throws DatumException {
        FileWriter file = null;
        BufferedWriter buffer = null;

        SortedSet<Voertuig> voertuigen = new TreeSet<Voertuig>();
        SortedSet<Voertuig> aankoopPrijsSort = new TreeSet<Voertuig>(getAankoopprijsComparator());
        SortedSet<Voertuig> merkSort = new TreeSet<Voertuig>(getMerkComparator());

        voertuigen.add(new Personenwagen("BMW", new Datum(1, 2, 2134), 25000, 2, Color.ORANGE, new Mens("Bernard", Rijbewijs.B)));
        voertuigen.add(new Personenwagen("Ford", new Datum(5, 9, 2015), 8800, 5, Color.DARK_GRAY, new Mens("Anita", Rijbewijs.BE)));
        voertuigen.add(new Pickup("Chevrolet", new Datum(10, 2, 2016), 23500, 4, Color.RED, new Volume(20, 30, 5, Maat.decimeter), new Mens("Jos", Rijbewijs.BE)));
        voertuigen.add(new Pickup("Ford", new Datum(7, 10, 2015), 21000, 5, Color.BLUE, new Volume(150, 200, 30, Maat.centimeter), new Mens("Marian", Rijbewijs.B)));
        voertuigen.add(new Vrachtwagen("DAF", new Datum(23, 12, 1975), 15000, 3, new Volume(3, 12, 4, Maat.meter), 7500, 18, new Mens("Herman", Rijbewijs.C)));
        voertuigen.add(new Vrachtwagen("MAN", new Datum(30, 7, 1999), 17500, 2, new Volume(25, 90, 30, Maat.decimeter), 5250, 6, new Mens("Hilde", Rijbewijs.CE)));
        
        for (Voertuig voertuig : voertuigen) {
            System.out.println(voertuig);
        }
        
        System.out.println();
        aankoopPrijsSort.addAll(voertuigen);

        for (Voertuig voertuig : aankoopPrijsSort) {
            System.out.println(voertuig);
        }
        
        System.out.println();
        merkSort.addAll(voertuigen);
                
        try (
            FileOutputStream fout = new FileOutputStream("/JPFProjecten1/autoworld_nick/wagenpark.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            
            for (Voertuig voertuig : merkSort) {
                oos.writeObject(voertuig);
            }
            oos.close();
        } catch (Exception ex) { ex.printStackTrace(); }
        
        try (
            FileInputStream fin = new FileInputStream("/JPFProjecten1/autoworld_nick/wagenpark.ser");
            ObjectInputStream ois = new ObjectInputStream(fin); )  {
            
            try {
                for(Voertuig test = (Voertuig)ois.readObject(); test != null;) {
                    System.out.println(test);
                    test = (Voertuig)ois.readObject();
                }
            } catch (EOFException ex) { }
        } catch (Exception  ex) { ex.printStackTrace(); }
    }
}
