package de.hszg.datenpannen.model;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * DataModel für die Ergebnisdaten.
 */
public class Result {

    private DoubleProperty avgCostPerDataset = new SimpleDoubleProperty();
    private DoubleProperty minCostPerDataset = new SimpleDoubleProperty();
    private DoubleProperty maxCostPerDataset = new SimpleDoubleProperty();
    private DoubleProperty avgCostTotal = new SimpleDoubleProperty();
    private DoubleProperty minCostTotal = new SimpleDoubleProperty();
    private DoubleProperty maxCostTotal = new SimpleDoubleProperty();


    @Inject
    private BaseDataModel baseDataModel;

    @Inject
    private UserinputModel userinputModel;

    public Result() {
    }

    /**
     * Der Parametrisierte Konstruktor ist zum Testen der Klasse gedacht. Darüber können die Abhängigkeiten direkt
     * injeziert werden.
     * <p/>
     * Im Realen Betrieb wird dies durch das Dependency-Injection-Framework übernommen.
     */
    protected Result(BaseDataModel baseDataModel, UserinputModel userinputModel) {
        this.baseDataModel = baseDataModel;
        this.userinputModel = userinputModel;

        initialize();
    }

    /**
     * Stellt sämtliche Bindings her. Diese Methode wird dank der {@link PostConstruct} Annotation durch das
     * DI-Framework nach Initialisierung der Klasse aufgerufen.
     */
    @PostConstruct
    protected void initialize() {

        IntegerBinding lossCostPerSector = Bindings.integerValueAt(baseDataModel.lossCostPerSectorProperty(),userinputModel.sectorProperty());

        DoubleBinding sumOfInfluencingFactors = new DoubleBinding() {
            {
                bind(baseDataModel.factorValuesProperty(),userinputModel.influencingFactorsProperty());
            }
            @Override
            protected double computeValue() {
                double sum = 0;
                for (InfluencingFactor factor : userinputModel.influencingFactorsProperty()) {
                    sum += baseDataModel.factorValuesProperty().get(factor);
                }
                return sum;
            }
        };

        avgCostPerDataset.bind(lossCostPerSector.add(sumOfInfluencingFactors));
    }


    /**
     * @return die gesamten Durchschnittskosten über alle Datensätze.
     */
    public double getAvgCostTotal() {
        return avgCostTotal.get();
    }

    /**
     * @return die gesamten Min-Kosten über alle Datensätze.
     */
    public double getMinCostTotal() {
        return minCostTotal.get();
    }

    /**
     * @return die gesamten Max-Kosten über alle Datensätze.
     */
    public double getMaxCostTotal() {
        return maxCostTotal.get();
    }

    /**
     * @return die Durchschnittskosten pro Datensatz.
     */
    public double getAvgCostPerDataset() {
        return avgCostPerDataset.get();
    }

    /**
     * @return die Min-Kosten pro Datensatz.
     */
    public double getMinCostPerDataset() {
        return minCostPerDataset.get();
    }

    /**
     * @return die Max-Kosten pro Datensatz.
     */
    public double getMaxCostPerDataset() {
        return maxCostPerDataset.get();
    }

    public double getMinDistributionCost(
            CostDistribution distribution) {
        return 0;
    }

    public double getAvgDistributionCost(
            CostDistribution distribution) {
        // TODO Auto-generated method stub
        return 0;
    }

    public double getMaxDistributionCost(
            CostDistribution distribution) {
        // TODO Auto-generated method stub
        return 0;
    }


}
