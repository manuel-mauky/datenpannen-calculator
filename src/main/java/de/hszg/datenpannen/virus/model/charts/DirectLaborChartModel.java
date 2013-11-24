package de.hszg.datenpannen.virus.model.charts;

import de.hszg.datenpannen.virus.model.InternalActivity;
import de.hszg.datenpannen.virus.model.VirusResult;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class DirectLaborChartModel implements  PieChartModel {
    private StringProperty title = new SimpleStringProperty();
    private ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    @Inject
    private VirusResult result;


    @PostConstruct
    void initialize(){
        title.set("Extern");

        for (InternalActivity internalActivity : InternalActivity.values()) {
            PieChart.Data element = new PieChart.Data(internalActivity.name(),0);
            element.pieValueProperty().bind(result.getAvgInternalActivityCost(internalActivity));

            data.add(element);
        }

    }

    @Override
    public ReadOnlyStringProperty title() {
        return title;
    }

    @Override
    public ObservableList<PieChart.Data> data() {
        return data;
    }

}
