package de.hszg.datenpannen.dataloss.model;

/**
 *
 * Aufteilungen der Kosten
 */
public enum CostDistribution {

    INVESTIGATIONS_AND_FORENSICS("Investigations and forensics"),
    LOST_CUSTOMER_BUSINESS("Lost customer business"),
    AUDIT_AND_CONSULTING_SERVICES("Audit and consulting services"),
    OUTBOUND_CONTACT_COSTS("Outbound contact costs"),
    LEGAL_SERVICES_COMPLIANCE("Legal services compliance"),
    CUSTOMER_ACQUISITION_COST("Customer acquisition cost"),
    INBOUND_CONTACT_COSTS("Inbound contact costs"),
    LEGAL_SERVICES_DEFENSE("Legal services defense"),
    FREE_OR_DISCOUNTED_SERVICES("Free or discounted Services"),
    IDENTITY_PROTECTION_SERVICES("Identity protection services"),
    PUBLIC_RELATIONS_COMMUNICATIONS("Public relations communications");


    private String label;

    CostDistribution(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
