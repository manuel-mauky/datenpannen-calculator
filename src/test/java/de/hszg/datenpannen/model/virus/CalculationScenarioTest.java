package de.hszg.datenpannen.model.virus;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.data.Offset.offset;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.hszg.datenpannen.data.virus.BaseDataDummyProvider;

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
		BaseDataDummyProvider baseDataProvider = new BaseDataDummyProvider();
		
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
		
		//TODO beImplemented userInputModel.selectedNumberOfClientsInChart();
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(984.090284, offset(0.001));
		assertThat(result.minCostPerClient().get()).isEqualTo(516.668032, offset(0.001));
		assertThat(result.maxCostPerClient().get()).isEqualTo(322.378764, offset(0.001));
		
		assertThat(result.avgCostTotal().get()).isEqualTo(853206.277, offset(0.001));
		assertThat(result.minCostTotal().get()).isEqualTo(447951.184, offset(0.001));
		assertThat(result.maxCostTotal().get()).isEqualTo(279502.388, offset(0.001));
		
		//TODO hasToBeImplemented

	}
	
	@Ignore
	@Test
	public void testScenarioPublicSectorWithAppointmentOfAHighLevelSecurityLeader(){

		userInputModel.numberOfClients().set(50123);
		userInputModel.sector().set(Sector.PUBLIC_SECTOR);
		userInputModel.securityGovernanceActivity().set(SecurityGovernanceActivity.APPOINTMENT_OF_A_HIGH_LEVEL_SECURITY_LEADER);
		
		assertThat(result.avgCostPerClient().get()).isEqualTo(66.90337921, offset(0.001));
		assertThat(result.minCostPerClient().get()).isEqualTo(14.80181171, offset(0.001));
		assertThat(result.maxCostPerClient().get()).isEqualTo(44.57924185, offset(0.001));
		
		assertThat(result.avgCostTotal().get()).isEqualTo(3353398.076, offset(0.001));
		assertThat(result.minCostTotal().get()).isEqualTo(741911.2083, offset(0.001));
		assertThat(result.maxCostTotal().get()).isEqualTo(2234445.339, offset(0.001));
		
		//TODO hasToBeImplemented
	
	}

}
