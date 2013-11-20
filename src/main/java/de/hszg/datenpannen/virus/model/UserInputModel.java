package de.hszg.datenpannen.virus.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Diese Model-Klasse repräsentiert alle Benutzereingaben
 */
public class UserInputModel {

	/**
	 * Die vom Nutzer eingegebene Anzahl an Clients.
	 */
	private IntegerProperty numberOfClients = new SimpleIntegerProperty();
	
	/**
	 * Der vom Nutzer gewählte Sektor.
	 */
	private ObjectProperty<Sector> sector = new SimpleObjectProperty<>(Sector.AUTOMOTIVE);

	/**
	 * Vom Nutzer ausgewählte Sicherheitsvorkehrung.
	 */
	private ObjectProperty<SecurityGovernanceActivity> securityGovernanceActivity = new SimpleObjectProperty<>(SecurityGovernanceActivity.ADEQUACY_OF_BUDGETED_RESOURCES);

	/**
	 * Vom Nutzer aktuell ausgewählte Position im Chart.
	 */
	private IntegerProperty selectedNumberOfClientsInChart;
	

	public IntegerProperty numberOfClients() {
		return numberOfClients;
	}

	public ObjectProperty<Sector> sector() {
		return sector;
	}

	public ObjectProperty<SecurityGovernanceActivity> securityGovernanceActivity() {
		return securityGovernanceActivity;
	}
	
	public IntegerProperty selectedNumberOfClientsInChart(){
		return selectedNumberOfClientsInChart;
	}

}
