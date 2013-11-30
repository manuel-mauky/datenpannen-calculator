package de.hszg.datenpannen.main.view.dialogues;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ResourceBundle;

public class AboutPresenter{

    @FXML
    private Label aboutText;

    @FXML
    private ResourceBundle resources;

    public void initialize() {
        aboutText.setText(resources.getString("aboutText"));
    }
}
