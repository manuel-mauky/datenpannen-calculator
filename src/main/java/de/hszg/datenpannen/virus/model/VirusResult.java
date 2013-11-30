package de.hszg.datenpannen.virus.model;

import de.hszg.datenpannen.utils.BindingHelper;
import static de.hszg.datenpannen.utils.Helper.createEmptyEnumMap;
import de.hszg.datenpannen.utils.MathBindings;
import java.util.Map;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
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

    private MapProperty<CostComponent,DoubleProperty> avgCostComponentCosts = new SimpleMapProperty<>();
    private MapProperty<CostComponent,DoubleProperty> minCostComponentCosts = new SimpleMapProperty<>();
    private MapProperty<CostComponent,DoubleProperty> maxCostComponentCosts = new SimpleMapProperty<>();


    private MapProperty<InternalActivity,DoubleProperty> avgInternalActivityCosts = new SimpleMapProperty<>();
    private MapProperty<InternalActivity,DoubleProperty> minInternalActivityCosts = new SimpleMapProperty<>();
    private MapProperty<InternalActivity,DoubleProperty> maxInternalActivityCosts = new SimpleMapProperty<>();

    private MapProperty<ExternalConsequence,DoubleProperty> avgExternalConsequenceCosts = new SimpleMapProperty<>();
    private MapProperty<ExternalConsequence,DoubleProperty> minExternalConsequenceCosts = new SimpleMapProperty<>();
    private MapProperty<ExternalConsequence,DoubleProperty> maxExternalConsequenceCosts = new SimpleMapProperty<>();

    private MapProperty<AttackType,DoubleProperty> avgAttackTypeCosts = new SimpleMapProperty<>();
    private MapProperty<AttackType,DoubleProperty> minAttackTypeCosts = new SimpleMapProperty<>();
    private MapProperty<AttackType,DoubleProperty> maxAttackTypeCosts = new SimpleMapProperty<>();

    private NumberBinding selectedPercentage;

    @Inject
    private BaseDataModel baseDataModel;
    @Inject
    private UserInputModel userInputModel;

    public VirusResult() {
        avgCostComponentCosts.set(FXCollections.observableMap(createEmptyEnumMap(CostComponent.class))) ;
        minCostComponentCosts.set(FXCollections.observableMap(createEmptyEnumMap(CostComponent.class)));
        maxCostComponentCosts.set(FXCollections.observableMap(createEmptyEnumMap(CostComponent.class)));


        avgInternalActivityCosts.set(FXCollections.observableMap(createEmptyEnumMap(InternalActivity.class)));
        minInternalActivityCosts.set(FXCollections.observableMap(createEmptyEnumMap(InternalActivity.class)));
        maxInternalActivityCosts.set(FXCollections.observableMap(createEmptyEnumMap(InternalActivity.class)));

        avgExternalConsequenceCosts.set(FXCollections.observableMap(createEmptyEnumMap(ExternalConsequence.class)));
        minExternalConsequenceCosts.set(FXCollections.observableMap(createEmptyEnumMap(ExternalConsequence.class)));
        maxExternalConsequenceCosts.set(FXCollections.observableMap(createEmptyEnumMap(ExternalConsequence.class)));

        avgAttackTypeCosts.set(FXCollections.observableMap(createEmptyEnumMap(AttackType.class)));
        minAttackTypeCosts.set(FXCollections.observableMap(createEmptyEnumMap(AttackType.class)));
        maxAttackTypeCosts.set(FXCollections.observableMap(createEmptyEnumMap(AttackType.class)));
    }

    public VirusResult(BaseDataModel baseDataModel, UserInputModel userInputModel) {
        this();
        this.baseDataModel = baseDataModel;
        this.userInputModel = userInputModel;

        initialize();
    }

    /**
     * Stellt sämtliche Bindings her.
     */
    @PostConstruct
    private void initialize() {
        initPerClientBindings();

        initTotalBindings();

        initSelectedBindings();



        initCostComponentCosts(avgCostComponentCosts,avgCostSelected);
        initCostComponentCosts(minCostComponentCosts,minCostSelected);
        initCostComponentCosts(maxCostComponentCosts,maxCostSelected);

        initInternalActivityCosts(avgInternalActivityCosts,avgCostSelected);
        initInternalActivityCosts(minInternalActivityCosts,minCostSelected);
        initInternalActivityCosts(maxInternalActivityCosts, maxCostSelected);

        initExternalConsequencesCosts(avgExternalConsequenceCosts,avgCostSelected);
        initExternalConsequencesCosts(minExternalConsequenceCosts,minCostSelected);
        initExternalConsequencesCosts(maxExternalConsequenceCosts, maxCostSelected);

        initAttackTypeCosts(avgAttackTypeCosts,avgCostSelected);
        initAttackTypeCosts(minAttackTypeCosts,minCostSelected);
        initAttackTypeCosts(maxAttackTypeCosts, maxCostSelected);

        initSelectedPercentageBinding();
    }

    /**
     * Initialisiert alle Bindings die pro Client existieren.
     */
    private void initPerClientBindings() {
        IntegerProperty numberOfClients = userInputModel.numberOfClients();

        DoubleBinding activityFactor = Bindings.doubleValueAt(baseDataModel.securityGovernanceActivityDistributions(), userInputModel.securityGovernanceActivity());
        DoubleBinding sectorBase = Bindings.doubleValueAt(baseDataModel.attackCostPerSector(), userInputModel.sector());

        NumberBinding sectorFactor = Bindings.divide(sectorBase,baseDataModel.sectorAverageFactor());

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


    /**
     * Initialisiert alle Bindings, die mit der aktuellen Auswahl an tatsächlich infizierten Clients zu tun haben.
     */
    private void initSelectedBindings() {
        IntegerProperty selectedNumberOfClients = userInputModel.selectedNumberOfClientsInChart();
        avgCostSelected.bind(selectedNumberOfClients.multiply(avgCostPerClient));
        minCostSelected.bind(selectedNumberOfClients.multiply(minCostPerClient));
        maxCostSelected.bind(selectedNumberOfClients.multiply(maxCostPerClient));
    }

    /**
     * Initialisiert alle Bindings, die mit den Totalen Kosten zu tun haben.
     */
    private void initTotalBindings() {
        IntegerProperty numberOfClients = userInputModel.numberOfClients();

        avgCostTotal.bind(numberOfClients.multiply(avgCostPerClient));
        minCostTotal.bind(numberOfClients.multiply(minCostPerClient));
        maxCostTotal.bind(numberOfClients.multiply(maxCostPerClient));
    }

    /**
     * Initialisiert das Binding für den Prozentsatz aktuell ausgewählter Clients.
     */
    private void initSelectedPercentageBinding() {
        IntegerProperty all = userInputModel.numberOfClients();
        IntegerProperty selected = userInputModel.selectedNumberOfClientsInChart();

        selectedPercentage = Bindings.when(
                all.isEqualTo(0))
                .then(0.0)
                .otherwise(
                        selected.
                                multiply(100)
                                .divide(all.add(0.0001)));
    }


    private void initCostComponentCosts(MapProperty<CostComponent, DoubleProperty> map, DoubleProperty perClient) {
        for(Map.Entry<CostComponent,DoubleProperty> entry : map.entrySet()){
            CostComponent key = entry.getKey();
            DoubleProperty value = entry.getValue();

            value.bind(perClient.multiply(baseDataModel.costComponentDistributions().get(key)));
        }
    }

    private void initInternalActivityCosts(MapProperty<InternalActivity, DoubleProperty> map, DoubleProperty perClient) {

        Double directLaborFactor = baseDataModel.costComponentDistributions().get(CostComponent.DIRECT_LABOR);
        for(Map.Entry<InternalActivity,DoubleProperty> entry : map.entrySet()){
            InternalActivity key = entry.getKey();
            DoubleProperty value = entry.getValue();

            value.bind(perClient.multiply(directLaborFactor * baseDataModel.internalActivityDistributions().get(key)));
        }
    }

    private void initExternalConsequencesCosts(MapProperty<ExternalConsequence, DoubleProperty> map, DoubleProperty perClient) {
        Double productivityLossFactor = baseDataModel.costComponentDistributions().get(CostComponent.PRODUCTIVITY_LOSS);

        for(Map.Entry<ExternalConsequence,DoubleProperty> entry : map.entrySet()){
            ExternalConsequence key = entry.getKey();
            DoubleProperty value = entry.getValue();

            value.bind(perClient.multiply(
                            productivityLossFactor *
                            baseDataModel.externalConsequenceDistributions().get(key)));
        }
    }

    private void initAttackTypeCosts(MapProperty<AttackType, DoubleProperty> map, DoubleProperty perClient) {
        for(Map.Entry<AttackType,DoubleProperty> entry : map.entrySet()){
            AttackType key = entry.getKey();
            DoubleProperty value = entry.getValue();

            value.bind(perClient.multiply(baseDataModel.attackTypeDistributions().get(key)));
        }
    }


    public ReadOnlyDoubleProperty avgCostPerClient() {
        return BindingHelper.nanOrInfinity(avgCostPerClient);
    }

    public ReadOnlyDoubleProperty minCostPerClient() {
        return BindingHelper.nanOrInfinity(minCostPerClient);
    }

    public ReadOnlyDoubleProperty maxCostPerClient() {
        return BindingHelper.nanOrInfinity(maxCostPerClient);
    }

    public ReadOnlyDoubleProperty avgCostTotal() {
        return BindingHelper.nanOrInfinity(avgCostTotal);
    }

    public ReadOnlyDoubleProperty minCostTotal() {
        return BindingHelper.nanOrInfinity(minCostTotal);
    }

    public ReadOnlyDoubleProperty maxCostTotal() {
        return BindingHelper.nanOrInfinity(maxCostTotal);
    }

    public ReadOnlyDoubleProperty avgCostSelected() {
        return BindingHelper.nanOrInfinity(avgCostSelected);
    }

    public ReadOnlyDoubleProperty minCostSelected() {
        return BindingHelper.nanOrInfinity(minCostSelected);
    }

    public ReadOnlyDoubleProperty maxCostSelected() {
        return BindingHelper.nanOrInfinity(maxCostSelected);
    }

    public ReadOnlyDoubleProperty getAvgCostComponentCost(
            CostComponent costCompontent) {
        return BindingHelper.nanOrInfinity(avgCostComponentCosts.get(costCompontent));
    }

    public ReadOnlyDoubleProperty getMinCostComponentCost(
            CostComponent costCompontent) {
        return BindingHelper.nanOrInfinity(minCostComponentCosts.get(costCompontent));
    }

    public ReadOnlyDoubleProperty getMaxCostComponentCost(
            CostComponent costCompontent) {
        return BindingHelper.nanOrInfinity(maxCostComponentCosts.get(costCompontent));
    }

    public ReadOnlyDoubleProperty getAvgInternalActivityCost(
            InternalActivity activity) {
        return BindingHelper.nanOrInfinity(avgInternalActivityCosts.get(activity));
    }

    public ReadOnlyDoubleProperty getMinInternalActivityCost(
            InternalActivity activity) {
        return BindingHelper.nanOrInfinity(minInternalActivityCosts.get(activity));
    }

    public ReadOnlyDoubleProperty getMaxInternalActivityCost(
            InternalActivity activity) {
        return BindingHelper.nanOrInfinity(maxInternalActivityCosts.get(activity));
    }

    public ReadOnlyDoubleProperty getAvgExternalConsequenceCost(
            ExternalConsequence consequence) {
        return BindingHelper.nanOrInfinity(avgExternalConsequenceCosts.get(consequence));
    }

    public ReadOnlyDoubleProperty getMinExternalConsequenceCost(
            ExternalConsequence consequence) {
        return BindingHelper.nanOrInfinity(minExternalConsequenceCosts.get(consequence));
    }

    public ReadOnlyDoubleProperty getMaxExternalConsequenceCost(
            ExternalConsequence consequence) {
        return BindingHelper.nanOrInfinity(maxExternalConsequenceCosts.get(consequence));
    }

    public ReadOnlyDoubleProperty getAvgAttackTypeCost(AttackType attacktype) {
        return BindingHelper.nanOrInfinity(avgAttackTypeCosts.get(attacktype));
    }

    public ReadOnlyDoubleProperty getMinAttackTypeCost(AttackType attacktype) {
        return BindingHelper.nanOrInfinity(minAttackTypeCosts.get(attacktype));
    }

    public ReadOnlyDoubleProperty getMaxAttackTypeCost(AttackType attacktype) {
        return BindingHelper.nanOrInfinity(maxAttackTypeCosts.get(attacktype));
    }

    public NumberBinding selectedPercentage(){
        return selectedPercentage;
    }
}
