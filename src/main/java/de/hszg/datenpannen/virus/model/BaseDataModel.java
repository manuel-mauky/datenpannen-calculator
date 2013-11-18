package de.hszg.datenpannen.virus.model;

import de.hszg.datenpannen.virus.data.BaseDataDummyProvider;
import de.hszg.datenpannen.virus.data.BaseDataProvider;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyMapProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javax.annotation.PostConstruct;

public class BaseDataModel {

    private DoubleProperty avgCostBase = new SimpleDoubleProperty();
    private DoubleProperty avgCostExponent = new SimpleDoubleProperty();
    private DoubleProperty maxCostBase = new SimpleDoubleProperty();
    private DoubleProperty maxCostExponent = new SimpleDoubleProperty();
    private DoubleProperty minCostBase = new SimpleDoubleProperty();
    private DoubleProperty minCostExponent = new SimpleDoubleProperty();
    private MapProperty<Sector, Double> attackCostPerSector = new SimpleMapProperty<>();
    private MapProperty<SecurityGovernanceActivity, Double> securityGovernanceActivityDistributions = new SimpleMapProperty<>();
    private MapProperty<CostComponent, Double> costComponentDistributions = new SimpleMapProperty<>();
    private MapProperty<ExternalConsequence, Double> externalConsequenceDistributions = new SimpleMapProperty<>();
    private MapProperty<InternalActivity, Double> internalActivityDistributions = new SimpleMapProperty<>();
    private MapProperty<AttackType, Double> attackTypeDistributions = new SimpleMapProperty<>();
    private BaseDataProvider dataProvider = new BaseDataDummyProvider();

    public BaseDataModel() {
    }

    public BaseDataModel(BaseDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        initialize();
    }

    @PostConstruct
    final void initialize() {
        avgCostBase.set(dataProvider.getAvgCostBase());
        avgCostExponent.set(dataProvider.getAvgCostExponent());
        maxCostBase.set(dataProvider.getMaxCostBase());
        maxCostExponent.set(dataProvider.getMaxCostExponent());
        minCostBase.set(dataProvider.getMinCostBase());
        minCostExponent.set(dataProvider.getMinCostExponent());

        attackCostPerSector.set(FXCollections.observableMap(dataProvider.getAttackCostPerSectorMap()));
        attackTypeDistributions.set(FXCollections.observableMap(dataProvider.getAttackTypeDistributionsMap()));
        costComponentDistributions.set(FXCollections.observableMap(dataProvider.getCostComponentDistributionsMap()));
        externalConsequenceDistributions.set(FXCollections.observableMap(dataProvider.getExternalConsequenceDistributionsMap()));
        internalActivityDistributions.set(FXCollections.observableMap(dataProvider.getInternalActivityDistributionsMap()));
        securityGovernanceActivityDistributions.set(FXCollections.observableMap(dataProvider.getSecurityGovernanceActivityDistributionsMap()));

    }

    public ReadOnlyDoubleProperty avgCostBase() {
        return avgCostBase;
    }

    public ReadOnlyDoubleProperty avgCostExponent() {
        return avgCostExponent;
    }

    public ReadOnlyDoubleProperty maxCostBase() {
        return maxCostBase;
    }

    public ReadOnlyDoubleProperty maxCostExponent() {
        return maxCostExponent;
    }

    public ReadOnlyDoubleProperty minCostBase() {
        return minCostBase;
    }

    public ReadOnlyDoubleProperty minCostExponent() {
        return minCostExponent;
    }

    public ReadOnlyMapProperty<Sector, Double> attackCostPerSector() {
        return attackCostPerSector;
    }

    public ReadOnlyMapProperty<SecurityGovernanceActivity, Double> securityGovernanceActivityDistributions() {
        return securityGovernanceActivityDistributions;
    }

    public ReadOnlyMapProperty<CostComponent, Double> costComponentDistributions() {
        return costComponentDistributions;
    }

    public ReadOnlyMapProperty<ExternalConsequence, Double> externalConsequenceDistributions() {
        return externalConsequenceDistributions;
    }

    public ReadOnlyMapProperty<InternalActivity, Double> internalActivityDistributions() {
        return internalActivityDistributions;
    }

    public ReadOnlyMapProperty<AttackType, Double> attackTypeDistributions() {
        return attackTypeDistributions;
    }
}
