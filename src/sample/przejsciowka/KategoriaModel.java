package sample.przejsciowka;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.BazaDanych;
import sample.models.Kategoria;

import java.util.List;

public class KategoriaModel {

    private ObservableList<Kategoria> kategoriaObservableList = FXCollections.observableArrayList();

    public void init()
    {
        BazaDanych bazaDanych = BazaDanych.getBaza();
        this.kategoriaObservableList.clear();
        this.kategoriaObservableList.addAll(bazaDanych.listaKategorii);
    }


    public ObservableList<Kategoria> getKategoriaObservableList() {
        return kategoriaObservableList;
    }

    public void setKategoriaObservableList(ObservableList<Kategoria> kategoriaObservableList) {
        this.kategoriaObservableList = kategoriaObservableList;
    }



}
