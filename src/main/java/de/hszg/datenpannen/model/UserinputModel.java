package de.hszg.datenpannen.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

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

    private SetProperty<InfluencingFactor> influencingFactorsProperty =
            new SimpleSetProperty<>(FXCollections.observableSet(EnumSet.noneOf(InfluencingFactor.class)));
    private IntegerProperty numberOfDatasetProperty = new SimpleIntegerProperty();
    private ObjectProperty<Sector> sectorProperty = new SimpleObjectProperty<>(Sector.FINANCIAL);

    public SetProperty<InfluencingFactor> influencingFactorsProperty() {
        return influencingFactorsProperty;
    }
    
    public Set<InfluencingFactor> getInfluencingFactors(){
    	return Collections.unmodifiableSet(influencingFactorsProperty.get());
    }
    
    public void addInfluencingFactor(InfluencingFactor influencingFactor){
    	influencingFactorsProperty.get().add(influencingFactor);
    }
    
    public void addInfluencingFactors(Collection<InfluencingFactor> influencingFactors){
    	influencingFactorsProperty.get().addAll(influencingFactors);
    }
    
    public void addInfluencingFactors(InfluencingFactor... influencingFactors){
    	influencingFactorsProperty.get().addAll(Arrays.asList(influencingFactors));
    }
    
    public void removeInfluencingFactor(InfluencingFactor influencingFactor){
    	influencingFactorsProperty.get().remove(influencingFactor);
    }
    
    public void removeInfluencingFactors(Collection<InfluencingFactor> influencingFactors){
    	influencingFactorsProperty.get().removeAll(influencingFactors);
    }
    
    public void removeInfluencingFactors(InfluencingFactor...factors){
    	influencingFactorsProperty.get().removeAll(Arrays.asList(factors));
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

    public Sector getSector(){
    	return sectorProperty.get();
    }
    
    public void setSector(Sector sector){
    	sectorProperty.set(sector);
    }
    
}
