package de.hszg.datenpannen.view.statistics.virus;

import de.hszg.datenpannen.view.statistics.dataloss.*;
import de.hszg.datenpannen.model.dataloss.CostsChartModel;
import de.hszg.datenpannen.model.dataloss.DistributionChartModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für die Statistik-View. Hier werden die Charts mit den
 * darzustellenden Daten verbunden.
 */
public class StatisticsPresenter implements Initializable {

    public StatisticsPresenter() {
        System.out.println("Statistics Presenter Constructor");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("StatisticsPresenter initialized");


    }
}
