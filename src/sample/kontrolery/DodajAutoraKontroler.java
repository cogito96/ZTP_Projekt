package sample.kontrolery;

import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.BazaDanych;
import sample.metodaFabrykujaca.Osoba;
import sample.models.Autor;
import sample.przejsciowka.AutorModel;


public class DodajAutoraKontroler {
    @FXML
    public TextField ImieAutoraTextField;
    @FXML
    public TextField NazwiskoAutoraTextField;
    @FXML
    public Button dodajAutoraButton;

    @FXML
    private TableView<Autor> autorTableView;

    @FXML
    private TableColumn<Autor,String> imieKolumna;

    @FXML
    private TableColumn<Autor,String > nazwiskoKolumna;

    private AutorModel autorModel;

    private BazaDanych bazaDanych;


    public void dodajAutora(ActionEvent actionEvent) {
        String imie = ImieAutoraTextField.getText();
        String nazwisko = NazwiskoAutoraTextField.getText();
        dodaj(imie,nazwisko);
        this.autorModel.init();
        this.ImieAutoraTextField.clear();
        this.NazwiskoAutoraTextField.clear();
    }

    private void dodaj(String imie ,String nazwisko)
    {
        Autor autor = new Autor();
        autor.setImieAutora(imie);
        autor.setNazwiskoAutora(nazwisko);
        bazaDanych.dodajAutora(autor);

    }

    @FXML
    public void initialize()
    {
        this.bazaDanych = BazaDanych.getBaza();
        this.autorModel = new AutorModel();
        this.autorModel.init();
        dodajAutoraButton.disableProperty().bind(ImieAutoraTextField.textProperty().isEmpty().or(NazwiskoAutoraTextField.textProperty().isEmpty()));
        this.autorTableView.setItems(this.autorModel.getAutorObservableList());

        this.imieKolumna.setCellValueFactory(new PropertyValueFactory<Autor,String >("imieAutora"));
        this.nazwiskoKolumna.setCellValueFactory(new PropertyValueFactory<Autor,String >("nazwiskoAutora"));


        System.out.println(bazaDanych.getOsobaZalogowana());
    }

}
