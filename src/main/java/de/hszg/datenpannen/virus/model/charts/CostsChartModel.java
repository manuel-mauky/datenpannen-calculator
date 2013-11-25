package de.hszg.datenpannen.virus.model.charts;

import de.hszg.datenpannen.virus.model.UserInputModel;
import de.hszg.datenpannen.virus.model.VirusResult;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.chart.XYChart;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


import static de.hszg.datenpannen.utils.BindingHelper.*;

/**
 * DataModel für das Kosten-Linien-Diagramm für den Virenbefall.
 */
public class CostsChartModel {

    private StringProperty title = new SimpleStringProperty();

    private XYChart.Series avgSeries = new XYChart.Series<>();
    private XYChart.Series minSeries = new XYChart.Series<>();
    private XYChart.Series maxSeries = new XYChart.Series<>();

    private XYChart.Series selectionSeries = new XYChart.Series<>();


    @Inject
    private VirusResult result;

    @Inject
    private UserInputModel userInputModel;

    @PostConstruct
    void initialize(){
        title.set("Kostenübersicht");

        avgSeries.setName("Durchschnitt");
        minSeries.setName("Min");
        maxSeries.setName("Max");
        selectionSeries.setName("Anzahl infizierter Clients");

        avgSeries.getData().add(new XYChart.Data<>(0,0.0));
        minSeries.getData().add(new XYChart.Data<>(0,0.0));
        maxSeries.getData().add(new XYChart.Data<>(0,0.0));

        XYChart.Data<Integer,Double> avgTotal = new XYChart.Data<>();
        avgTotal.XValueProperty().bind(asObjectBinding(userInputModel.numberOfClients()));
        avgTotal.YValueProperty().bind(asObjectBinding(result.avgCostTotal()));
        avgSeries.getData().add(avgTotal);

        XYChart.Data<Integer,Double> minTotal = new XYChart.Data<>();
        minTotal.XValueProperty().bind(asObjectBinding(userInputModel.numberOfClients()));
        minTotal.YValueProperty().bind(asObjectBinding(result.minCostTotal()));
        minSeries.getData().add(minTotal);

        XYChart.Data<Integer,Double> maxTotal = new XYChart.Data<>();
        maxTotal.XValueProperty().bind(asObjectBinding(userInputModel.numberOfClients()));
        maxTotal.YValueProperty().bind(asObjectBinding(result.maxCostTotal()));
        maxSeries.getData().add(maxTotal);


        XYChart.Data<Integer,Double> selectionStart = new XYChart.Data<>();
        selectionStart.XValueProperty().bind(asObjectBinding(userInputModel.selectedNumberOfClientsInChart()));
        selectionStart.YValueProperty().set(0d);

        XYChart.Data<Integer,Double> selectionEnd = new XYChart.Data<>();
        selectionEnd.XValueProperty().bind(asObjectBinding(userInputModel.selectedNumberOfClientsInChart()));
        selectionEnd.YValueProperty().bind(asObjectBinding(result.maxCostTotal()));

        selectionSeries.getData().add(selectionStart);
        selectionSeries.getData().add(selectionEnd);
    }

    public ReadOnlyStringProperty title(){
        return title;
    }

    public XYChart.Series<Integer,Double> avgSeries(){
        return avgSeries;
    }

    public XYChart.Series<Integer,Double> minSeries(){
        return minSeries;
    }

    public XYChart.Series<Integer,Double> maxSeries(){
        return maxSeries;
    }

    public XYChart.Series<Integer,Double> selectionSeries(){
        return selectionSeries;
    }


}
