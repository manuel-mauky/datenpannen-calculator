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
@Ignore
public class VirusCalculationScenarioTest {

    private static final double OFFSET = 0.001;

	private VirusResult result;
	private BaseDataModel baseDataModel;
	private UserInputModel userInputModel;
	
	@Before
	public void setup(){
		StaticVirusDataProvider baseDataProvider = new StaticVirusDataProvider();
		
		baseDataModel = new BaseDataModel(baseDataProvider);
		userInputModel = new UserInputModel();
		
		result = new VirusResult(baseDataModel, userInputModel);
	}
	
	@Test
	public void testScenarioFinancialServicesWithExtensiveUseOfSecurityMetrics() {
		userInputModel.numberOfClients().set(867);
		userInputModel.sector().set(Sector.FINANCIAL_SERVICES);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.EXTENSIVE_USE_OF_SECURITY_METRICS);
		
		userInputModel.selectedNumberOfClientsInChart().set(434);
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(984.090284, offset(OFFSET));
		assertThat(result.minCostPerClient().get()).isEqualTo(322.378764, offset(OFFSET));
		assertThat(result.maxCostPerClient().get()).isEqualTo(5166.7476320367, offset(OFFSET));

		assertThat(result.avgCostTotal().get()).isEqualTo(853206.277, offset(OFFSET));
		assertThat(result.minCostTotal().get()).isEqualTo(279502.388, offset(OFFSET));
		assertThat(result.maxCostTotal().get()).isEqualTo(4479570.19697581, offset(OFFSET));

		assertThat(result.avgCostSelected().get()).isEqualTo(426603.138, offset(OFFSET));
		assertThat(result.minCostSelected().get()).isEqualTo(139751.194, offset(OFFSET));
		assertThat(result.maxCostSelected().get()).isEqualTo(2239785.09848791, offset(OFFSET));

		/**
		 * Ab hier wird das Kreisdiagramm 1 geprüft.
		 * Die Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients.
		 */
		
		assertCostComponent(result, 110916.816,  36335.3105, 582344.125606855, CostComponent.PRODUCTIVITY_LOSS);
		assertCostComponent(result, 98118.7218,  32142.7746, 515150.572652218, CostComponent.DIRECT_LABOR);
		assertCostComponent(result, 89586.659,  29347.7508, 470354.87068246, CostComponent.INDIRECT_LABOR);
		assertCostComponent(result, 76788.5649,  25155.2149, 403161.317727823, CostComponent.CASH_OUTLAY);
		assertCostComponent(result, 38394.2824,  12577.6075, 201580.658863911, CostComponent.OVERHEAD);
		assertCostComponent(result, 12798.0941,  4192.53582, 67193.5529546372, CostComponent.OTHER);
		
		assertExternalConsequence(result, 44366.7264,  14534.1242, 232937.650242742, ExternalConsequence.INFORMATION_LOSS);
		assertExternalConsequence(result, 31056.7085,  10173.8869, 163056.35516992, ExternalConsequence.REVENUE_LOSS);
		assertExternalConsequence(result, 27729.204,  9083.82762, 145586.031401714, ExternalConsequence.BUSINESS_DISRUPTION);
		assertExternalConsequence(result, 5545.8408,  1816.76552, 29117.2062803428, ExternalConsequence.EQUIPMENT_DAMAGES);
		assertExternalConsequence(result, 2218.33632,  726.706209, 11646.8825121371, ExternalConsequence.OTHER_COSTS);
		
		assertInternalActivity(result, 32379.1782,  10607.1156, 169999.688975232, InternalActivity.DETECTION);
		assertInternalActivity(result, 21586.1188,  7071.41042, 113333.125983488, InternalActivity.RECOVERY);
		assertInternalActivity(result, 18642.5571,  6107.12718, 97878.6088039215, InternalActivity.INVESTIGATION);
		assertInternalActivity(result, 11774.2466,  3857.13296, 61818.0687182662, InternalActivity.CONTAINMENT);
		assertInternalActivity(result, 8830.68496,  2892.84972, 46363.5515386996, InternalActivity.INCIDENT_MANAGMENT);
		assertInternalActivity(result, 4905.93609,  1607.13873, 25757.5286326109, InternalActivity.EX_POST_RESPONSE);
		
		/**
		 * Kreisdiagramm Kosten bei Angriffen, Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients
		 */
		
		assertAttackType(result, 89586.6590,  29347.7507, 470354.87068246, AttackType.MALICIOUS_INSIDERS);
		assertAttackType(result, 85320.6276,  27950.2388, 447957.019697581, AttackType.DENIAL_OF_SERVICES);
		assertAttackType(result, 72522.5335,  23757.7029, 380763.466742944, AttackType.WEB_BASED_ATTACKS);
		assertAttackType(result, 38394.2824,  12577.6074, 201580.658863911, AttackType.VIRUSES_WORMS_TROJANS);
		assertAttackType(result, 34128.2510,  11180.0955, 179182.807879032, AttackType.MALICIOUS_CODE);
		assertAttackType(result, 29862.2196,  9782.5835, 156784.956894153, AttackType.STOLEN_DEVICES);
		assertAttackType(result, 25596.1882,  8385.0716, 134387.105909274, AttackType.MALWARE);
		assertAttackType(result, 25596.1882,  8385.0716, 134387.105909274, AttackType.PHISHING_AND_SOCIAL_ENGINEERING);
		assertAttackType(result, 21330.1569,  6987.5597, 111989.254924395, AttackType.BOTNETS);
		

	}



	@Test
	public void testScenarioPublicSectorWithAppointmentOfAHighLevelSecurityLeader(){

		userInputModel.numberOfClients().set(50123);
		userInputModel.sector().set(Sector.PUBLIC_SECTOR);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER);
		
		userInputModel.selectedNumberOfClientsInChart().set(10024);
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(66.90337921, offset(OFFSET));
		assertThat(result.minCostPerClient().get()).isEqualTo(44.57924185, offset(OFFSET));
		assertThat(result.maxCostPerClient().get()).isEqualTo(148.0200455731, offset(OFFSET));

		assertThat(result.avgCostTotal().get()).isEqualTo(3353398.076, offset(OFFSET));
		assertThat(result.minCostTotal().get()).isEqualTo(2234445.339, offset(OFFSET));
		assertThat(result.maxCostTotal().get()).isEqualTo(7419208.74425876, offset(OFFSET));

		assertThat(result.avgCostSelected().get()).isEqualTo(670639.4732, offset(OFFSET));
		assertThat(result.minCostSelected().get()).isEqualTo(446862.3203, offset(OFFSET));
		assertThat(result.maxCostSelected().get()).isEqualTo(1483752.93682441, offset(OFFSET));

		/**
		 * Kreisdiagramm 1
		 * in Abhängigkeit zu selektiertem Wert
		 */
		
		assertCostComponent(result, 174366.2630, 116184.2032, 385775.7635, CostComponent.PRODUCTIVITY_LOSS);
		assertCostComponent(result, 154247.0788,  102778.3336, 341263.175469614, CostComponent.DIRECT_LABOR);
		assertCostComponent(result, 140834.2893,  93841.0872, 311588.116733126, CostComponent.INDIRECT_LABOR);
		assertCostComponent(result, 120715.1051,  80435.2176, 267075.528628393, CostComponent.CASH_OUTLAY);
		assertCostComponent(result, 60357.5525,  40217.6088, 133537.764314197, CostComponent.OVERHEAD);
		assertCostComponent(result, 20119.1841,  13405.8696, 44512.5881047322, CostComponent.OTHER);
		
		assertExternalConsequence(result, 69746.5052,  46473.6813, 154310.305429738, ExternalConsequence.INFORMATION_LOSS);
		assertExternalConsequence(result, 48822.5536,  32531.5769, 108017.213800817, ExternalConsequence.REVENUE_LOSS);
		assertExternalConsequence(result, 43591.5657,  29046.0508, 96443.9408935865, ExternalConsequence.BUSINESS_DISRUPTION);
		assertExternalConsequence(result, 8718.3131,  5809.2101, 19288.7881787173, ExternalConsequence.EQUIPMENT_DAMAGES);
		assertExternalConsequence(result, 3487.3252,  2323.6840, 7715.5152714869, ExternalConsequence.OTHER_COSTS);
		
		assertInternalActivity(result, 50901.5360,  33916.8501, 112616.847904973, InternalActivity.DETECTION);
		assertInternalActivity(result, 33934.3573,  22611.2334, 75077.898603315, InternalActivity.RECOVERY);
		assertInternalActivity(result, 29306.9449,  19527.8833, 64840.0033392266, InternalActivity.INVESTIGATION);
		assertInternalActivity(result, 18509.6494,  12333.4000, 40951.5810563536, InternalActivity.CONTAINMENT);
		assertInternalActivity(result, 13882.2370,  9250.0500, 30713.6857922652, InternalActivity.INCIDENT_MANAGMENT);
		assertInternalActivity(result, 7712.3539,  5138.9166, 17063.1587734807, InternalActivity.EX_POST_RESPONSE);
		
		/**
		 * Kreisdiagramm 2
		 * in Abhängigkeit zu selektiertem Wert
		 */
		
		assertAttackType(result, 140834.2893,  93841.0872, 311588.116733126, AttackType.MALICIOUS_INSIDERS);
		assertAttackType(result, 134127.8946,  89372.4640, 296750.587364881, AttackType.DENIAL_OF_SERVICES);
		assertAttackType(result, 114008.7104,  75966.5944, 252237.999260149, AttackType.WEB_BASED_ATTACKS);
		assertAttackType(result, 60357.5525,  40217.6088, 133537.764314197, AttackType.VIRUSES_WORMS_TROJANS);
		assertAttackType(result, 53651.1578,  35748.9856, 118700.234945953, AttackType.MALICIOUS_CODE);
		assertAttackType(result, 46944.7631,  31280.3624, 103862.705577709, AttackType.STOLEN_DEVICES);
		assertAttackType(result, 40238.3683,  26811.7392, 89025.1762094644, AttackType.MALWARE);
		assertAttackType(result, 40238.3683,  26811.7392, 89025.1762094644, AttackType.PHISHING_AND_SOCIAL_ENGINEERING);
		assertAttackType(result, 33531.9736,  22343.1160, 74187.6468412204, AttackType.BOTNETS);
		
	}

	private void assertCostComponent(VirusResult result, double avg, double min,
			double max, CostComponent costComponent) {
		assertThat(result.getAvgCostComponentCost(costComponent).get()).isEqualTo(avg, offset(OFFSET));
		assertThat(result.getMinCostComponentCost(costComponent).get()).isEqualTo(min, offset(OFFSET));
		assertThat(result.getMaxCostComponentCost(costComponent).get()).isEqualTo(max, offset(OFFSET));
	}
	
	private void assertExternalConsequence(VirusResult result, double avg, double min,
			double max, ExternalConsequence consequence) {
		assertThat(result.getAvgExternalConsequenceCost(consequence).get()).isEqualTo(avg, offset(OFFSET));
		assertThat(result.getMinExternalConsequenceCost(consequence).get()).isEqualTo(min, offset(OFFSET));
		assertThat(result.getMaxExternalConsequenceCost(consequence).get()).isEqualTo(max, offset(OFFSET));
	}

	private void assertInternalActivity(VirusResult result, double avg, double min,
			double max, InternalActivity activity) {
		assertThat(result.getAvgInternalActivityCost(activity).get()).isEqualTo(avg, offset(OFFSET));
		assertThat(result.getMinInternalActivityCost(activity).get()).isEqualTo(min, offset(OFFSET));
		assertThat(result.getMaxInternalActivityCost(activity).get()).isEqualTo(max, offset(OFFSET));
	}
	
	private void assertAttackType(VirusResult result, double avg, double min,
			double max, AttackType attacktype){
		assertThat(result.getAvgAttackTypeCost(attacktype).get()).isEqualTo(avg, offset(OFFSET));
		assertThat(result.getMinAttackTypeCost(attacktype).get()).isEqualTo(min, offset(OFFSET));
		assertThat(result.getMaxAttackTypeCost(attacktype).get()).isEqualTo(max, offset(OFFSET));
	}
}
