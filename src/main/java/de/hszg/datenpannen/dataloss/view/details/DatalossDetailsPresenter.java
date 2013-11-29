package de.hszg.datenpannen.dataloss.view.details;

import de.hszg.datenpannen.dataloss.model.DatalossResult;
import de.hszg.datenpannen.dataloss.model.UserinputModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.inject.Inject;

public class DatalossDetailsPresenter implements Initializable {

    private static final String FORMAT_AVG = "Durchschnitt: %,.0f \u20AC";
    private static final String FORMAT_MIN = "Min: %,.0f \u20AC";
    private static final String FORMAT_MAX = "Max: %,.0f \u20AC";
    private static final String FORMAT_LOSS_PERCENTAGE_LABEL = "Verlust bei %,.0f%%";
    @FXML
    private Label avgPerDataset;
    @FXML
    private Label minPerDataset;
    @FXML
    private Label maxPerDataset;
    @FXML
    private Label avgSelected;
    @FXML
    private Label minSelected;
    @FXML
    private Label maxSelected;
    @FXML
    private Label captionSelected;
    @Inject
    private DatalossResult result;
    @Inject
    private UserinputModel userInputModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        avgPerDataset.textProperty().bind(avg(result.avgCostPerDataset()));
        minPerDataset.textProperty().bind(min(result.minCostPerDataset()));
        maxPerDataset.textProperty().bind(max(result.maxCostPerDataset()));

        avgSelected.textProperty().bind(avg(result.avgCostSelected()));
        minSelected.textProperty().bind(min(result.minCostSelected()));
        maxSelected.textProperty().bind(max(result.maxCostSelected()));



        captionSelected.textProperty().bind(Bindings.format(FORMAT_LOSS_PERCENTAGE_LABEL, selectedPercentage()));

    }

    private ReadOnlyDoubleProperty selectedPercentage() {
        DoubleProperty value = new SimpleDoubleProperty();
        value.bind(Bindings.when(
                userInputModel.numberOfDatasets().isEqualTo(0))
                .then(0.0)
                .otherwise(
                userInputModel.numberOfLostDatasets().
                multiply(100)
                .divide(userInputModel.numberOfDatasets().add(0.000001))));
        return DoubleProperty.readOnlyDoubleProperty(value);
    }

    private StringExpression avg(ReadOnlyDoubleProperty value) {
        return Bindings.format(FORMAT_AVG, value);
    }

    private StringExpression max(ReadOnlyDoubleProperty value) {
        return Bindings.format(FORMAT_MAX, value);
    }

    private StringExpression min(ReadOnlyDoubleProperty value) {
        return Bindings.format(FORMAT_MIN, value);
    }
}
