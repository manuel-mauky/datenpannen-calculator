package de.hszg.datenpannen.utils;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    @Override
    public void replaceText(int start, int end, String text) {
        if (match(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (match(text)) {
            super.replaceSelection(text);
        }
    }

    private boolean match(String text) {
        return (text.matches("[0-9]") && textProperty().get().length() < 9) || text.isEmpty() ;
    }
}