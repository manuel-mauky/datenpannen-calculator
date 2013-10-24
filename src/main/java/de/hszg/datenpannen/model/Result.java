package de.hszg.datenpannen.model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * DataModel für die Ergebnisdaten.
 */
public class Result {

    @Inject
    private BaseDataModel baseDataModel;

    private UserinputModel userinputModel;

    public Result() {
    }

    /**
     * Der Parametrisierte Konstruktor ist zum Testen der Klasse gedacht.
     * Darüber können die Abhängigkeiten direkt injeziert werden.
     * <p/>
     * Im Realen Betrieb wird dies durch das Dependency-Injection-Framework übernommen.
     */
    protected Result(BaseDataModel baseDataModel, UserinputModel userinputModel) {
        this.baseDataModel = baseDataModel;
        this.userinputModel = userinputModel;

        initialize();
    }

    /**
     * Stellt sämtliche Bindings her. Diese Methode wird dank der {@link PostConstruct}
     * Annotation durch das DI-Framework nach Initialisierung der Klasse aufgerufen.
     */
    @PostConstruct
    protected void initialize() {

    }

	public double getAvgCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMinCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMaxCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getMinDistributionCost(
			CostDistribution distribution) {
		// TODO Auto-generated method stub
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
