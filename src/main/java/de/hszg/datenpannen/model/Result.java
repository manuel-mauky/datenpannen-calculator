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

    /**
     * Die tatsächlichen (d.h. für den Industriezweig) Durchschnittskosten pro Datensatz.
     */
    private DoubleProperty avgCostPerDataset = new SimpleDoubleProperty();

    /**
     * Die tatsächlichen (d.h. für den Industriezweig) Minimalen Kosten pro Datensatz.
     */
    private DoubleProperty minCostPerDataset = new SimpleDoubleProperty();

    /**
     * Die tatsächlichen (d.h. für den Industriezweig) Maximalen Kosten pro Datensatz.
     */
    private DoubleProperty maxCostPerDataset = new SimpleDoubleProperty();

    /**
     * Die gesamten Durchschnittskosten über alle Datensätze.
     */
    private DoubleProperty avgCostTotal = new SimpleDoubleProperty();

    /**
     * Die gesamten Minimalen Kosten über alle Datensätze.
     */
    private DoubleProperty minCostTotal = new SimpleDoubleProperty();

    /**
     * Die gesamten Maximalen Kosten über alle Datensätze.
     */
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

        IntegerBinding lossCostPerSector = Bindings.integerValueAt(baseDataModel.lossCostPerSector(),userinputModel.sector());

        DoubleBinding sumOfInfluencingFactors = new DoubleBinding() {
            {
                bind(baseDataModel.factorValues(),userinputModel.influencingFactors());
            }
            @Override
            protected double computeValue() {
                double sum = 0;
                for (InfluencingFactor factor : userinputModel.influencingFactors()) {
                    sum += baseDataModel.factorValues().get(factor);
                }
                return sum;
            }
        };

        avgCostPerDataset.bind(lossCostPerSector.add(sumOfInfluencingFactors));
    }


    public ReadOnlyDoubleProperty avgCostPerDataset(){
        return avgCostPerDataset;
    }

    public ReadOnlyDoubleProperty minCostPerDataset(){
        return maxCostPerDataset;
    };

    public ReadOnlyDoubleProperty maxCostPerDataset(){
        return maxCostPerDataset;
    };

    public ReadOnlyDoubleProperty avgCostTotal(){
        return avgCostTotal;
    };

    public ReadOnlyDoubleProperty minCostTotal(){
        return minCostTotal;
    };

    public ReadOnlyDoubleProperty maxCostTotal(){
        return maxCostTotal;
    };

    public ReadOnlyDoubleProperty getMinDistributionCost(CostDistribution distribution) {
        return new SimpleDoubleProperty(0);
    }

    public ReadOnlyDoubleProperty getAvgDistributionCost(CostDistribution distribution){
        return new SimpleDoubleProperty(0);
    }

    public ReadOnlyDoubleProperty getMaxDistributionCost(CostDistribution distribution){
        return new SimpleDoubleProperty(0);
    }
}
