package de.hszg.datenpannen.virus.view.statistics;

import de.hszg.datenpannen.virus.model.charts.*;
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
public class VirusStatisticsPresenter implements Initializable {

    @FXML
    private LineChart<Integer,Double> costsChart;

    @FXML
    private PieChart costComponentChart;
    @FXML
    private PieChart productivityLossChart;
    @FXML
    private PieChart directLaborChart;
    @FXML
    private PieChart attackCostsChart;

    @Inject
    private CostsChartModel costsChartModel;

    @Inject
    private CostComponentChartModel costComponentChartModel;
    @Inject
    private ProductivityLossChartModel productivityLossChartModel;
    @Inject
    private DirectLaborChartModel directLaborChartModel;
    @Inject
    private AttackCostsChartModel attackCostsChartModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costsChart.titleProperty().bind(costsChartModel.title());


        costsChart.getData().add(costsChartModel.avgSeries());
        costsChart.getData().add(costsChartModel.minSeries());
        costsChart.getData().add(costsChartModel.maxSeries());


        bindPieChart(costComponentChart,costComponentChartModel);
        bindPieChart(productivityLossChart,productivityLossChartModel);
        bindPieChart(directLaborChart,directLaborChartModel);
        bindPieChart(attackCostsChart,attackCostsChartModel);
    }

    private void bindPieChart(PieChart chart, PieChartModel model){
        chart.titleProperty().bind(model.title());
        chart.setData(model.data());
    }
}
