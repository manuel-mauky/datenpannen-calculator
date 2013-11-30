package de.hszg.datenpannen.dataloss.view.statistics;

import de.hszg.datenpannen.dataloss.model.CostsChartModel;
import de.hszg.datenpannen.dataloss.model.DistributionChartModel;
import de.hszg.datenpannen.utils.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Presenter für die Statistik-View. Hier werden die Charts mit den darzustellenden Daten verbunden.
 */
public class DatalossStatisticsPresenter{

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

    public void initialize() {
        costsChart.titleProperty().bindBidirectional(costsChartModel.title());
        costsChart.getData().add(costsChartModel.avgSeries());
        costsChart.getData().add(costsChartModel.minSeries());
        costsChart.getData().add(costsChartModel.maxSeries());
        costsChart.getData().add(costsChartModel.selectionSeries());


        Helper.removeLineChartSymbol(costsChartModel.selectionSeries());
        Helper.fixTickFormatterForChart(costsChart);

        distributionChart.titleProperty().bindBidirectional(distributionChartModel.title());
        distributionChart.setData(distributionChartModel.distribtutionData());
    }

}
