package de.hszg.datenpannen.virus.model;

public enum AttackType {

    MALICIOUS_INSIDERS("Malicious Insiders"),
    DENIAL_OF_SERVICES("Denial of Services"),
    WEB_BASED_ATTACKS("Web based attacks"),
    VIRUSES_WORMS_TROJANS("Viruses/Worms/Trojans"),
    MALICIOUS_CODE("Malicious Code"),
    STOLEN_DEVICES("Stolen devices"),
    MALWARE("Malware"),
    PHISHING_AND_SOCIAL_ENGINEERING("Phishing/Social Engineering"),
    BOTNETS("Botnets");


    private String label;

    AttackType(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
