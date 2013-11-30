package de.hszg.datenpannen.dataloss.view.details;

import de.hszg.datenpannen.dataloss.model.DatalossResult;
import de.hszg.datenpannen.dataloss.model.UserinputModel;
import de.hszg.datenpannen.main.view.main.MainView;
import de.hszg.datenpannen.utils.ResourceBundleWrapper;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class DatalossDetailsPresenter{

    public static final String RESOURCE_KEY_FORMAT_TOTAL = "dataloss.details.format.total";
    public static final String RESOURCE_KEY_FORMAT_AVG = "dataloss.details.format.avg";
    public static final String RESOURCE_KEY_FORMAT_MAX = "dataloss.details.format.max";
    public static final String RESOURCE_KEY_FORMAT_MIN = "dataloss.details.format.min";

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

    @Inject
    private ResourceBundleWrapper resourceBundleWrapper;

    private ResourceBundle bundle;

    public void initialize() {
        bundle = resourceBundleWrapper.getResourceBundleFor(MainView.class);
        avgPerDataset.textProperty().bind(avg(result.avgCostPerDataset()));
        minPerDataset.textProperty().bind(min(result.minCostPerDataset()));
        maxPerDataset.textProperty().bind(max(result.maxCostPerDataset()));

        avgSelected.textProperty().bind(avg(result.avgCostSelected()));
        minSelected.textProperty().bind(min(result.minCostSelected()));
        maxSelected.textProperty().bind(max(result.maxCostSelected()));


        String formatTotal = bundle.getString(RESOURCE_KEY_FORMAT_TOTAL);

        captionSelected.textProperty().bind(Bindings.format(formatTotal,result.selectionPercentage()));
    }

    private StringExpression avg(ReadOnlyDoubleProperty value){
        return Bindings.format(bundle.getString(RESOURCE_KEY_FORMAT_AVG),value);
    }
    private StringExpression max(ReadOnlyDoubleProperty value){
        return Bindings.format(bundle.getString(RESOURCE_KEY_FORMAT_MAX),value);
    }
    private StringExpression min(ReadOnlyDoubleProperty value){
        return Bindings.format(bundle.getString(RESOURCE_KEY_FORMAT_MIN),value);
    }
}
