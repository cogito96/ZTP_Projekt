package sample.kontrolery;

import javafx.event.ActionEvent;

import java.io.IOException;

public class GorneMenuAdministratorKontroler {

    private MojAdministrator mojAdministrator;

    public void setMojAdministrator(MojAdministrator mojAdministrator) {
        this.mojAdministrator = mojAdministrator;
    }


    public void dodajOsobe(ActionEvent actionEvent) throws IOException {
        mojAdministrator.setCenter("/sample/widoki/widokRejestracja.fxml");

    }

    public void wyswietlListeSprzedazy(ActionEvent actionEvent) {

    }
}
