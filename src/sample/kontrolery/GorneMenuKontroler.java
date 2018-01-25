package sample.kontrolery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class GorneMenuKontroler {

    private MojKontroler mojKontroler;

    public void setMojKontroler(MojKontroler mojKontroler) {
        this.mojKontroler = mojKontroler;
    }

    @FXML
    void dodajKategorie(ActionEvent event) throws IOException {
        mojKontroler.setCenter("/sample/widoki/DodajKategorie.fxml");
    }

    @FXML
    void dodajKsiazke(ActionEvent event) throws IOException {

        mojKontroler.setCenter("/sample/widoki/DodajKsiazke.fxml");
    }

    @FXML
    void listaKsiazek(ActionEvent event) throws IOException {
        mojKontroler.setCenter("/sample/widoki/PokazKsiazki.fxml");
    }

    @FXML
    void idzKsiegarnia(ActionEvent event) throws IOException {
        mojKontroler.setCenter("/sample/widoki/Ksiegarnia.fxml");
    }

    public void dodajAutora(ActionEvent actionEvent) throws IOException {
        mojKontroler.setCenter("/sample/widoki/DodajAutora.fxml");
    }


}
