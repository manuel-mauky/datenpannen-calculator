package de.hszg.datenpannen.utils;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableValue;

public class BindingHelper {

    /**
     * Erzeugt ein Binding von das benutzt werden kann um DoubleProperty auf
     * ObjectProperty<Double> zu binden.
     */
    public static ObjectBinding<Double> asObjectBinding(final ReadOnlyDoubleProperty observable){
        return new ObjectBinding<Double>() {
            {
                super.bind(observable);
            }
            @Override
            protected Double computeValue() {
                return observable.getValue();
            }
        };
    }

    /**
     * Erzeugt ein Binding von das benutzt werden kann um IntegerProperty auf
     * ObjectProperty<Integer> zu binden.
     */
    public static ObjectBinding<Integer> asObjectBinding(final ReadOnlyIntegerProperty observable){
        return new ObjectBinding<Integer>() {
            {
                super.bind(observable);
            }
            @Override
            protected Integer computeValue() {
                return observable.getValue();
            }
        };
    }


    public static void applyNumberOnlyFilter(final StringProperty target){
        target.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!(newValue.matches("\\d*") && newValue.length() < 9)) {
                    target.set(oldValue);
                }
            }
        });
    }

    public static BooleanBinding isNanOrInfinity(final ObservableDoubleValue observable){
        return new BooleanBinding() {
            {
                super.bind(observable);
            }
            @Override
            protected boolean computeValue() {
                double value = observable.get();
                return Double.isInfinite(value) || Double.isNaN(value);
            }
        };
    }

    public static ReadOnlyDoubleProperty nanOrInfinity(final ReadOnlyDoubleProperty property){
        DoubleProperty result = new SimpleDoubleProperty();

        result.bind(new DoubleBinding() {
            {
                super.bind(property);
            }
            @Override
            protected double computeValue() {
                double value = property.get();

                if (Double.isInfinite(value) || Double.isNaN(value)) {
                    return 0;
                } else {
                    return property.get();
                }
            }
        });

        return result;
    }

}
