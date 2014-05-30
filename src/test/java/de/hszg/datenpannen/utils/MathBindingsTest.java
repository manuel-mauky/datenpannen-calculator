package de.hszg.datenpannen.utils;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;

public class MathBindingsTest {


    @Test
    public void testPowWithIntegerPropertyAsBaseAndFixedIntegerExponent(){
        IntegerProperty base = new SimpleIntegerProperty(3);

        IntegerBinding pow = MathBindings.pow(base, 4);

        assertThat(pow).hasValue(81);
        base.set(4);
        assertThat(pow).hasValue(256);
    }

    @Test
    public void testPowWithIntegerPropertyAsBaseAndFixedDoubleExponent(){
        IntegerProperty base = new SimpleIntegerProperty(3);

        DoubleBinding pow = MathBindings.pow(base,1.5);

        assertThat(pow).hasValue(5.196152422706632);

        base.set(4);
        assertThat(pow).hasValue(8d);
    }

    @Test
    public void testPowWithFixedIntegerAsBaseAndIntegerExponentProperty(){
        IntegerProperty exponent = new SimpleIntegerProperty(2);

        DoubleBinding pow = MathBindings.pow(4, exponent);

        assertThat(pow).hasValue(16d);

        exponent.set(3);

        assertThat(pow).hasValue(64d);
    }

    @Test
    public void testPowWithFixedIntegerAsBaseAndDoubleExponentProperty(){
        DoubleProperty exponent = new SimpleDoubleProperty(1.5);
        DoubleBinding pow = MathBindings.pow(4, exponent);

        assertThat(pow).hasValue(8d);

        exponent.set(2.5);

        assertThat(pow).hasValue(32d);
    }

    @Test
    public void testPowWithIntegerPropertyAsBaseAndIntegerPropertyExponent(){
        IntegerProperty base = new SimpleIntegerProperty(3);
        IntegerProperty exponent = new SimpleIntegerProperty(2);
        IntegerBinding pow = MathBindings.pow(base,exponent);

        assertThat(pow).hasValue(9);

        base.set(2);
        assertThat(pow).hasValue(4);

        exponent.set(3);
        assertThat(pow).hasValue(8);
    }

    @Test
    public void testPowWithIntegerPropertyAsBaseAndDoublePropertyExponent(){
        IntegerProperty base = new SimpleIntegerProperty(3);
        DoubleProperty exponent = new SimpleDoubleProperty(1.5);
        DoubleBinding pow = MathBindings.pow(base,exponent);

        assertThat(pow).hasValue(5.196152422706632);

        base.set(2);
        assertThat(pow).hasValue(2.8284271247461903);

        exponent.set(2.5);
        assertThat(pow).hasValue(5.656854249492381);
    }

    @Test
    public void testPowWithDoublePropertyAsBaseAndIntegerPropertyExponent(){
        DoubleProperty base = new SimpleDoubleProperty(3.5);
        IntegerProperty exponent = new SimpleIntegerProperty(2);
        DoubleBinding pow = MathBindings.pow(base,exponent);

        assertThat(pow).hasValue(12.25);

        base.set(2.5);
        assertThat(pow).hasValue(6.25);

        exponent.set(3);
        assertThat(pow).hasValue(15.625);
    }

    @Test
    public void testPowWithDoublePropertyAsBaseAndDoublePropertyExponent(){
        DoubleProperty base = new SimpleDoubleProperty(3.5);
        DoubleProperty exponent = new SimpleDoubleProperty(1.5);
        DoubleBinding pow = MathBindings.pow(base,exponent);

        assertThat(pow).hasValue(6.547900426854397);

        base.set(2.5);
        assertThat(pow).hasValue(3.952847075210474);

        exponent.set(2.5);
        assertThat(pow).hasValue(9.882117688026186);
    }

}
