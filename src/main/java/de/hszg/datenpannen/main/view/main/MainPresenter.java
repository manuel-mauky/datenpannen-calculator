package de.hszg.datenpannen.main.view.main;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für die Main-View. Diese Klasse kann höchst wahrscheinlich später
 * gelöscht werden, da die main.fxml ausschließlich die Aufgabe hat, das Layout
 * der Anwendung zu definieren und sonst keine Funktionalität umsetzt.
 */
public class MainPresenter implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("MainPresenter initialized");
    }
}
