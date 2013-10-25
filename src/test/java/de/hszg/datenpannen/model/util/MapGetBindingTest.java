package de.hszg.datenpannen.model.util;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.*;

public class MapGetBindingTest {

    private static enum Color {
        RED,
        GREEN,
        BLUE
    }

    private MapProperty<Color, String> map;

    private ObjectProperty<Color> selectedKey;

    @Before
    public void setup(){
        map = new SimpleMapProperty<>();
        map.set(FXCollections.observableMap(new EnumMap(Color.class)));

        map.put(Color.RED, "red");
        map.put(Color.GREEN, "green");
        map.put(Color.BLUE, "blue");

        selectedKey = new SimpleObjectProperty<>();
    }


    @Test
    public void testWithEnumMap(){
        // Create the binding
        ObjectBinding<String> binding = new MapGetBinding<>(selectedKey,map);


        selectedKey.set(Color.RED);
        assertThat(binding.get()).isEqualTo("red");


        selectedKey.set(Color.BLUE);
        assertThat(binding.get()).isEqualTo("blue");
    }

    /**
     * What happens when there is no selection / selection property has a value of "null"?
     */
    @Test
    public void testNoSelection(){
        ObjectBinding<String> binding = new MapGetBinding<>(selectedKey,map);

        assertThat(binding.get()).isNull();

        selectedKey.set(Color.RED);
        assertThat(binding.get()).isNotNull();

        selectedKey.set(null);
        assertThat(binding.get()).isNull();



        // Reinitializing the Binding, this time with a default value "white"
        binding = new MapGetBinding<>(selectedKey,map, "white");

        // selectedKey is still null...
        assertThat(binding.get()).isEqualTo("white");

        selectedKey.set(Color.GREEN);
        assertThat(binding.get()).isEqualTo("green");

        // selectedKey is null again so the default value will be used
        selectedKey.set(null);
        assertThat(binding.get()).isEqualTo("white");
    }

    /**
     * What happens when there is no entry in the Map
     * for the selected key?
     */
    @Test
    public void testNoEntryInTheMap(){
        map.remove(Color.GREEN);
        assertThat(map.get().get(Color.GREEN)).isNull();

        ObjectBinding<String> binding = new MapGetBinding<>(selectedKey,map);

        selectedKey.set(Color.GREEN);

        // the binding has a value of null
        assertThat(binding.get()).isNull();

        // for a key that is contained in the map, the binding is still working as expected.
        selectedKey.set(Color.RED);
        assertThat(binding.get()).isEqualTo("red");

        // Recreate the binding with a default value this time.
        binding = new MapGetBinding<>(selectedKey,map, "white");

        // Color.RED is still selected...
        assertThat(binding.get()).isEqualTo("red");


        selectedKey.set(Color.GREEN);

        // now the binding should have a default value of "white"
        assertThat(binding.get()).isEqualTo("white");

    }



}
