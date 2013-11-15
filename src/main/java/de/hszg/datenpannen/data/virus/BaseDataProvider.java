package de.hszg.datenpannen.data.virus;

import de.hszg.datenpannen.model.virus.AttackType;
import de.hszg.datenpannen.model.virus.CostComponent;
import de.hszg.datenpannen.model.virus.ExternalConsequence;
import de.hszg.datenpannen.model.virus.InternalActivity;
import de.hszg.datenpannen.model.virus.SecurityGovernanceActivity;
import java.util.Map;

/**
 * Schnittstelle für die Bereitstellung von Basisdaten. Wird vom BaseDataModel
 * zum Laden der Basisdaten verwendet.
 */
public interface BaseDataProvider {

    double getAvgCostBase();

    double getAvgCostExponent();

    double getMaxCostBase();

    double getMaxCostExponent();

    double getMinCostBase();

    double getMinCostExponent();

    Map<de.hszg.datenpannen.model.virus.Sector, Double> getAttackCostPerSectorMap();

    Map<SecurityGovernanceActivity, Double> getSecurityGovernanceActivityDistributionsMap();

    Map<CostComponent, Double> getCostComponentDistributionsMap();

    Map<ExternalConsequence, Double> getExternalConsequenceDistributionsMap();

    Map<InternalActivity, Double> getInternalActivityDistributionsMap();

    Map<AttackType, Double> getAttackTypeDistributionsMap();
}
