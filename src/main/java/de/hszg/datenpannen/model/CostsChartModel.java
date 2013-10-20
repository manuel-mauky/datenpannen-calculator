package de.hszg.datenpannen.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.chart.XYChart;

/**
 * DataModel für das Kosten-Line-Chart.
 */
public class CostsChartModel {

    private StringProperty title = new SimpleStringProperty();

    private XYChart.Series totalSeries = new XYChart.Series<>();

    private XYChart.Series regressionSeries = new XYChart.Series<>();

    public StringProperty titleProperty(){
        return title;
    }

    public void setTitle(String title){
        this.title.set(title);
    }

    public String getTitle(){
        return title.get();
    }

    public XYChart.Series totalSeriesProperty(){
        return totalSeries;
    }

    public XYChart.Series regressionSeriesProperty(){
        return regressionSeries;
    }
}
