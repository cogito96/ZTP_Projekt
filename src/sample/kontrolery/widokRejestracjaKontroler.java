package sample.kontrolery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sample.BazaDanych;
import sample.metodaFabrykujaca.FabrykaAdministrator;
import sample.metodaFabrykujaca.FabrykaOsob;
import sample.metodaFabrykujaca.FabrykaSprzedawcow;
import sample.metodaFabrykujaca.Osoba;

import javax.swing.*;

public class widokRejestracjaKontroler {

    @FXML
    private TextField imieNoweKonto;

    @FXML
    private TextField nazwiskoNoweKonto;

    @FXML
    private TextField emailNoweKonto;

    @FXML
    private TextField loginNoweKonto;

    @FXML
    private PasswordField hasloNoweKonto;

    @FXML
    private RadioButton pracownikRadioButton;

    @FXML
    private ToggleGroup rodzajPracownika;

    @FXML
    private RadioButton administratorRadioButton;

    public void dodajPracownika(ActionEvent actionEvent) {
        BazaDanych bazaDanych = BazaDanych.getBaza();

        if(administratorRadioButton.isSelected())
        {
            FabrykaOsob fabrykaOsob = new FabrykaAdministrator();
            Osoba osoba = fabrykaOsob.stworz();
            osoba.setImie(imieNoweKonto.getText());
            osoba.setNazwisko(nazwiskoNoweKonto.getText());
            osoba.setEmail(emailNoweKonto.getText());
            osoba.setLogin(loginNoweKonto.getText());
            osoba.setHaslo(hasloNoweKonto.getText());
            bazaDanych.listaAdministratorow.add(osoba);
            JOptionPane.showMessageDialog(null, "Dodano administratora!");

        }
        else
        {
            FabrykaOsob fabrykaOsob = new FabrykaSprzedawcow();
            Osoba osoba = fabrykaOsob.stworz();
            osoba.setImie(imieNoweKonto.getText());
            osoba.setNazwisko(nazwiskoNoweKonto.getText());
            osoba.setEmail(emailNoweKonto.getText());
            osoba.setLogin(loginNoweKonto.getText());
            osoba.setHaslo(hasloNoweKonto.getText());
            bazaDanych.listaPracownikow.add(osoba);
            JOptionPane.showMessageDialog(null, "Dodano pracownika!");

        }

    }
}