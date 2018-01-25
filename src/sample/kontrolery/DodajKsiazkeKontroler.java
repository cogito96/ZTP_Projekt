package sample.kontrolery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.BazaDanych;
import sample.dekorator.Bestseller;
import sample.dekorator.Ksiazka;
import sample.dekorator.NormalnaKsiazka;
import sample.dekorator.Nowosc;
import sample.metodaFabrykujaca.Osoba;
import sample.models.Autor;
import sample.models.Kategoria;

import javax.swing.*;

public class DodajKsiazkeKontroler {
    @FXML
    public TextArea opisTextArea;

    @FXML
    public Label cenaZaZamowienieLabel;

    @FXML
    public TextField iloscEgzemplarzyTextField;

    @FXML
    public TextField cenaKsiazkiTextField;

    @FXML
    private Label cenaZaKsiazkeLabel;

    @FXML
    private ComboBox<Kategoria> kategoriaComboBox;

    @FXML
    private TextField tytulTextField;

    @FXML
    private ComboBox<Autor> autorComboBox;

    @FXML
    private CheckBox bestsellerCheckBox;

    @FXML
    private CheckBox nowoscCheckBox;

    @FXML
    public CheckBox staraKsiazkaCheckBox;


    private Ksiazka ksiazka;

    private BazaDanych bazaDanych;


    @FXML
    public void initialize(){
        this.bazaDanych = BazaDanych.getBaza();
        this.kategoriaComboBox.getItems().addAll(this.bazaDanych.listaKategorii);
        this.autorComboBox.getItems().addAll(this.bazaDanych.listaAutorow);
        this.iloscEgzemplarzyTextField.setText(""+1);
    }


    public void dodajKsiazke(ActionEvent actionEvent)
    {
        String tytul = tytulTextField.getText();

        int cenaZaKsiazke = Integer.parseInt(cenaZaKsiazkeLabel.getText());
        String opis = opisTextArea.getText();
        Kategoria kategoria = kategoriaComboBox.getValue();
        Autor autor = autorComboBox.getValue();
        int ilscEgzemplarzy = Integer.parseInt(iloscEgzemplarzyTextField.getText());
        ksiazka.setTytul(tytul);
        ksiazka.setKategoria(kategoria);
        ksiazka.setAutor(autor);
        ksiazka.setCenaZBonusami(cenaZaKsiazke);
        ksiazka.setOpis(opis);
        ksiazka.setIloscKsiazek(ilscEgzemplarzy);
        System.out.println(ksiazka.getOpis());
        for (Osoba administrator : bazaDanych.listaAdministratorow) {
            ksiazka.dodajObserwatora(administrator);
        }
        bazaDanych.dodajKsiazke(ksiazka);
        JOptionPane.showMessageDialog(null, "Książka została dodana!");
    }


    public void liczCzasWypozyczenia (ActionEvent event)
    {
        this.ksiazka = new NormalnaKsiazka();
        if(bestsellerCheckBox.isSelected())
        {
            ksiazka = new Bestseller(ksiazka);
        }
        if(nowoscCheckBox.isSelected())
        {
            ksiazka = new Nowosc(ksiazka);
        }

        if(staraKsiazkaCheckBox.isSelected())
        {

        }
    }

    public void aktualizujDane(ActionEvent actionEvent) {
        if(ksiazka == null)
        {
            ksiazka = new NormalnaKsiazka();
        }
        int cenaZaKsiazke = Integer.parseInt(cenaKsiazkiTextField.getText());
        cenaZaKsiazke += ksiazka.getCena();
        cenaZaKsiazkeLabel.setText("" + cenaZaKsiazke);

        int ilsocEgzemplarzy = Integer.parseInt(iloscEgzemplarzyTextField.getText());
        int cenaZamowienia = ilsocEgzemplarzy*cenaZaKsiazke;
        cenaZaZamowienieLabel.setText("" + cenaZamowienia);
        ksiazka.setCenaZBonusami(cenaZaKsiazke);
    }
}
