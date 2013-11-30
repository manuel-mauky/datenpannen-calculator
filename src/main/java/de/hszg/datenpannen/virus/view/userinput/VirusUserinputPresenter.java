package de.hszg.datenpannen.virus.view.userinput;

import de.hszg.datenpannen.utils.BindingHelper;
import de.hszg.datenpannen.utils.EmptyToZeroNumberConverter;
import de.hszg.datenpannen.virus.model.Sector;
import de.hszg.datenpannen.virus.model.SecurityGovernanceActivity;
import de.hszg.datenpannen.virus.model.UserInputModel;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import javax.inject.Inject;

/**
 * Presenter für den Bereich der Nutzereingaben. Hier werden die Input-Elemente
 * mit dem ViewModel verbunden.
 */
public class VirusUserinputPresenter {

    private static final String FORMAT_SELECTED_CLIENTS = "Anteil Infizierter Clients: %d";

    @FXML
    private TextField numberOfClientsField;

    @FXML
    private ChoiceBox<Sector> sectorChoiceBox;

    @FXML
    private ChoiceBox<SecurityGovernanceActivity> securityGovernanceChoiceBox;

    @FXML
    private Label selectedClientsLabel;

    @FXML
    private Slider selectedClientsSlider;

    @Inject
    private UserInputModel userInputModel;

    public void initialize() {
        BindingHelper.applyNumberOnlyFilter(numberOfClientsField.textProperty());
        numberOfClientsField.textProperty().bindBidirectional(userInputModel.numberOfClients(), new EmptyToZeroNumberConverter());

        sectorChoiceBox.getItems().addAll(Sector.values());
        sectorChoiceBox.valueProperty().bindBidirectional(userInputModel.sector());

        securityGovernanceChoiceBox.getItems().addAll(SecurityGovernanceActivity.values());
        securityGovernanceChoiceBox.valueProperty().bindBidirectional(userInputModel.securityGovernanceActivity());

        selectedClientsSlider.valueProperty().bindBidirectional(userInputModel.selectedNumberOfClientsInChart());
        selectedClientsSlider.maxProperty().bind(userInputModel.numberOfClients());

        selectedClientsLabel.textProperty().bind(Bindings.format(FORMAT_SELECTED_CLIENTS, userInputModel.selectedNumberOfClientsInChart()));

        userInputModel.numberOfClients().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                    userInputModel.selectedNumberOfClientsInChart().set(newValue.intValue());
            }
        });

    }
}
