package de.hszg.datenpannen.model.dataloss;

import de.hszg.datenpannen.data.dataloss.BaseDataDummyProvider;
import de.hszg.datenpannen.data.dataloss.BaseDataProvider;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.EnumMap;

/**
 * DataModel für statistische Eingangsdaten. Diese Daten wurden statistisch
 * ermittelt und sind im Programm fest hinterlegt.
 */
public class BaseDataModel {

    /**
     * Der statistisch ermittelte Ausgangswert für die Durchschnittlichen
     * Kosten. Dieser Wert ist Grundlage für die weiteren Berechnungen.
     */
    private DoubleProperty avgLossCost = new SimpleDoubleProperty();
    /**
     * Der statistisch ermittelte Ausgangswert für die Maximalen Kosten. Dieser
     * Wert ist Grundlage für die weiteren Berechnungen.
     */
    private DoubleProperty maxLossCost = new SimpleDoubleProperty();
    /**
     * Der statistisch ermittelte Ausgangswert für die Minimalen Kosten. Dieser
     * Wert ist Grundlage für die weiteren Berechnungen.
     */
    private DoubleProperty minLossCost = new SimpleDoubleProperty();
    /**
     * Die Kosten für die einzelnen Industriezweige.
     */
    private MapProperty<Sector, Integer> lossCostPerSector = new SimpleMapProperty<>();
    /**
     * Die Einflussfaktoren.
     */
    private MapProperty<InfluencingFactor, Double> factorValues = new SimpleMapProperty<>();
    /**
     * Die Aufteilung der Kosten.
     */
    private MapProperty<CostDistribution, Double> costDistributions = new SimpleMapProperty<>();
    @Inject
    private BaseDataDummyProvider dataProvider;

    /**
     * Public Default Konstruktor wird von DI-Framework zur Instanziierung
     * benutzt.
     */
    public BaseDataModel() {
    }

    /**
     * Parametrisierter Konstruktor kann in Tests ohne DI-Framework benutzt
     * werden.
     */
    BaseDataModel(BaseDataDummyProvider dataProvider) {
        this.dataProvider = dataProvider;
        initialize();
    }

    @PostConstruct
    final void initialize() {
        avgLossCost.set(dataProvider.getAvgLossCost());
        maxLossCost.set(dataProvider.getMaxLossCost());
        minLossCost.set(dataProvider.getMinLossCost());

        lossCostPerSector.set(FXCollections.observableMap(dataProvider.getSectorMap()));
        factorValues.set(FXCollections.observableMap(dataProvider.getInfluencingFactorMap()));
        costDistributions.set(FXCollections.observableMap(dataProvider.getCostDistributionMap()));
    }

    public ReadOnlyMapProperty<Sector, Integer> lossCostPerSector() {
        return lossCostPerSector;
    }

    public ReadOnlyMapProperty<InfluencingFactor, Double> factorValues() {
        return factorValues;
    }

    public ReadOnlyMapProperty<CostDistribution, Double> costDistributions() {
        return costDistributions;
    }

    public ReadOnlyDoubleProperty minLossCost() {
        return minLossCost;
    }

    public ReadOnlyDoubleProperty maxLossCost() {
        return maxLossCost;
    }

    public ReadOnlyDoubleProperty avgLossCost() {
        return avgLossCost;
    }
}
