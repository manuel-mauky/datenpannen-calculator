package de.hszg.datenpannen.main.view.dialogues;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AboutPresenter implements Initializable {

    @FXML
    private Label aboutText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutText.setText(resourceBundle.getString("aboutText"));
    }
}
