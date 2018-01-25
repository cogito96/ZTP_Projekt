package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Autor implements Serializable{



    private String imieAutora;

    private String nazwiskoAutora;

    public Autor(String imieAutora, String nazwiskoAutora) {
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
    }

    public Autor() {
    }

    public String getImieAutora() {
        return imieAutora;
    }

    public void setImieAutora(String imieAutora) {
        this.imieAutora = imieAutora;
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora;
    }

    public void setNazwiskoAutora(String nazwiskoAutora) {
        this.nazwiskoAutora = nazwiskoAutora;
    }

    @Override
    public String toString() {
        return imieAutora +  nazwiskoAutora;
    }
}
