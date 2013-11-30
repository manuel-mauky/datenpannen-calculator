package de.hszg.datenpannen.virus.view.details;

import de.hszg.datenpannen.main.view.main.MainView;
import de.hszg.datenpannen.utils.ResourceBundleWrapper;
import de.hszg.datenpannen.virus.model.UserInputModel;
import de.hszg.datenpannen.virus.model.VirusResult;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class VirusDetailsPresenter{
    public static final String RESOURCE_KEY_FORMAT_EURO = "virus.details.format.euro";
    public static final String RESOURCE_KEY_FORMAT_PERCENTAGE_LOSS = "virus.details.format.percentageLoss";

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

    @Inject
    private ResourceBundleWrapper resourceBundleWrapper;

    public void initialize() {
        ResourceBundle bundle = resourceBundleWrapper.getResourceBundleFor(MainView.class);

        String formatEuro = bundle.getString(RESOURCE_KEY_FORMAT_EURO);
        String formatPercentageLoss = bundle.getString(RESOURCE_KEY_FORMAT_PERCENTAGE_LOSS);

        perClient.textProperty().bind(
                Bindings.format(
                        formatEuro,
                        result.avgCostPerClient()));

        maxLoss.textProperty().bind(Bindings.format(formatEuro, result.maxCostTotal()));

        lossWithXPercentLabel.textProperty().bind(Bindings.format(formatPercentageLoss, result.selectedPercentage()));

        lossWithXPercentValue.textProperty().bind(Bindings.format(formatEuro,result.avgCostSelected()));
    }
}
