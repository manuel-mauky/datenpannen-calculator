package de.hszg.datenpannen.dataloss.view.details;

import de.hszg.datenpannen.dataloss.model.DatalossResult;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class DatalossDetailsPresenter implements Initializable{

    private static final String FORMAT_AVG = "Durchschnitt: %.0f€";
    private static final String FORMAT_MIN = "Min: %.0f€";
    private static final String FORMAT_MAX = "Max: %.0f€";

    @FXML
    private Label avgPerDataset;
    @FXML
    private Label minPerDataset;
    @FXML
    private Label maxPerDataset;

    @FXML
    private Label avgTotal;
    @FXML
    private Label minTotal;
    @FXML
    private Label maxTotal;

    @Inject
    private DatalossResult result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        avgPerDataset.textProperty().bind(avg(result.avgCostPerDataset()));
        minPerDataset.textProperty().bind(min(result.minCostPerDataset()));
        maxPerDataset.textProperty().bind(max(result.maxCostPerDataset()));

        avgTotal.textProperty().bind(avg(result.avgCostTotal()));
        minTotal.textProperty().bind(min(result.minCostTotal()));
        maxTotal.textProperty().bind(max(result.maxCostTotal()));
    }

    private StringExpression avg(ReadOnlyDoubleProperty value){
        return Bindings.format(FORMAT_AVG,value);
    }
    private StringExpression max(ReadOnlyDoubleProperty value){
        return Bindings.format(FORMAT_MAX,value);
    }
    private StringExpression min(ReadOnlyDoubleProperty value){
        return Bindings.format(FORMAT_MIN,value);
    }

}
