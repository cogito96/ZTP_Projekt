package sample.przejsciowka;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BazaDanych;
import sample.dekorator.Ksiazka;
import sample.metodaFabrykujaca.typyOsob.Administrator;

public class ListaSkonczonychKsiazekModel {

    ObservableList<Ksiazka> ksiazkaSprzedanaObservableList = FXCollections.observableArrayList();


    public void init ()
    {
        BazaDanych bazaDanych = BazaDanych.getBaza();
        this.ksiazkaSprzedanaObservableList.clear();
      //  this.ksiazkaSprzedanaObservableList.addAll(bazaDanych.getOsobaZalogowana().getListaKsiazekSprzedanych());
    }

    public ObservableList<Ksiazka> getKsiazkaObservableList() {
        return ksiazkaSprzedanaObservableList;
    }

}
