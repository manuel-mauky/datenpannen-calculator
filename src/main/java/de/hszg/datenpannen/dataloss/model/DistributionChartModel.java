package de.hszg.datenpannen.dataloss.model;

import de.hszg.datenpannen.main.view.main.MainView;
import de.hszg.datenpannen.utils.ResourceBundleWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ResourceBundle;

/**
 * DataModel für das Verteilungs-Pie-Chart.
 */
public class DistributionChartModel {

    private StringProperty title = new SimpleStringProperty();

    private ObservableList<PieChart.Data> distribtutionData = FXCollections.observableArrayList();

    @Inject
    private DatalossResult result;

    @Inject
    private ResourceBundleWrapper resourceBundleWrapper;


    DistributionChartModel(DatalossResult result){
        this();
        this.result = result;
        initialize();
    }

    public DistributionChartModel(){
    }

    @PostConstruct
    void initialize(){
        title.set(resourceString("dataloss.statistics.distributionChart.title"));

        for (CostDistribution costDistribution : CostDistribution.values()) {
            PieChart.Data element = new PieChart.Data(costDistribution.toString(), 0);
            element.pieValueProperty().bind(result.getAvgDistributionCost(costDistribution));

            distribtutionData.add(element);
        }
    }

    String resourceString(String key){
        ResourceBundle bundle = resourceBundleWrapper.getResourceBundleFor(MainView.class);
        return bundle.getString(key);
    }

    public StringProperty title(){
        return title;
    }

    public ObservableList<PieChart.Data> distribtutionData(){
        return distribtutionData;
    }
}
