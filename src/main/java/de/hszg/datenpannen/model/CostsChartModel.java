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

    public CostsChartModel(){
        this.title.set("Kosten");

        totalSeries.setName("Total");
        totalSeries.getData().add(new XYChart.Data(1,1000));
        totalSeries.getData().add(new XYChart.Data(3,4000));
        totalSeries.getData().add(new XYChart.Data(8,2000));
        totalSeries.getData().add(new XYChart.Data(12,5000));
        totalSeries.getData().add(new XYChart.Data(16,7000));
        totalSeries.getData().add(new XYChart.Data(19,2000));
        totalSeries.getData().add(new XYChart.Data(21,8000));
        totalSeries.getData().add(new XYChart.Data(25,5000));
        totalSeries.getData().add(new XYChart.Data(27,8000));
        totalSeries.getData().add(new XYChart.Data(30,9000));
        totalSeries.getData().add(new XYChart.Data(31,11000));

        regressionSeries.setName("Regression");
        regressionSeries.getData().add(new XYChart.Data(1,1000));
        regressionSeries.getData().add(new XYChart.Data(10,4000));
        regressionSeries.getData().add(new XYChart.Data(20,6000));
        regressionSeries.getData().add(new XYChart.Data(31,8000));
    }

    public StringProperty title(){
        return title;
    }

    public XYChart.Series totalSeries(){
        return totalSeries;
    }

    public XYChart.Series regressionSeries(){
        return regressionSeries;
    }
}
