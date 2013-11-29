package de.hszg.datenpannen.utils;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ObservableNumberValue;

public class MathBindings {


    public static IntegerBinding pow(final ObservableNumberValue base, final int exponent) {
        return new IntegerBinding(){
            {
                super.bind(base);
            }
            @Override
            protected int computeValue() {
                return (int)Math.pow(base.doubleValue(), exponent);
            }
        };
    }

    public static DoubleBinding pow(final ObservableNumberValue base,final  double exponent) {
        return new DoubleBinding() {
            {
                super.bind(base);
            }
            @Override
            protected double computeValue() {
                return Math.pow(base.doubleValue(), exponent);
            }
        };
    }

    public static DoubleBinding pow(final int base, final ObservableNumberValue exponent){
        return new DoubleBinding() {
            {
                super.bind(exponent);
            }
            @Override
            protected double computeValue() {
                return Math.pow(base, exponent.doubleValue());
            }
        };
    }

    public static IntegerBinding pow(final ReadOnlyIntegerProperty base, final ReadOnlyIntegerProperty exponent) {
        return new IntegerBinding() {
            {
                super.bind(base,exponent);
            }
            @Override
            protected int computeValue() {
                return (int)Math.pow(base.get(), exponent.get());
            }
        };
    }


    public static DoubleBinding pow(final ObservableNumberValue base, final ObservableNumberValue exponent){
        return new DoubleBinding() {
            {
                super.bind(base,exponent);
            }
            @Override
            protected double computeValue() {
                return Math.pow(base.doubleValue(), exponent.doubleValue());
            }
        };
    }

}
