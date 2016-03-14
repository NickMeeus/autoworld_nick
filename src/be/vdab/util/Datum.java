package be.vdab.util;

import java.io.Serializable;

public final class Datum implements Serializable, Comparable<Datum> {

    final int dag;
    final int maand;
    final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        if (valideerDatum(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        } else {
            throw new DatumException();
        }
    }

    private boolean valideerDatum(int dag, int maand, int jaar) {
        int dvdm[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return jaar >= 1583 && jaar <= 4099
                && maand >= 1 && maand <= 12
                && dag >= 1 && dag <= (dvdm[maand - 1] + (isSchrikkeljaar(jaar) ? 1 : 0));
    }

    private boolean isSchrikkeljaar(int jaar) {
        return jaar % 4 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%4d", dag, maand, jaar);
    }

    @Override
    public int hashCode() {
        return toInt();
    }

    private int toInt() {
        return jaar * 10000 + maand * 100 + dag;
    }

    @Override
    public boolean equals(Object o) {
        if (o!=null && o.getClass() == this.getClass()) {
            return this.dag == ((Datum)o).dag &&
                   this.maand == ((Datum)o).maand &&
                   this.jaar == ((Datum)o).jaar;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Datum d) {
        return toInt()-d.toInt();
    }
}
