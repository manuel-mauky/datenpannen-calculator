package de.hszg.datenpannen.dataloss.view.statistics;

import de.hszg.datenpannen.dataloss.model.CostsChartModel;
import de.hszg.datenpannen.dataloss.model.DistributionChartModel;
import de.hszg.datenpannen.dataloss.model.UserinputModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
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
public class DatalossStatisticsPresenter implements Initializable{

    /**
     * Das Torten-Diagramm, welches die Aufteilung der Kosten anzeigt.
     */
    @FXML
    private PieChart distributionChart;

    /**
     * Das Linien-Diagramm, welches die Tatsächlichen Kosten anzeigt.
     */
    @FXML
    private LineChart<Integer, Double> costsChart;

    @Inject
    private CostsChartModel costsChartModel;

    @Inject
    private DistributionChartModel distributionChartModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costsChart.titleProperty().bindBidirectional(costsChartModel.title());
        costsChart.getData().add(costsChartModel.avgSeries());
        costsChart.getData().add(costsChartModel.minSeries());
        costsChart.getData().add(costsChartModel.maxSeries());

        distributionChart.titleProperty().bindBidirectional(distributionChartModel.title());
        distributionChart.setData(distributionChartModel.distribtutionData());
    }

}
