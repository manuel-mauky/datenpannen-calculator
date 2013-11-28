package de.hszg.datenpannen.virus.view.details;

import de.hszg.datenpannen.virus.model.UserInputModel;
import de.hszg.datenpannen.virus.model.VirusResult;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class VirusDetailsPresenter  implements Initializable{

    private static final String FORMAT_AVG = "Durchschnitt: %.0f€";
    private static final String FORMAT_MIN = "Min: %.0f€";
    private static final String FORMAT_MAX = "Max: %.0f€";

    private static final String FORMAT_EURO = "%.0f€";

    private static final String FORMAT_LOSS_PERCENTAGE_LABEL = "Verlust bei %.0f%%";

    @FXML
    private Label perClient;

    @FXML
    private Label maxLoss;

    @FXML
    private Label lossWithXPercentLabel;

    @FXML
    private Label lossWithXPercentValue;

    @Inject
    private VirusResult result;

    @Inject
    private UserInputModel userInputModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        perClient.textProperty().bind(
                Bindings.format(
                        FORMAT_EURO, 
                        result.avgCostPerClient()));

        maxLoss.textProperty().bind(Bindings.format(FORMAT_EURO, result.maxCostTotal()));

        lossWithXPercentLabel.textProperty().bind(Bindings.format(FORMAT_LOSS_PERCENTAGE_LABEL, result.selectedPercentage()));

        lossWithXPercentValue.textProperty().bind(Bindings.format(FORMAT_EURO,result.avgCostSelected()));
    }
}
