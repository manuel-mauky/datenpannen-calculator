package de.hszg.datenpannen.model;

import de.hszg.datenpannen.data.BaseDataDummyProvider;
import de.hszg.datenpannen.data.BaseDataProvider;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javax.annotation.PostConstruct;

/**
 * DataModel für statistische Eingangsdaten.
 */
public class BaseDataModel {

    private DoubleProperty avgLossCost = new SimpleDoubleProperty();
    private DoubleProperty maxLossCost = new SimpleDoubleProperty();
    private DoubleProperty minLossCost = new SimpleDoubleProperty();
    private BaseDataProvider dataProvider;

    @PostConstruct
    void initialize() {
        dataProvider = new BaseDataDummyProvider();

        setAvgLossCost(dataProvider.getAvgLossCost());
        setMaxLossCost(dataProvider.getMaxLossCost());
        setMinLossCost(dataProvider.getMinLossCost());
    }

    public DoubleProperty influencingFactorProperty(InfluencingFactor factor) {
        return new SimpleDoubleProperty(dataProvider.getValueOf(factor));
    }

    public DoubleProperty lossCostSectorProperty(Sector sector) {
        return new SimpleDoubleProperty(dataProvider.getLossCostOf(sector));
    }

    public DoubleProperty costDistributionProperty(CostDistribution distribution) {
        return new SimpleDoubleProperty(dataProvider.getPercentageOf(distribution));
    }

    public DoubleProperty minLossCostProperty() {
        return minLossCost;
    }

    public void setMinLossCost(double value) {
        minLossCost.set(value);
    }

    public double getMinLossCost() {
        return minLossCost.get();
    }

    public DoubleProperty maxLossCostProperty() {
        return maxLossCost;
    }

    public void setMaxLossCost(double value) {
        maxLossCost.set(value);
    }

    public double getMaxLossCost() {
        return maxLossCost.get();
    }

    public DoubleProperty avgLossCostProperty() {
        return avgLossCost;
    }

    public void setAvgLossCost(double value) {
        avgLossCost.set(value);
    }

    public double getAvgLossCost() {
        return avgLossCost.get();
    }
}
