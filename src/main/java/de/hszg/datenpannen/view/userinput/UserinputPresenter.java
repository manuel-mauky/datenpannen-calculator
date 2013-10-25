package de.hszg.datenpannen.view.userinput;

import de.hszg.datenpannen.model.InfluencingFactor;
import de.hszg.datenpannen.model.Sector;
import de.hszg.datenpannen.model.UserinputModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import javax.inject.Inject;

/**
 * Presenter für den Bereich der Nutzereingaben. Hier werden die Input-Elemente
 * mit dem ViewModel verbunden.
 */
public class UserinputPresenter implements Initializable {

    @FXML
    private VBox influencingFactorBox;
    @FXML
    private TextField numberOfDatasetsField;
    @FXML
    private ChoiceBox<Sector> sectorChoiceBox;
    @Inject
    private UserinputModel userinputModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("UserinputPresenter initialized");

        numberOfDatasetsField.textProperty().bindBidirectional(userinputModel.numberOfDatasetsProperty(), new NumberStringConverter());

        sectorChoiceBox.getItems().addAll(Sector.values());
        sectorChoiceBox.valueProperty().bindBidirectional(userinputModel.sectorProperty());

        initInflueningFactorCheckBoxes();
    }

    private void initInflueningFactorCheckBoxes() {
        for (final InfluencingFactor factor : InfluencingFactor.values()) {
            CheckBox checkbox = new CheckBox(factor.name());
            checkbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean selected) {
                    if (selected) {
                        userinputModel.influencingFactorsProperty().add(factor);
                    } else {
                        userinputModel.influencingFactorsProperty().remove(factor);
                    }
                }
            });
            influencingFactorBox.getChildren().add(checkbox);
        }
    }
}
