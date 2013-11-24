package de.hszg.datenpannen.virus.model;

public enum Sector {

    FINANCIAL_SERVICES("Financial Services"),
    UTILITIES_AND_ENERGY("Utilities and Energy"),
    PHARMACEUTICAL("Pharmaceutical"),
    TECHNOLOGY("Technology"),
    PUBLIC_SECTOR("Public sector"),
    EDUCATION_AND_RESEARCH("Education and research"),
    INDUSTRIAL("Industrial"),
    TRANSPORTATION("Transportation"),
    SERVICES("Services"),
    HOSPITALITY("Hospitality"),
    CONSUMER_PRODUCTS("Consumer products"),
    AUTOMOTIVE("Automotive"),
    MEDIA("Media"),
    RETAIL("Retail");


    private String label;

    Sector(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
    
}
