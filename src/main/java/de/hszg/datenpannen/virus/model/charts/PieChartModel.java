package de.hszg.datenpannen.virus.model.charts;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface PieChartModel {
    ReadOnlyStringProperty title();

    ObservableList<PieChart.Data> data();
}
