package de.hszg.datenpannen.virus.model;

public enum CostComponent {
    
    PRODUCTIVITY_LOSS("Productivity Loss"),
    DIRECT_LABOR("Direct Labor"),
    INDIRECT_LABOR("Indirect Labor"),
    CASH_OUTLAY("Cash outlay"),
    OVERHEAD("Overhead"),
    OTHER("Others");


    private String label;

    CostComponent(String label){
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
