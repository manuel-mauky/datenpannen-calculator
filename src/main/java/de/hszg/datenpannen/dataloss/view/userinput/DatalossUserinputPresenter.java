package de.hszg.datenpannen.dataloss.view.userinput;

import de.hszg.datenpannen.dataloss.model.InfluencingFactor;
import de.hszg.datenpannen.dataloss.model.Sector;
import de.hszg.datenpannen.dataloss.model.UserinputModel;
import java.net.URL;
import java.util.ResourceBundle;

import de.hszg.datenpannen.main.view.main.MainView;
import de.hszg.datenpannen.utils.BindingHelper;
import de.hszg.datenpannen.utils.EmptyToZeroNumberConverter;
import de.hszg.datenpannen.utils.ResourceBundleWrapper;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Presenter für den Bereich der Nutzereingaben. Hier werden die Input-Elemente
 * mit dem ViewModel verbunden.
 */
public class DatalossUserinputPresenter{

    private static final String RESOURCE_KEY_FORMAT_SELECTED_CLIENTS = "dataloss.input.format.selectedClients";

    @FXML
    private VBox influencingFactorBox;
    @FXML
    private TextField numberOfDatasetsField;
    @FXML
    private ChoiceBox<Sector> sectorChoiceBox;
    @FXML
    private Label numberOfLostDatasetsLabel;
    @FXML
    private Slider numberOfLostDatasets;

    @Inject
    private UserinputModel userinputModel;

    @Inject
    private ResourceBundleWrapper resourceBundleWrapper;

    public void initialize() {
        BindingHelper.applyNumberOnlyFilter(numberOfDatasetsField.textProperty());
        numberOfDatasetsField.textProperty().bindBidirectional(userinputModel.numberOfDatasets(), new EmptyToZeroNumberConverter());

        sectorChoiceBox.getItems().addAll(Sector.values());
        sectorChoiceBox.valueProperty().bindBidirectional(userinputModel.sector());

        initInflueningFactorCheckBoxes();

        numberOfLostDatasets.valueProperty().bindBidirectional(userinputModel.numberOfLostDatasets());
        numberOfLostDatasets.maxProperty().bind(userinputModel.numberOfDatasets());


        ResourceBundle resourceBundleFor = resourceBundleWrapper.getResourceBundleFor(MainView.class);
        String formatSelectedClients = resourceBundleFor.getString(RESOURCE_KEY_FORMAT_SELECTED_CLIENTS);

        numberOfLostDatasetsLabel.textProperty().bind(Bindings.format(formatSelectedClients,userinputModel.numberOfLostDatasets()));

        userinputModel.numberOfDatasets().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                userinputModel.numberOfLostDatasets().set(number2.intValue());
            }
        });


    }

    private void initInflueningFactorCheckBoxes() {
        for (final InfluencingFactor factor : InfluencingFactor.values()) {
            CheckBox checkbox = new CheckBox(factor.toString());
            checkbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean selected) {
                    if (selected) {
                        userinputModel.influencingFactors().add(factor);
                    } else {
                        userinputModel.influencingFactors().remove(factor);
                    }
                }
            });
            influencingFactorBox.getChildren().add(checkbox);
        }
    }
}
