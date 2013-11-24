package de.hszg.datenpannen.virus.model;

public enum ExternalConsequence {

    INFORMATION_LOSS("Information loss"),
    REVENUE_LOSS("Revenue loss"),
    BUSINESS_DISRUPTION("Business disruption"),
    EQUIPMENT_DAMAGES("Equipment damages"),
    OTHER_COSTS("Other costs");


    private String label;

    ExternalConsequence(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
