package sample.kontrolery;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import sample.metodaFabrykujaca.typyOsob.Administrator;

import java.io.IOException;

public class MojAdministrator {


    @FXML
    public BorderPane borderPaneAdmin;

    @FXML
    private GorneMenuAdministratorKontroler topMenuAdminButtonsController;



    @FXML
    private void initialize ()
    {
        topMenuAdminButtonsController.setMojAdministrator(this);
    }


    public  void setCenter(String fxmlPath ) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = loader.load();
        borderPaneAdmin.setCenter(parent);
    }
}
