package de.hszg.datenpannen.virus.model;

import de.hszg.datenpannen.utils.MathBindings;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class VirusResult {

    private DoubleProperty avgCostPerClient = new SimpleDoubleProperty();
    private DoubleProperty minCostPerClient = new SimpleDoubleProperty();
    private DoubleProperty maxCostPerClient = new SimpleDoubleProperty();
    private DoubleProperty avgCostTotal = new SimpleDoubleProperty();
    private DoubleProperty minCostTotal = new SimpleDoubleProperty();
    private DoubleProperty maxCostTotal = new SimpleDoubleProperty();
    private DoubleProperty avgCostSelected = new SimpleDoubleProperty();
    private DoubleProperty minCostSelected = new SimpleDoubleProperty();
    private DoubleProperty maxCostSelected = new SimpleDoubleProperty();
    private DoubleProperty avgCostComponentCost = new SimpleDoubleProperty();
    private DoubleProperty minCostComponentCost = new SimpleDoubleProperty();
    private DoubleProperty maxCostComponentCost = new SimpleDoubleProperty();
    private DoubleProperty avgInternalActivityCost = new SimpleDoubleProperty();
    private DoubleProperty minInternalActivityCost = new SimpleDoubleProperty();
    private DoubleProperty maxInternalActivityCost = new SimpleDoubleProperty();
    private DoubleProperty avgExternalConsequenceCost = new SimpleDoubleProperty();
    private DoubleProperty minExternalConsequenceCost = new SimpleDoubleProperty();
    private DoubleProperty maxExternalConsequenceCost = new SimpleDoubleProperty();
    private DoubleProperty avgAttackTypeCost = new SimpleDoubleProperty();
    private DoubleProperty minAttackTypeCost = new SimpleDoubleProperty();
    private DoubleProperty maxAttackTypeCost = new SimpleDoubleProperty();
    @Inject
    private BaseDataModel baseDataModel;
    @Inject
    private UserInputModel userInputModel;

    public VirusResult() {
    }

    public VirusResult(BaseDataModel baseDataModel, UserInputModel userInputModel) {
        this.baseDataModel = baseDataModel;
        this.userInputModel = userInputModel;

        initialize();
    }

    /**
     * Stellt sämtliche Bindings her.
     */
    @PostConstruct
    private void initialize() {

        IntegerProperty numberOfClients = userInputModel.numberOfClients();

        DoubleBinding activityFactor = Bindings.doubleValueAt(baseDataModel.securityGovernanceActivityDistributions(), userInputModel.securityGovernanceActivity());
        DoubleBinding sectorFactor = Bindings.doubleValueAt(baseDataModel.attackCostPerSector(), userInputModel.sector());

        avgCostPerClient.bind(
                baseDataModel.avgCostBase()
                        .multiply(
                                MathBindings.pow(
                                        numberOfClients,
                                        baseDataModel.avgCostExponent()))
                        .multiply(activityFactor)
                        .multiply(sectorFactor));

        minCostPerClient.bind(
                baseDataModel.minCostBase()
                        .multiply(
                                MathBindings.pow(
                                        numberOfClients,
                                        baseDataModel.minCostExponent()))
                        .multiply(activityFactor)
                        .multiply(sectorFactor));

        maxCostPerClient.bind(
                baseDataModel.maxCostBase()
                        .multiply(
                                MathBindings.pow(
                                        numberOfClients,
                                        baseDataModel.maxCostExponent()))
                        .multiply(activityFactor)
                        .multiply(sectorFactor));
    }

    public ReadOnlyDoubleProperty avgCostPerClient() {
        return avgCostPerClient;
    }

    public ReadOnlyDoubleProperty minCostPerClient() {
        return minCostPerClient;
    }

    public ReadOnlyDoubleProperty maxCostPerClient() {
        return maxCostPerClient;
    }

    public ReadOnlyDoubleProperty avgCostTotal() {
        return avgCostTotal;
    }

    public ReadOnlyDoubleProperty minCostTotal() {
        return minCostTotal;
    }

    public ReadOnlyDoubleProperty maxCostTotal() {
        return maxCostTotal;
    }

    public ReadOnlyDoubleProperty avgCostSelected() {
        return avgCostSelected;
    }

    public ReadOnlyDoubleProperty minCostSelected() {
        return minCostSelected;
    }

    public ReadOnlyDoubleProperty maxCostSelected() {
        return maxCostSelected;
    }

    public ReadOnlyDoubleProperty getAvgCostComponentCost(
            CostComponent costCompontent) {
        return avgCostComponentCost;
    }

    public ReadOnlyDoubleProperty getMinCostComponentCost(
            CostComponent costCompontent) {
        return minCostComponentCost;
    }

    public ReadOnlyDoubleProperty getMaxCostComponentCost(
            CostComponent costCompontent) {
        return maxCostComponentCost;
    }

    public ReadOnlyDoubleProperty getAvgInternalActivityCost(
            InternalActivity activity) {
        return avgInternalActivityCost;
    }

    public ReadOnlyDoubleProperty getMinInternalActivityCost(
            InternalActivity activity) {
        return minInternalActivityCost;
    }

    public ReadOnlyDoubleProperty getMaxInternalActivityCost(
            InternalActivity activity) {
        return maxInternalActivityCost;
    }

    public ReadOnlyDoubleProperty getAvgExternalConsequenceCost(
            ExternalConsequence consequence) {
        return avgExternalConsequenceCost;
    }

    public ReadOnlyDoubleProperty getMinExternalConsequenceCost(
            ExternalConsequence consequence) {
        return minExternalConsequenceCost;
    }

    public ReadOnlyDoubleProperty getMaxExternalConsequenceCost(
            ExternalConsequence consequence) {
        return maxExternalConsequenceCost;
    }

    public ReadOnlyDoubleProperty getAvgAttackTypeCost(AttackType attacktype) {
        return avgAttackTypeCost;
    }

    public ReadOnlyDoubleProperty getMinAttackTypeCost(AttackType attacktype) {
        return minAttackTypeCost;
    }

    public ReadOnlyDoubleProperty getMaxAttackTypeCost(AttackType attacktype) {
        return maxAttackTypeCost;
    }
}
