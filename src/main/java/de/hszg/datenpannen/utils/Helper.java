package de.hszg.datenpannen.utils;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.util.StringConverter;

import java.util.EnumMap;
import java.util.Map;

public class Helper {

    /**
     * Erzeugt eine EnumMap für den angegebenen Enum-Typ. Die Map wird mit
     * SimpleDoubleProperty-Instanzen gefüllt.
     */
    public static <T extends Enum<T>> Map<T, DoubleProperty> createEmptyEnumMap(Class<T> enumType) {
        final Map<T, DoubleProperty> map = new EnumMap<T, DoubleProperty>(enumType);
        for (T enumConstant : enumType.getEnumConstants()) {
            map.put(enumConstant, new SimpleDoubleProperty(0));
        }
        return map;
    }

    /**
     * Entfernt das Kreis-Symbol, welches standardmäßig angezeigt wird, für einen XYChart-Graphen
     */
    public static void removeLineChartSymbol(XYChart.Series<Integer,Double> series){
        for (XYChart.Data<Integer, Double> data : series.getData()) {
            for (Node node : data.getNode().lookupAll(".chart-line-symbol")) {
                node.setVisible(false);
                node.setManaged(false);
            }
        }
    }

    /**
     * Fixt ein Problem mit der Anzeige der Beschriftung der XY-Liniendiagramme.
     * Dort wurde bei beiden Achsen die 0 als Kommazahl mit vielen Nachkommastellen dargestellt,
     * was zu Layoutproblemen geführt hat.
     *
     * Diese Methode fixt dieses Problem indem ein anderer StringConverter für beide Achsen
     * gesetzt wird.
     */
    @SuppressWarnings("unchecked")
    public static void fixTickFormatterForChart(LineChart<? extends Number, ? extends Number> chart){
        ValueAxis<Number> yAxis = (ValueAxis)chart.getYAxis();
        ValueAxis<Number> xAxis = (ValueAxis)chart.getXAxis();


        final NumberAxis.DefaultFormatter defaultFormatter = new NumberAxis.DefaultFormatter(new NumberAxis());

        StringConverter<Number> formatter = new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                if(number.intValue() < 1){
                    return "0";
                }else{
                    return defaultFormatter.toString(number);
                }
            }

            @Override
            public Number fromString(String s) {
                return defaultFormatter.fromString(s);
            }
        };

        yAxis.setTickLabelFormatter(formatter);
        xAxis.setTickLabelFormatter(formatter);

    }
}
