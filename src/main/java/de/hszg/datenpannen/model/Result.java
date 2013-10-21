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

}
