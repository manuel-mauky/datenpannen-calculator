package de.hszg.datenpannen.virus.view.details;

import de.hszg.datenpannen.virus.model.UserInputModel;
import de.hszg.datenpannen.virus.model.VirusResult;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.inject.Inject;

public class VirusDetailsPresenter  implements Initializable{

    private static final String FORMAT_EURO = "%,.0f \u20AC";

    private static final String FORMAT_LOSS_PERCENTAGE_LABEL = "Verlust bei %,.0f%%";

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


        IntegerProperty all = userInputModel.numberOfClients();
        IntegerProperty selected = userInputModel.selectedNumberOfClientsInChart();


        NumberBinding percentageBinding = Bindings.when(
                all.isEqualTo(0))
                .then(0.0)
                .otherwise(
                        selected.
                                multiply(100)
                                .divide(all.add(0.0001)));

        lossWithXPercentLabel.textProperty().bind(Bindings.format(FORMAT_LOSS_PERCENTAGE_LABEL,percentageBinding));

        lossWithXPercentValue.textProperty().bind(Bindings.format(FORMAT_EURO,result.avgCostSelected()));
    }
}
