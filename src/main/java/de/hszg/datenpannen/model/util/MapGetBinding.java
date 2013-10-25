package de.hszg.datenpannen.model.util;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableMap;

public class MapGetBinding<Key, Value> extends ObjectBinding<Value>{

    private ObservableMap<Key, Value> map;

    private ObservableValue<Key> key;

    private Value defaultValue;

    public MapGetBinding(ObservableValue<Key> key, ObservableMap<Key,Value> map){
        this.map = map;
        this.key = key;

        bind(map,key);
    }

    public MapGetBinding(ObservableValue<Key> key, ObservableMap<Key,Value> map, Value defaultValue){
        this(key,map);
        this.defaultValue = defaultValue;
    }

    @Override
    protected Value computeValue() {
        Value value = map.get(key.getValue());

        if(value == null){
            return defaultValue;
        }else{
            return  value;
        }
    }
}
