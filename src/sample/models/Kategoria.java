package sample.models;


import java.io.Serializable;

public class Kategoria implements Serializable {

    private String nazwaKategorii;

    public Kategoria(){}

    public Kategoria(String nazwaKategorii) {
        this.nazwaKategorii = nazwaKategorii;
    }

    public String getNazwaKategorii() {
        return nazwaKategorii;
    }

    public void setNazwaKategorii(String nazwaKategorii) {
        this.nazwaKategorii = nazwaKategorii;
    }

    @Override
    public String toString() {
        return nazwaKategorii;
    }
}
