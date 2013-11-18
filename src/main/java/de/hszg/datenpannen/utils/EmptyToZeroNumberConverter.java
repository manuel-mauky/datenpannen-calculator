package de.hszg.datenpannen.utils;

import javafx.util.converter.NumberStringConverter;

public class EmptyToZeroNumberConverter extends NumberStringConverter {
    @Override
    public Number fromString(String s) {
        if(s.isEmpty()){
            return 0;
        }else{
            return super.fromString(s);
        }
    }
}
