package de.hszg.datenpannen.view.statistics;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für die Statistik-View. Hier werden die Charts mit den darzustellenden Daten
 * verbunden.
 */
public class StatisticsPresenter implements Initializable{

    public StatisticsPresenter(){
        System.out.println("Statistics Presenter Constructor");
    }

    /**
     * Das Torten-Diagramm, welches die Aufteilung der Kosten anzeigt.
     */
    @FXML
    private PieChart distributionChart;

    /**
     * Das Linien-Diagramm, welches die Tatsächlichen Kosten anzeigt.
     */
    @FXML
    private LineChart<Integer, Integer> costsChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("StatisticsPresenter initialized");

        initializeDistributionChart();

        initializeCostsChart();

    }

    /**
     * Erzeugt Dummy-Daten für das Kosten-Chart.
     */
    private void initializeCostsChart() {
        costsChart.setTitle("Kosten");

        XYChart.Series total = new XYChart.Series();
        total.setName("Total");

        total.getData().add(new XYChart.Data(1,1000));
        total.getData().add(new XYChart.Data(3,4000));
        total.getData().add(new XYChart.Data(8,2000));
        total.getData().add(new XYChart.Data(12,5000));
        total.getData().add(new XYChart.Data(16,7000));
        total.getData().add(new XYChart.Data(19,2000));
        total.getData().add(new XYChart.Data(21,8000));
        total.getData().add(new XYChart.Data(25,5000));
        total.getData().add(new XYChart.Data(27,8000));
        total.getData().add(new XYChart.Data(30,9000));
        total.getData().add(new XYChart.Data(31,11000));

        costsChart.getData().add(total);


        XYChart.Series regression = new XYChart.Series();
        regression.setName("Regression");

        regression.getData().add(new XYChart.Data(1,1000));
        regression.getData().add(new XYChart.Data(10,4000));
        regression.getData().add(new XYChart.Data(20,6000));
        regression.getData().add(new XYChart.Data(31,8000));

        costsChart.getData().add(regression);
    }

    /**
     * Erzeugt Dummy-Daten für das Verzeilungs-Chart.
     */
    private void initializeDistributionChart() {
        ObservableList<PieChart.Data> distributionData = FXCollections.observableArrayList(
                new PieChart.Data("Malicious or criminal attack", 48),
                new PieChart.Data("System Glich", 16),
                new PieChart.Data("Human factor", 36)
        );

        distributionChart.setTitle("Aufteilung der Kosten");
        distributionChart.setData(distributionData);
    }
}
