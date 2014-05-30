package de.hszg.datenpannen.virus.model;

import de.hszg.datenpannen.virus.data.StaticVirusDataProvider;
import org.junit.Before;
import org.junit.Test;

import static eu.lestard.assertj.javafx.api.Assertions.*;
import static org.assertj.core.data.Offset.*;
/**
 * 
 * Dieser Test beschreibt die Berechnungen im Virenbefall-Abschnitt der Anwendung.
 * 
 */
public class VirusCalculationScenarioTest {

    private static final double OFFSET = 0.01;

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
		
		assertThat(result.avgCostPerClient()).hasValue(984.090284, offset(OFFSET));
		assertThat(result.minCostPerClient()).hasValue(322.378764, offset(OFFSET));
		assertThat(result.maxCostPerClient()).hasValue(5166.7476320367, offset(OFFSET));

		assertThat(result.avgCostTotal()).hasValue(853206.277, offset(OFFSET));
		assertThat(result.minCostTotal()).hasValue(279502.388, offset(OFFSET));
		assertThat(result.maxCostTotal()).hasValue(4479570.19697581, offset(OFFSET));

		assertThat(result.avgCostSelected()).hasValue(427095.183431358, offset(OFFSET));
		assertThat(result.minCostSelected()).hasValue(139912.383483414, offset(OFFSET));
		assertThat(result.maxCostSelected()).hasValue(2242368.47230392, offset(OFFSET));

		/**
		 * Ab hier wird das Kreisdiagramm 1 geprüft.
		 * Die Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients.
		 */
		
		assertCostComponent(result, 111044.747692153, 36377.2197056876, 583015.80279902, CostComponent.PRODUCTIVITY_LOSS);
		assertCostComponent(result, 98231.8921892123, 32179.8482011852, 515744.748629902, CostComponent.DIRECT_LABOR);
		assertCostComponent(result, 89689.9885205852,  29381.6005315169, 470897.379183824, CostComponent.INDIRECT_LABOR);
		assertCostComponent(result, 76877.1330176444, 25184.2290270145, 403626.325014706, CostComponent.CASH_OUTLAY);
		assertCostComponent(result, 38438.5665088222,  12592.1145135073, 201813.162507353, CostComponent.OVERHEAD);
		assertCostComponent(result, 12812.8555029407,  4197.3715045024, 67271.0541691177, CostComponent.OTHER);
		
		assertExternalConsequence(result, 44417.8990768612, 14550.887882275, 233206.321119608, ExternalConsequence.INFORMATION_LOSS);
		assertExternalConsequence(result, 31092.5293538029, 10185.6215175925, 163244.424783726, ExternalConsequence.REVENUE_LOSS);
		assertExternalConsequence(result, 27761.1869230383,  9094.3049264219, 145753.950699755, ExternalConsequence.BUSINESS_DISRUPTION);
		assertExternalConsequence(result, 5552.2373846077,  1818.8609852844, 29150.790139951, ExternalConsequence.EQUIPMENT_DAMAGES);
		assertExternalConsequence(result, 2220.8949538431,  727.5443941138, 11660.3160559804, ExternalConsequence.OTHER_COSTS);
		
		assertInternalActivity(result, 32416.5244224401,  10619.3499063911, 170195.767047868, InternalActivity.DETECTION);
		assertInternalActivity(result, 21611.0162816267,  7079.5666042608, 113463.844698579, InternalActivity.RECOVERY);
		assertInternalActivity(result, 18664.0595159503,  6114.1711582252, 97991.5022396815, InternalActivity.INVESTIGATION);
		assertInternalActivity(result, 11787.8270627055,  3861.5817841422, 61889.3698355883, InternalActivity.CONTAINMENT);
		assertInternalActivity(result, 8840.8702970291,  2896.1863381067, 46417.0273766912, InternalActivity.INCIDENT_MANAGMENT);
		assertInternalActivity(result, 4911.5946094606,  1608.9924100593, 25787.2374314951, InternalActivity.EX_POST_RESPONSE);
		
		/**
		 * Kreisdiagramm Kosten bei Angriffen, Werte stehen in Abhängigkeit zur ausgewählten Anzahl an Clients
		 */
		
		assertAttackType(result, 89689.9885205852,  29381.6005315169, 470897.379183824, AttackType.MALICIOUS_INSIDERS);
		assertAttackType(result, 85419.0366862716,  27982.4766966828, 448473.694460785, AttackType.DENIAL_OF_SERVICES);
		assertAttackType(result, 72606.1811833309,  23785.1051921804, 381202.640291667, AttackType.WEB_BASED_ATTACKS);
		assertAttackType(result, 38438.5665088222,  12592.1145135073, 201813.162507353, AttackType.VIRUSES_WORMS_TROJANS);
		assertAttackType(result, 34167.6146745086,  11192.9906786731, 179389.477784314, AttackType.MALICIOUS_CODE);
		assertAttackType(result, 29896.662840195,  9793.866843839, 156965.793061275, AttackType.STOLEN_DEVICES);
		assertAttackType(result, 25625.7110058815, 8394.7430090048, 134542.108338235, AttackType.MALWARE);
		assertAttackType(result, 25625.7110058815, 8394.7430090048, 134542.108338235, AttackType.PHISHING_AND_SOCIAL_ENGINEERING);
		assertAttackType(result, 21354.7591715679,  6995.6191741707, 112118.423615196, AttackType.BOTNETS);
		

	}



	@Test
	public void testScenarioPublicSectorWithAppointmentOfAHighLevelSecurityLeader(){

		userInputModel.numberOfClients().set(50123);
		userInputModel.sector().set(Sector.PUBLIC_SECTOR);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER);
		
		userInputModel.selectedNumberOfClientsInChart().set(10024);
		
		assertThat(result.avgCostPerClient()).hasValue(66.90337921, offset(OFFSET));
		assertThat(result.minCostPerClient()).hasValue(44.57924185, offset(OFFSET));
		assertThat(result.maxCostPerClient()).hasValue(148.0200455731, offset(OFFSET));

		assertThat(result.avgCostTotal()).hasValue(3353398.076, offset(OFFSET));
		assertThat(result.minCostTotal()).hasValue(2234445.339, offset(OFFSET));
		assertThat(result.maxCostTotal()).hasValue(7419208.74425876, offset(OFFSET));

		assertThat(result.avgCostSelected()).hasValue(670639.4732, offset(OFFSET));
		assertThat(result.minCostSelected()).hasValue(446862.3203, offset(OFFSET));
		assertThat(result.maxCostSelected()).hasValue(1483752.93682441, offset(OFFSET));

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
		assertThat(result.getAvgCostComponentCost(costComponent)).hasValue(avg, offset(OFFSET));
		assertThat(result.getMinCostComponentCost(costComponent)).hasValue(min, offset(OFFSET));
		assertThat(result.getMaxCostComponentCost(costComponent)).hasValue(max, offset(OFFSET));
	}
	
	private void assertExternalConsequence(VirusResult result, double avg, double min,
			double max, ExternalConsequence consequence) {
		assertThat(result.getAvgExternalConsequenceCost(consequence)).hasValue(avg, offset(OFFSET));
		assertThat(result.getMinExternalConsequenceCost(consequence)).hasValue(min, offset(OFFSET));
		assertThat(result.getMaxExternalConsequenceCost(consequence)).hasValue(max, offset(OFFSET));
	}

	private void assertInternalActivity(VirusResult result, double avg, double min,
			double max, InternalActivity activity) {
		assertThat(result.getAvgInternalActivityCost(activity)).hasValue(avg, offset(OFFSET));
		assertThat(result.getMinInternalActivityCost(activity)).hasValue(min, offset(OFFSET));
		assertThat(result.getMaxInternalActivityCost(activity)).hasValue(max, offset(OFFSET));
	}
	
	private void assertAttackType(VirusResult result, double avg, double min,
			double max, AttackType attacktype){
		assertThat(result.getAvgAttackTypeCost(attacktype)).hasValue(avg, offset(OFFSET));
		assertThat(result.getMinAttackTypeCost(attacktype)).hasValue(min, offset(OFFSET));
		assertThat(result.getMaxAttackTypeCost(attacktype)).hasValue(max, offset(OFFSET));
	}
}
