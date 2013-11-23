package de.hszg.datenpannen.dataloss.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * DataModel für das Verteilungs-Pie-Chart.
 */
public class DistributionChartModel {

    private StringProperty title = new SimpleStringProperty();

    private ObservableList<PieChart.Data> distribtutionData = FXCollections.observableArrayList();

    @Inject
    private DatalossResult result;

    DistributionChartModel(DatalossResult result){
        this();
        this.result = result;
        initialize();
    }

    public DistributionChartModel(){
    }

    @PostConstruct
    void initialize(){
        title.set("Aufteilung der Kosten");
        distribtutionData.addAll(new PieChart.Data("Malicious or criminal attack", 48),
                new PieChart.Data("System Glich", 16),
                new PieChart.Data("Human factor", 36));

    }

    public StringProperty title(){
        return title;
    }

    public ObservableList<PieChart.Data> distribtutionData(){
        return distribtutionData;
    }
}
