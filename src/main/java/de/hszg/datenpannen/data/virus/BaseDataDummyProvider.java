package de.hszg.datenpannen.data.virus;

import de.hszg.datenpannen.model.virus.AttackType;
import de.hszg.datenpannen.model.virus.CostComponent;
import de.hszg.datenpannen.model.virus.ExternalConsequence;
import de.hszg.datenpannen.model.virus.InternalActivity;
import de.hszg.datenpannen.model.virus.Sector;
import de.hszg.datenpannen.model.virus.SecurityGovernanceActivity;
import java.util.EnumMap;
import java.util.Map;

public class BaseDataDummyProvider implements BaseDataProvider {

    private Map<Sector, Double> attackCostPerSector = new EnumMap<>(Sector.class);
    private Map<SecurityGovernanceActivity, Double> securityGovernanceActivityDistributions = new EnumMap<>(SecurityGovernanceActivity.class);
    private Map<CostComponent, Double> costComponentDistributions = new EnumMap<>(CostComponent.class);
    private Map<ExternalConsequence, Double> externalConsequenceDistributions = new EnumMap<>(ExternalConsequence.class);
    private Map<InternalActivity, Double> internalActivityDistributions = new EnumMap<>(InternalActivity.class);
    private Map<AttackType, Double> attackTypeDistributions = new EnumMap<>(AttackType.class);

    public BaseDataDummyProvider() {
        initAttackCostPerSector();
        initSecurityGovernanceActivityDistributions();
        initCostComponentDistributions();
        initExternalConsequenceDistributions();
        initInternalActivityDistributions();
        initAttackTypeDistributions();
    }

    @Override
    public double getAvgCostBase() {
        return 17302;
    }

    @Override
    public double getAvgCostExponent() {
        return -.441;
    }

    @Override
    public double getMaxCostBase() {
        return 38377;
    }

    @Override
    public double getMaxCostExponent() {
        return -.654;
    }

    @Override
    public double getMinCostBase() {
        return 1734.9;
    }

    @Override
    public double getMinCostExponent() {
        return -.266;
    }

    private void initSecurityGovernanceActivityDistributions() {
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.EXTENSIVE_USE_OF_SECURITY_METRICS, .27);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.SUBSTANTIAL_TRAINING_AND_AWARENESS_ACTIVITIES, .3);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.EMPLOYMENT_OF_CERTIFIED_EXPERT_SECURITY_PERSONNEL, .36);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.FORMATION_OF_A_SENIOR_LEVEL_SECURITY_COUNCIL, .45);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER, .52);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.ADEQUACY_OF_BUDGETED_RESOURCES, .61);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.CERTIFICATION_AGAINST_INDUSTRY_LEADING_STANDARDS, .64);
        securityGovernanceActivityDistributions.put(SecurityGovernanceActivity.NONE, 0d);
    }

    private void initCostComponentDistributions() {
        costComponentDistributions.put(CostComponent.PRODUCTIVITY_LOSS, .26);
        costComponentDistributions.put(CostComponent.DIRECT_LABOR, .23);
        costComponentDistributions.put(CostComponent.INDIRECT_LABOR, .21);
        costComponentDistributions.put(CostComponent.CASH_OUTLAY, .18);
        costComponentDistributions.put(CostComponent.OVERHEAD, .09);
        costComponentDistributions.put(CostComponent.OTHER, .03);
    }

    private void initExternalConsequenceDistributions() {
        externalConsequenceDistributions.put(ExternalConsequence.INFORMATION_LOSS, .4);
        externalConsequenceDistributions.put(ExternalConsequence.REVENUE_LOSS, .28);
        externalConsequenceDistributions.put(ExternalConsequence.BUSINESS_DISRUPTION, .25);
        externalConsequenceDistributions.put(ExternalConsequence.EQUIPMENT_DAMAGES, .05);
        externalConsequenceDistributions.put(ExternalConsequence.OTHER_COSTS, .02);
    }

    private void initInternalActivityDistributions() {
        internalActivityDistributions.put(InternalActivity.DETECTION, .33);
        internalActivityDistributions.put(InternalActivity.RECOVERY, .22);
        internalActivityDistributions.put(InternalActivity.INVESTIGATION, .19);
        internalActivityDistributions.put(InternalActivity.CONTAINMENT, .12);
        internalActivityDistributions.put(InternalActivity.INCIDENT_MANAGMENT, .09);
        internalActivityDistributions.put(InternalActivity.EX_POST_RESPONSE, .05);
    }

    private void initAttackTypeDistributions() {
        attackTypeDistributions.put(AttackType.MALICIOUS_INSIDERS, .21);
        attackTypeDistributions.put(AttackType.DENIAL_OF_SERVICES, .2);
        attackTypeDistributions.put(AttackType.WEB_BASED_ATTACKS, .17);
        attackTypeDistributions.put(AttackType.VIRUSES_WORMS_TROJANS, .09);
        attackTypeDistributions.put(AttackType.MALICIOUS_CODE, .08);
        attackTypeDistributions.put(AttackType.STOLEN_DEVICES, .07);
        attackTypeDistributions.put(AttackType.MALWARE, .06);
        attackTypeDistributions.put(AttackType.PHISHING_AND_SOCIAL_ENGINEERING, .06);
        attackTypeDistributions.put(AttackType.BOTNETS, .05);
    }

    private void initAttackCostPerSector() {
        attackCostPerSector.put(Sector.FINANCIAL_SERVICES, 7.45);
        attackCostPerSector.put(Sector.UTILITIES_AND_ENERGY, 6.51);
        attackCostPerSector.put(Sector.PHARMACEUTICAL, 5.52);
        attackCostPerSector.put(Sector.TECHNOLOGY, 5.26);
        attackCostPerSector.put(Sector.PUBLIC_SECTOR, 4.61);
        attackCostPerSector.put(Sector.EDUCATION_AND_RESEARCH, 4.57);
        attackCostPerSector.put(Sector.INDUSTRIAL, 4.55);
        attackCostPerSector.put(Sector.TRANSPORTATION, 4.27);
        attackCostPerSector.put(Sector.SERVICES, 3.78);
        attackCostPerSector.put(Sector.HOSPITALITY, 3.47);
        attackCostPerSector.put(Sector.CONSUMER_PRODUCTS, 3.39);
        attackCostPerSector.put(Sector.AUTOMOTIVE, 3.04);
        attackCostPerSector.put(Sector.MEDIA, 2.91);
        attackCostPerSector.put(Sector.RETAIL, 1.91);

    }

    @Override
    public Map<Sector, Double> getAttackCostPerSectorMap() {
        return attackCostPerSector;
    }

    @Override
    public Map<SecurityGovernanceActivity, Double> getSecurityGovernanceActivityDistributionsMap() {
        return securityGovernanceActivityDistributions;
    }

    @Override
    public Map<CostComponent, Double> getCostComponentDistributionsMap() {
        return costComponentDistributions;
    }

    @Override
    public Map<ExternalConsequence, Double> getExternalConsequenceDistributionsMap() {
        return externalConsequenceDistributions;
    }

    @Override
    public Map<InternalActivity, Double> getInternalActivityDistributionsMap() {
        return internalActivityDistributions;
    }

    @Override
    public Map<AttackType, Double> getAttackTypeDistributionsMap() {
        return attackTypeDistributions;
    }
}
