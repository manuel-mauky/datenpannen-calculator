package de.hszg.datenpannen.dataloss.model;

/**
 * Einflussfaktoren für die Berechnung
 */
public enum InfluencingFactor {

    THIRD_PARTY_ERROR ("Third party error"),
    LOST_OR_STOLEN_DEVICES("Lost/stolen devices"),
    QUICK_NOTIFICATION("Quick notification"),
    CONSULTANTS_ENGAGED("Consultants engaged"),
    CISO_APPOINTMENT("CISO appointment"),
    INCIDENT_MANAGEMENT_PLAN("Incident management plan"),
    STRONG_SECURITY_POSTURE("Strong security posture");


    private String label;

    InfluencingFactor(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
