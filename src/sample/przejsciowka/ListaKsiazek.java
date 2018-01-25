package sample.przejsciowka;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BazaDanych;
import sample.dekorator.Ksiazka;
import sample.models.Autor;
import sample.models.Kategoria;

public class ListaKsiazek {

    ObservableList<Ksiazka> ksiazkaObservableList = FXCollections.observableArrayList();


    public void init ()
    {
        BazaDanych bazaDanych = BazaDanych.getBaza();
        this.ksiazkaObservableList.clear();
        this.ksiazkaObservableList.addAll(bazaDanych.listaKsiazek);
    }

    public ObservableList<Ksiazka> getKsiazkaObservableList() {
        return ksiazkaObservableList;
    }

    public void setKsiazkaObservableList(ObservableList<Ksiazka> ksiazkaObservableList) {
        this.ksiazkaObservableList = ksiazkaObservableList;
    }

}
