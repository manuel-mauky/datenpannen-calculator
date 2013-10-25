package de.hszg.datenpannen.view.statistics;

import de.hszg.datenpannen.model.CostsChartModel;
import de.hszg.datenpannen.model.DistributionChartModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

import javax.inject.Inject;
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

    @Inject
    private CostsChartModel costsChartModel;

    @Inject
    private DistributionChartModel distributionChartModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("StatisticsPresenter initialized");

        costsChart.titleProperty().bindBidirectional(costsChartModel.title());
        costsChart.getData().add(costsChartModel.totalSeries());
        costsChart.getData().add(costsChartModel.regressionSeries());

        distributionChart.titleProperty().bindBidirectional(distributionChartModel.title());
        distributionChart.setData(distributionChartModel.getDistribtutionData());
    }

}
