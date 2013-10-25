package de.hszg.datenpannen.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * DataModel für das Verteilungs-Pie-Chart.
 */
public class DistributionChartModel {

    private StringProperty title = new SimpleStringProperty();

    private ObservableList<PieChart.Data> distribtutionData = FXCollections.observableArrayList();

    public DistributionChartModel(){
        title.set("Aufteilung der Kosten");
        distribtutionData.addAll(new PieChart.Data("Malicious or criminal attack", 48),
                new PieChart.Data("System Glich", 16),
                new PieChart.Data("Human factor", 36));
    }

    public StringProperty title(){
        return title;
    }

    public ObservableList<PieChart.Data> getDistribtutionData(){
        return distribtutionData;
    }
}
