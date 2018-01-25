package sample.przejsciowka;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BazaDanych;
import sample.dekorator.Ksiazka;
import sample.models.Autor;
import sample.models.Kategoria;

public class KsiazkaModel {

    private ObjectProperty<Ksiazka> ksiazkaObjectProperty = new SimpleObjectProperty<>(new Ksiazka() {
        @Override
        public String getTagi() {
            return null;
        }

        @Override
        public int getCena() {
            return 0;
        }
    });

    private ObservableList<Kategoria>kategoriaObservableList = FXCollections.observableArrayList();
    private ObservableList<Autor>autorObservableList = FXCollections.observableArrayList();


    public void init()
    {
        BazaDanych bazaDanych = BazaDanych.getBaza();
        initKategoria(bazaDanych);
        initAutor(bazaDanych);
    }

    private void initKategoria (BazaDanych bazaDanych)
    {
        this.kategoriaObservableList.clear();
        this.kategoriaObservableList.addAll(bazaDanych.listaKategorii);
    }
    private void initAutor (BazaDanych bazaDanych)
    {
        this.autorObservableList.clear();
        this.autorObservableList.addAll(bazaDanych.listaAutorow);
    }

    public Ksiazka getKsiazkaObjectProperty() {
        return ksiazkaObjectProperty.get();
    }

    public ObjectProperty<Ksiazka> ksiazkaObjectPropertyProperty() {
        return ksiazkaObjectProperty;
    }

    public void setKsiazkaObjectProperty(Ksiazka ksiazkaObjectProperty) {
        this.ksiazkaObjectProperty.set(ksiazkaObjectProperty);
    }

    public ObservableList<Kategoria> getKategoriaObservableList() {
        return kategoriaObservableList;
    }

    public void setKategoriaObservableList(ObservableList<Kategoria> kategoriaObservableList) {
        this.kategoriaObservableList = kategoriaObservableList;
    }

    public ObservableList<Autor> getAutorObservableList() {
        return autorObservableList;
    }

    public void setAutorObservableList(ObservableList<Autor> autorObservableList) {
        this.autorObservableList = autorObservableList;
    }
}
