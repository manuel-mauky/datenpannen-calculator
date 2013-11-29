package de.hszg.datenpannen.virus.data;

import de.hszg.datenpannen.virus.model.*;
import java.util.Map;

/**
 * Schnittstelle für die Bereitstellung von Basisdaten. Wird vom BaseDataModel
 * zum Laden der Basisdaten verwendet.
 */
public interface VirusDataProvider {

    double getAvgCostBase();

    double getAvgCostExponent();

    double getMaxCostBase();

    double getMaxCostExponent();

    double getMinCostBase();

    double getMinCostExponent();

    double getSectorAverageFactor();

    Map<Sector, Double> getAttackCostPerSectorMap();

    Map<SecurityGovernanceActivity, Double> getSecurityGovernanceActivityDistributionsMap();

    Map<CostComponent, Double> getCostComponentDistributionsMap();

    Map<ExternalConsequence, Double> getExternalConsequenceDistributionsMap();

    Map<InternalActivity, Double> getInternalActivityDistributionsMap();

    Map<AttackType, Double> getAttackTypeDistributionsMap();
}
