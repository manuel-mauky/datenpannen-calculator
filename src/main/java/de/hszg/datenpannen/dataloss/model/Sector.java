package de.hszg.datenpannen.dataloss.model;

public enum Sector {

    FINANCIAL("Financial"),
    INDUSTRIAL("Industrial"),
    ENERGY("Energy"),
    CONSUMER("Consumer"),
    HOSPITALITY("Hospitality"),
    SERVICES("Services"),
    RETAIL("Retail"),
    TECHNOLOGY("Technology"),
    COMMUNICATIONS("Communications"),
    PHARMACEUTICAL("Pharmaceutical"),
    PUBLIC_SECTOR("Public sector");
    private String label;

    Sector(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
