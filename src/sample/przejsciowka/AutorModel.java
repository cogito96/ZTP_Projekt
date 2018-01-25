package sample.przejsciowka;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BazaDanych;
import sample.models.Autor;

import java.util.List;

public class AutorModel {


    public ObjectProperty<Autor> autorProperty = new SimpleObjectProperty<>(new Autor());

    public ObservableList<Autor> autorObservableList = FXCollections.observableArrayList();

    public void init()
    {
        BazaDanych bazaDanych =  BazaDanych.getBaza();
        this.autorObservableList.clear();
        this.autorObservableList.addAll(bazaDanych.listaAutorow);
    }


    public Autor getAutorProperty() {
        return autorProperty.get();
    }

    public ObjectProperty<Autor> autorPropertyProperty() {
        return autorProperty;
    }

    public void setAutorProperty(Autor autorProperty) {
        this.autorProperty.set(autorProperty);
    }

    public ObservableList<Autor> getAutorObservableList() {
        return autorObservableList;
    }

    public void setAutorObservableList(ObservableList<Autor> autorObservableList) {
        this.autorObservableList = autorObservableList;
    }

}
