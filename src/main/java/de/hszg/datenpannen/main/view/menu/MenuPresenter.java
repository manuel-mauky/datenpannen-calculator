package de.hszg.datenpannen.main.view.menu;

import de.hszg.datenpannen.main.view.dialogues.AboutView;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für das Menü. Hier werden alle Aktionen, die über das Menü
 * ausführbar sind, koordiniert.
 */
public class MenuPresenter implements Initializable {

    public void about(){
        System.out.println("about");

        AboutView aboutView = new AboutView();
        Parent aboutNode = aboutView.getView();

        Stage aboutStage = new Stage();
        aboutStage.setScene(new Scene(aboutNode));
        aboutStage.show();

    }

    public void close(){
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("MenuPresenter initialized");
    }
}
