package de.hszg.datenpannen.utils;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

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
}
