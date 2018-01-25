package sample.kontrolery;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MojKontroler {


    @FXML
    public BorderPane borderPane;

    @FXML
    private GorneMenuKontroler topMenuButtonsController;

    @FXML
    private void initialize ()
    {
        topMenuButtonsController.setMojKontroler(this);
    }

    public  void setCenter(String fxmlPath ) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = loader.load();
        borderPane.setCenter(parent);
    }
}
