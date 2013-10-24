package de.hszg.datenpannen.model;

import de.hszg.datenpannen.data.BaseDataDummyProvider;
import de.hszg.datenpannen.data.BaseDataProvider;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.EnumMap;

/**
 * DataModel für statistische Eingangsdaten.
 */
public class BaseDataModel {

    private DoubleProperty avgLossCost = new SimpleDoubleProperty();
    private DoubleProperty maxLossCost = new SimpleDoubleProperty();
    private DoubleProperty minLossCost = new SimpleDoubleProperty();

    private MapProperty<Sector, Double> lossCostPerSector = new SimpleMapProperty<>();
    private MapProperty<InfluencingFactor,Double> factorValues = new SimpleMapProperty<>();
    private MapProperty<CostDistribution,Double> costDistributions = new SimpleMapProperty<>();

    @Inject
    private BaseDataProvider dataProvider;

    /**
     * Public Default Konstruktor wird von DI-Framework zur Instanziierung benutzt.
     */
    public BaseDataModel(){}

    /**
     * Parametrisierter Konstruktor kann in Tests ohne DI-Framework benutzt werden.
     */
    BaseDataModel(BaseDataProvider dataProvider){
        this.dataProvider = dataProvider;
        initialize();
    }

    @PostConstruct
    void initialize() {
        setAvgLossCost(dataProvider.getAvgLossCost());
        setMaxLossCost(dataProvider.getMaxLossCost());
        setMinLossCost(dataProvider.getMinLossCost());

        lossCostPerSector.set(FXCollections.observableMap(dataProvider.getSectorMap()));
        factorValues.set(FXCollections.observableMap(dataProvider.getInfluencingFactorMap()));
        costDistributions.set(FXCollections.observableMap(dataProvider.getCostDistributionMap()));
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

    public ReadOnlyMapProperty<Sector, Double> lossCostPerSectorProperty(){
        return lossCostPerSector;
    }

    public ReadOnlyMapProperty<InfluencingFactor,Double> factorValuesProperty(){
        return factorValues;
    }

    public ReadOnlyMapProperty<CostDistribution,Double> costDistributionsProperty(){
        return costDistributions;
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
