package de.hszg.datenpannen.virus.model;

public enum SecurityGovernanceActivity {

    EXTENSIVE_USE_OF_SECURITY_METRICS("Extensive use of security metrics"),
    SUBSTANTIAL_TRAINING_AND_AWARENESS_ACTIVITIES("Substantial training and awareness activities"),
    EMPLOYMENT_OF_CERTIFIED_EXPERT_SECURITY_PERSONNEL("Employment of certified expert security personnel"),
    FORMATION_OF_A_SENIOR_LEVEL_SECURITY_COUNCIL("Formation of a senior level security council"),
    APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER("Appointment of a high level security leader"),
    ADEQUACY_OF_BUDGETED_RESOURCES("Adequacy of budgeted resources"),
    CERTIFICATION_AGAINST_INDUSTRY_LEADING_STANDARDS("Certification against industry leading standards"),
    NONE("None");


    private String label;

    SecurityGovernanceActivity(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
