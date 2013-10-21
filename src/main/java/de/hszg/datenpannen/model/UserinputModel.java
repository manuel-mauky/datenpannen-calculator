package de.hszg.datenpannen.model;

import java.util.EnumSet;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;

/**
 * Diese Model-Klasse representiert alle Benutzereingaben
 */
public class UserinputModel {

    private SetProperty<InfluencingFactor> influencingFactorsProperty =
            new SimpleSetProperty<>(FXCollections.observableSet(EnumSet.noneOf(InfluencingFactor.class)));
    private IntegerProperty numberOfDatasetProperty = new SimpleIntegerProperty();
    private ObjectProperty<Sector> sectorProperty = new SimpleObjectProperty<>(Sector.FINANCIAL);

    public SetProperty<InfluencingFactor> influencingFactorsProperty() {
        return influencingFactorsProperty;
    }

    public IntegerProperty numberOfDatasetProperty() {
        return numberOfDatasetProperty;
    }

    public int getNumberOfDataset() {
        return numberOfDatasetProperty.get();
    }

    public void setNumberOfDataset(int number) {
        numberOfDatasetProperty.set(number);
    }

    public ObjectProperty<Sector> sectorProperty() {
        return sectorProperty;
    }
}
