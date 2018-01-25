package sample.kontrolery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.BazaDanych;
import sample.dekorator.Ksiazka;
import sample.models.Autor;
import sample.models.Kategoria;
import sample.przejsciowka.ListaKsiazek;


import java.io.IOException;

public class PokazKsiazkiKontroler {
    @FXML
    public AnchorPane anchornPane;
    @FXML
    public Label wybranaKsiazka;
    @FXML
    public Button sprzedajButton;
    @FXML
    public Label cenaZaCaloscLabel;
    @FXML
    public TextField iloscKsiazekDoZakupuTextField;
    @FXML
    public Label maksymalnaIloscKsiazek;
    @FXML
    public Label napisMaksymalnaIloscProduktu;

    @FXML
    public TableView <Ksiazka> ksiazkiTableView;

    @FXML
    public TableColumn opisKolumna;

    @FXML
    public TableColumn iloscSztukKolumna;

    @FXML
    private TableColumn<Ksiazka, String > tytulKolumna ;

    @FXML
    private TableColumn<Ksiazka, Autor > autorKolumna;

    @FXML
    private TableColumn<Ksiazka , Kategoria > kategoriaKolumna;

    @FXML
    private TableColumn<Ksiazka, Integer > dlugoscWypozyczeniaKolumna;

    @FXML
    private TableColumn<Ksiazka, String  > tagiKolumna;

    private ListaKsiazek listaKsiazek;
    @FXML
    public void initialize ()
    {
        bazaDanych = BazaDanych.getBaza();
        this.listaKsiazek = new ListaKsiazek();
        this.listaKsiazek.init();
        this.ksiazkiTableView.setItems(this.listaKsiazek.getKsiazkaObservableList());
        this.tytulKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka,String >("tytul"));
        this.autorKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka, Autor>("autor"));
        this.opisKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka, String >("opis"));
        this.kategoriaKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka,Kategoria>("kategoria"));
        this.dlugoscWypozyczeniaKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka,Integer>("cenaZBonusami"));
        this.tagiKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tagi"));
        this.iloscSztukKolumna.setCellValueFactory(new PropertyValueFactory<Ksiazka,Integer>("iloscKsiazek"));

        sprzedajButton.disableProperty().bind(iloscKsiazekDoZakupuTextField.textProperty().isEmpty());
        anchornPane.setVisible(false);


    }

    private Ksiazka ksiazkaDoSprzedazy ;

    private BazaDanych bazaDanych;
    @FXML
    void sprzedaj(ActionEvent event) throws IOException {

        String sprzedaneEgzemplarzeNapis = iloscKsiazekDoZakupuTextField.getText();
        int sprzedaneEgzemplarze = Integer.parseInt(sprzedaneEgzemplarzeNapis);

        if(sprzedaneEgzemplarze < ksiazkaDoSprzedazy.getIloscKsiazek())
        {
            ksiazkaDoSprzedazy.setIloscKsiazek(ksiazkaDoSprzedazy.getIloscKsiazek() - sprzedaneEgzemplarze);
        }
        else if (sprzedaneEgzemplarze ==  ksiazkaDoSprzedazy.getIloscKsiazek())
        {
            ksiazkaDoSprzedazy.setIloscKsiazek(0);

            ksiazkaDoSprzedazy.powiadom();
            anchornPane.setVisible(false);
            bazaDanych.usunKsiazke(ksiazkaDoSprzedazy);
        }
        else {
            //zmieniaja sie kolory tekstów
            maksymalnaIloscKsiazek.setTextFill(Color.web("red"));
            napisMaksymalnaIloscProduktu.setTextFill(Color.web("red"));
        }
        this.listaKsiazek.init();
    }


    public void wybierzKsiazke(ActionEvent actionEvent) {
        ksiazkaDoSprzedazy = ksiazkiTableView.getSelectionModel().getSelectedItem();
        maksymalnaIloscKsiazek.setTextFill(Color.web("black"));
        napisMaksymalnaIloscProduktu.setTextFill(Color.web("black"));
        if(ksiazkaDoSprzedazy != null)
        {
            anchornPane.setVisible(true);
            maksymalnaIloscKsiazek.setText("" + ksiazkaDoSprzedazy.getIloscKsiazek());
            wybranaKsiazka.setText(ksiazkaDoSprzedazy.toString());
            String sprzedaneEgzemplarzeNapis = iloscKsiazekDoZakupuTextField.getText();
            int sprzedaneEgzemplarze = Integer.parseInt(sprzedaneEgzemplarzeNapis);
            int cenaZaCalosc = sprzedaneEgzemplarze * ksiazkaDoSprzedazy.getCenaZBonusami();
            cenaZaCaloscLabel.setText("" + cenaZaCalosc);

        }
        else
        {
            // tu jaks informacja "wybierz ksaizke

        }

    }
}
