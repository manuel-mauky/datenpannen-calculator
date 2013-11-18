package de.hszg.datenpannen.dataloss.model;

import java.util.EnumSet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;

/**
 * Diese Model-Klasse repräsentiert alle Benutzereingaben
 */
public class UserinputModel {

    /**
     * Die vom Nutzer ausgewählten Einflussfaktoren.
     */
    private SetProperty<InfluencingFactor> influencingFactors =
            new SimpleSetProperty<>(FXCollections.observableSet(EnumSet.noneOf(InfluencingFactor.class)));

    /**
     * Die vom Nutzer eingegebene Anzahl an Datensätzen.
     */
    private IntegerProperty numberOfDatasets = new SimpleIntegerProperty();

    /**
     * Der vom Nutzer ausgewählte Sektor.
     */
    private ObjectProperty<Sector> sector = new SimpleObjectProperty<>(Sector.FINANCIAL);

    public SetProperty<InfluencingFactor> influencingFactors() {
        return influencingFactors;
    }
    
    public IntegerProperty numberOfDatasets() {
        return numberOfDatasets;
    }

    public ObjectProperty<Sector> sector() {
        return sector;
    }
}
