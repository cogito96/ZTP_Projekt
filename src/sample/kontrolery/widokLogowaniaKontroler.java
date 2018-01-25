package sample.kontrolery;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.BazaDanych;
import sample.metodaFabrykujaca.FabrykaAdministrator;
import sample.metodaFabrykujaca.FabrykaOsob;
import sample.metodaFabrykujaca.Osoba;
import sample.metodaFabrykujaca.typyOsob.E_Osoby;
import sample.singleton.StandardoweHaslo;

import java.io.IOException;

public class widokLogowaniaKontroler {

    @FXML
    public PasswordField hasloTextField;
    @FXML
    private TextField loginTextField;

    private Osoba osobaZalogowana;

    @FXML
    void zaloguj(ActionEvent event) throws IOException {
        StandardoweHaslo standardoweHaslo = StandardoweHaslo.getInsHaslo();
        BazaDanych bazaDanych = BazaDanych.getBaza();
        String login = loginTextField.getText();
        String haslo = hasloTextField.getText();

        for (Osoba osoba : bazaDanych.listaAdministratorow) {
            if (osoba.getLogin().equals(login) && osoba.getHaslo().equals(haslo))
            {
                bazaDanych.setOsobaZalogowana(osoba);
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/sample/widoki/GlownyPanelAdmisratora.fxml"));
                Parent parent = loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            }
        }

        for (Osoba osoba1 : bazaDanych.listaPracownikow) {
            if (osoba1.getLogin().equals(login) && osoba1.getHaslo().equals(haslo))
            {
                bazaDanych.setOsobaZalogowana(osoba1);
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/sample/widoki/GlownyPanelPracownika.fxml"));
                Parent parent = loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

}
