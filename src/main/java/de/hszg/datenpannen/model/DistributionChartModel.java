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

    public StringProperty titleProperty(){
        return title;
    }

    public void setTitle(String title){
        this.title.set(title);
    }

    public String getTitle(){
        return title.get();
    }

    public ObservableList<PieChart.Data> getDistribtutionData(){
        return distribtutionData;
    }

}
