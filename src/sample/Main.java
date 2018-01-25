package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import sample.dekorator.Ksiazka;
import sample.dekorator.NormalnaKsiazka;
import sample.dekorator.Nowosc;
import sample.models.Kategoria;

public class Main extends Application {

    static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{

      //  FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/sample/widoki/GlownyPanelPracownika.fxml"));

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/sample/widoki/widokLogowania.fxml"));

   //     FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/sample/widoki/GlownyPanelAdmisratora.fxml"));

        Parent borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Biblioteka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
