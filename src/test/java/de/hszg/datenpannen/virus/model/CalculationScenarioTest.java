package de.hszg.datenpannen.virus.model;

import de.hszg.datenpannen.virus.data.StaticVirusDataProvider;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.data.Offset.offset;

/**
 * 
 * Dieser Test beschreibt die Berechnungen im Virenbefall-Abschnitt der Anwendung.
 * 
 */
public class CalculationScenarioTest {

	private Result result;
	private BaseDataModel baseDataModel;
	private UserInputModel userInputModel;
	
	@Before
	public void setup(){
		StaticVirusDataProvider baseDataProvider = new StaticVirusDataProvider();
		
		baseDataModel = new BaseDataModel(baseDataProvider);
		userInputModel = new UserInputModel();
		
		result = new Result(baseDataModel, userInputModel);
	}
	
	@Ignore
	@Test
	public void testScenarioFinancialServicesWithExtensiveUseOfSecurityMetrics() {
		userInputModel.numberOfClients().set(867);
		userInputModel.sector().set(Sector.FINANCIAL_SERVICES);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.EXTENSIVE_USE_OF_SECURITY_METRICS);
		
		userInputModel.selectedNumberOfClientsInChart().set(434);
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(984.090284, offset(0.001));
		assertThat(result.minCostPerClient().get()).isEqualTo(516.668032, offset(0.001));
		assertThat(result.maxCostPerClient().get()).isEqualTo(322.378764, offset(0.001));
		
		assertThat(result.avgCostTotal().get()).isEqualTo(853206.277, offset(0.001));
		assertThat(result.minCostTotal().get()).isEqualTo(447951.184, offset(0.001));
		assertThat(result.maxCostTotal().get()).isEqualTo(279502.388, offset(0.001));
				
		assertThat(result.avgCostSelected().get()).isEqualTo(426603.138, offset(0.001));
		assertThat(result.minCostSelected().get()).isEqualTo(223975.592, offset(0.001));
		assertThat(result.maxCostSelected().get()).isEqualTo(139751.194, offset(0.001));
		
		/**
		 * Ab hier wird das Kreisdiagramm 1 geprüft.
		 * Die Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients.
		 */
		
		assertCostComponent(result, 110916.816, 58233.6539, 36335.3105, CostComponent.PRODUCTIVITY_LOSS);
		assertCostComponent(result, 98118.7218, 51514.3861, 32142.7746, CostComponent.DIRECT_LABOR);
		assertCostComponent(result, 89586.659, 47034.8743, 29347.7508, CostComponent.INDIRECT_LABOR);
		assertCostComponent(result, 76788.5649, 40315.6065, 25155.2149, CostComponent.CASH_OUTLAY);
		assertCostComponent(result, 38394.2824, 20157.8033, 12577.6075, CostComponent.OVERHEAD);
		assertCostComponent(result, 12798.0941, 6719.26775, 4192.53582, CostComponent.OTHER);
		
		assertExternalConsequence(result, 44366.7264, 23293.4615, 14534.1242, ExternalConsequence.INFORMATION_LOSS);
		assertExternalConsequence(result, 31056.7085, 16305.4231, 10173.8869, ExternalConsequence.REVENUE_LOSS);
		assertExternalConsequence(result, 27729.204, 14558.4135, 9083.82762, ExternalConsequence.BUSINESS_DISRUPTION);
		assertExternalConsequence(result, 5545.8408, 2911.68269, 1816.76552, ExternalConsequence.EQUIPMENT_DAMAGES);
		assertExternalConsequence(result, 2218.33632, 1164.67308, 726.706209, ExternalConsequence.OTHER_COSTS);
		
		assertInternalActivity(result, 32379.1782, 16999.7474, 10607.1156, InternalActivity.DETECTION);
		assertInternalActivity(result, 21586.1188, 11333.1649, 7071.41042, InternalActivity.RECOVERY);
		assertInternalActivity(result, 18642.5571, 9787.73336, 6107.12718, InternalActivity.INVESTIGATION);
		assertInternalActivity(result, 11774.2466, 6181.72633, 3857.13296, InternalActivity.CONTAINMENT);
		assertInternalActivity(result, 8830.68496, 4636.29475, 2892.84972, InternalActivity.INCIDENT_MANAGMENT);
		assertInternalActivity(result, 4905.93609, 2575.71931, 1607.13873, InternalActivity.EX_POST_RESPONSE);
		
		/**
		 * Kreisdiagramm Kosten bei Angriffen, Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients
		 */
		
		assertAttackType(result, 89586.6590, 47034.8742, 29347.7507, AttackType.MALICIOUS_INSIDERS);
		assertAttackType(result, 85320.6276, 44795.1183, 27950.2388, AttackType.DENIAL_OF_SERVICES);
		assertAttackType(result, 72522.5335, 38075.8505, 23757.7029, AttackType.WEB_BASED_ATTACKS);
		assertAttackType(result, 38394.2824, 20157.8032, 12577.6074, AttackType.VIRUSES_WORMS_TROJANS);
		assertAttackType(result, 34128.2510, 17918.0473, 11180.0955, AttackType.MALICIOUS_CODE);
		assertAttackType(result, 29862.2196, 15678.2914, 9782.5835, AttackType.STOLEN_DEVICES);
		assertAttackType(result, 25596.1882, 13438.5355, 8385.0716, AttackType.MALWARE);
		assertAttackType(result, 25596.1882, 13438.5355, 8385.0716, AttackType.PHISHING_AND_SOCIAL_ENGINEERING);
		assertAttackType(result, 21330.1569, 11198.7795, 6987.5597, AttackType.BOTNETS);
		

	}



	@Ignore
	@Test
	public void testScenarioPublicSectorWithAppointmentOfAHighLevelSecurityLeader(){

		userInputModel.numberOfClients().set(50123);
		userInputModel.sector().set(Sector.PUBLIC_SECTOR);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER);
		
		userInputModel.selectedNumberOfClientsInChart().set(10024);
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(66.90337921, offset(0.001));
		assertThat(result.minCostPerClient().get()).isEqualTo(14.80181171, offset(0.001));
		assertThat(result.maxCostPerClient().get()).isEqualTo(44.57924185, offset(0.001));
		
		assertThat(result.avgCostTotal().get()).isEqualTo(3353398.076, offset(0.001));
		assertThat(result.minCostTotal().get()).isEqualTo(741911.2083, offset(0.001));
		assertThat(result.maxCostTotal().get()).isEqualTo(2234445.339, offset(0.001));
		
		assertThat(result.avgCostSelected().get()).isEqualTo(670639.4732, offset(0.001));
		assertThat(result.minCostSelected().get()).isEqualTo(148373.3606, offset(0.001));
		assertThat(result.maxCostSelected().get()).isEqualTo(446862.3203, offset(0.001));
		
		/**
		 * Kreisdiagramm 1
		 * in Abhängigkeit zu selektiertem Wert
		 */
		
		assertCostComponent(result, 174366.2630, 38577.0737, 116184.2032, CostComponent.PRODUCTIVITY_LOSS);
		assertCostComponent(result, 154247.0788, 34125.8729, 102778.3336, CostComponent.DIRECT_LABOR);
		assertCostComponent(result, 140834.2893, 31158.4057, 93841.0872, CostComponent.INDIRECT_LABOR);
		assertCostComponent(result, 120715.1051, 26707.2049, 80435.2176, CostComponent.CASH_OUTLAY);
		assertCostComponent(result, 60357.5525, 13353.6024, 40217.6088, CostComponent.OVERHEAD);
		assertCostComponent(result, 20119.1841, 4451.2008, 13405.8696, CostComponent.OTHER);
		
		assertExternalConsequence(result, 69746.5052, 15430.8295, 46473.6813, ExternalConsequence.INFORMATION_LOSS);
		assertExternalConsequence(result, 48822.5536, 10801.5806, 32531.5769, ExternalConsequence.REVENUE_LOSS);
		assertExternalConsequence(result, 43591.5657, 9644.2684, 29046.0508, ExternalConsequence.BUSINESS_DISRUPTION);
		assertExternalConsequence(result, 8718.3131, 1928.8536, 5809.2101, ExternalConsequence.EQUIPMENT_DAMAGES);
		assertExternalConsequence(result, 3487.3252, 771.5414, 2323.6840, ExternalConsequence.OTHER_COSTS);
		
		assertInternalActivity(result, 50901.5360, 11261.5380, 33916.8501, InternalActivity.DETECTION);
		assertInternalActivity(result, 33934.3573, 7507.6920, 22611.2334, InternalActivity.RECOVERY);
		assertInternalActivity(result, 29306.9449, 6483.9158, 19527.8833, InternalActivity.INVESTIGATION);
		assertInternalActivity(result, 18509.6494, 4095.1047, 12333.4000, InternalActivity.CONTAINMENT);
		assertInternalActivity(result, 13882.2370, 3071.3285, 9250.0500, InternalActivity.INCIDENT_MANAGMENT);
		assertInternalActivity(result, 7712.3539, 1706.2936, 5138.9166, InternalActivity.EX_POST_RESPONSE);
		
		/**
		 * Kreisdiagramm 2
		 * in Abhängigkeit zu selektiertem Wert
		 */
		
		assertAttackType(result, 140834.2893, 31158.4057, 93841.0872, AttackType.MALICIOUS_INSIDERS);
		assertAttackType(result, 134127.8946, 29674.6721, 89372.4640, AttackType.DENIAL_OF_SERVICES);
		assertAttackType(result, 114008.7104, 25223.4712, 75966.5944, AttackType.WEB_BASED_ATTACKS);
		assertAttackType(result, 60357.5525, 13353.6024, 40217.6088, AttackType.VIRUSES_WORMS_TROJANS);
		assertAttackType(result, 53651.1578, 11869.8688, 35748.9856, AttackType.MALICIOUS_CODE);
		assertAttackType(result, 46944.7631, 10386.1352, 31280.3624, AttackType.STOLEN_DEVICES);
		assertAttackType(result, 40238.3683, 8902.4016, 26811.7392, AttackType.MALWARE);
		assertAttackType(result, 40238.3683, 8902.4016, 26811.7392, AttackType.PHISHING_AND_SOCIAL_ENGINEERING);
		assertAttackType(result, 33531.9736, 7418.6680, 22343.1160, AttackType.BOTNETS);
		
	}

	private void assertCostComponent(Result result, double avg, double min, 
			double max, CostComponent costComponent) {
		assertThat(result.getAvgCostComponentCost(costComponent).get()).isEqualTo(avg, offset(0.001));
		assertThat(result.getMinCostComponentCost(costComponent).get()).isEqualTo(min, offset(0.001));
		assertThat(result.getMaxCostComponentCost(costComponent).get()).isEqualTo(max, offset(0.001));
	}
	
	private void assertExternalConsequence(Result result, double avg, double min,
			double max, ExternalConsequence consequence) {
		assertThat(result.getAvgExternalConsequenceCost(consequence).get()).isEqualTo(avg, offset(0.001));
		assertThat(result.getMinExternalConsequenceCost(consequence).get()).isEqualTo(min, offset(0.001));
		assertThat(result.getMaxExternalConsequenceCost(consequence).get()).isEqualTo(max, offset(0.001));
	}

	private void assertInternalActivity(Result result, double avg, double min,
			double max, InternalActivity activity) {
		assertThat(result.getAvgInternalActivityCost(activity).get()).isEqualTo(avg, offset(0.001));
		assertThat(result.getMinInternalActivityCost(activity).get()).isEqualTo(min, offset(0.001));
		assertThat(result.getMaxInternalActivityCost(activity).get()).isEqualTo(max, offset(0.001));
	}
	
	private void assertAttackType(Result result, double avg, double min, 
			double max, AttackType attacktype){
		assertThat(result.getAvgAttackTypeCost(attacktype).get()).isEqualTo(avg, offset(0.001));
		assertThat(result.getMinAttackTypeCost(attacktype).get()).isEqualTo(min, offset(0.001));
		assertThat(result.getMaxAttackTypeCost(attacktype).get()).isEqualTo(max, offset(0.001));
	}
}
