package de.hszg.datenpannen.virus.view.statistics;

import de.hszg.datenpannen.utils.Helper;
import de.hszg.datenpannen.virus.model.charts.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.shape.Line;
import javax.inject.Inject;

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

    @FXML
    private Line selectionLine;

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

        costsChart.getData().add(costsChartModel.selectionSeries());


        Helper.removeLineChartSymbol(costsChartModel.selectionSeries());
        Helper.fixTickFormatterForChart(costsChart);

        bindPieChart(costComponentChart, costComponentChartModel);
        bindPieChart(productivityLossChart, productivityLossChartModel);
        bindPieChart(directLaborChart, directLaborChartModel);
        bindPieChart(attackCostsChart, attackCostsChartModel);

    }

    private void bindPieChart(PieChart chart, PieChartModel model){
        chart.titleProperty().bind(model.title());
        chart.setData(model.data());
    }
}
