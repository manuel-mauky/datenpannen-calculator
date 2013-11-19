package de.hszg.datenpannen.virus.view.statistics;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für die Statistik-View. Hier werden die Charts mit den
 * darzustellenden Daten verbunden.
 */
public class VirusStatisticsPresenter implements Initializable {

    public VirusStatisticsPresenter() {
        System.out.println("Statistics Presenter Constructor");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("DatalossStatisticsPresenter initialized");


    }
}
