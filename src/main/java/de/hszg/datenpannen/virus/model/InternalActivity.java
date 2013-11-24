package de.hszg.datenpannen.virus.model;

public enum InternalActivity {

    DETECTION("Detection"),
    RECOVERY("Recovery"),
    INVESTIGATION("Investigation"),
    CONTAINMENT("Containment"),
    INCIDENT_MANAGMENT("Incident management"),
    EX_POST_RESPONSE("Ex-post response");


    private String label;

    InternalActivity(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
    
}
