package sample.kontrolery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.BazaDanych;
import sample.models.Kategoria;
import sample.przejsciowka.KategoriaModel;

import java.io.*;

public class DodajKategorieKontroler implements Serializable{

    @FXML
    public Button dodajKategorieButton;
    @FXML
    public TextField kategoriaTextField;
    @FXML
    public ComboBox<Kategoria> kategoriaComboBox;
    @FXML
    public Button usunKategorieButton;

    private BazaDanych bazaDanych;

    private KategoriaModel kategoriaModel;

    private Kategoria kategoria;

    public void dodajKategorie(ActionEvent actionEvent) {



        String nazwaKategorii = kategoriaTextField.getText();
        dodaj(nazwaKategorii);
    }

    @FXML
    public void usunKategorie(ActionEvent actionEvent) {

        this.kategoriaModel.init();
    }

    @FXML
    public void initialize ()
    {
        this.kategoriaModel = new KategoriaModel();
        this.bazaDanych = BazaDanych.getBaza();
        this.kategoriaModel.init();
        kategoriaComboBox.setItems(this.kategoriaModel.getKategoriaObservableList());
        dodajKategorieButton.disableProperty().bind(kategoriaTextField.textProperty().isEmpty());
    }




    private void dodaj (String nazwaKategorii)
    {
        kategoria = new Kategoria();
        kategoria.setNazwaKategorii(nazwaKategorii);
        bazaDanych.dodajKategorie(kategoria);
        kategoriaModel.init();
        kategoriaTextField.clear();
    }
}
