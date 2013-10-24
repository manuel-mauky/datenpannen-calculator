package de.hszg.datenpannen.model;

import static de.hszg.datenpannen.model.InfluencingFactor.CISO_APPOINTMENT;
import static de.hszg.datenpannen.model.InfluencingFactor.QUICK_NOTIFICATION;
import static de.hszg.datenpannen.model.InfluencingFactor.STRONG_SECURITY_POSTURE;
import static de.hszg.datenpannen.model.InfluencingFactor.THIRD_PARTY_ERROR;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Dieser Test überprüft die Gesamtberechnung.
 */
public class CalculationScenarioTest {

    private Result result;

    private BaseDataModel baseDataModel;
    private UserinputModel userinputModel;

    @Before
    public void setup(){
        baseDataModel = new BaseDataModel();
        userinputModel = new UserinputModel();


        result = new Result(baseDataModel,userinputModel);
    }


    /**
     * TODO Umbenennen und vernünftige Testschritte ergänzen.
     */
    @Ignore
    @Test
    public void testScenarioKleinesEnergieunternehmen(){

    	userinputModel.setNumberOfDataset(512);
    	userinputModel.setSector(Sector.ENERGY);
    	userinputModel.addInfluencingFactors(THIRD_PARTY_ERROR, QUICK_NOTIFICATION, CISO_APPOINTMENT, STRONG_SECURITY_POSTURE);
    	
    	
        // setter BaseDataModel
        // setter UserinputModel

    	
    	assertEquals(103936.00, result.getAvgCost(),0);
    	assertEquals(55546.91, result.getMinCost(),0);
    	assertEquals(171408.11, result.getMaxCost(),0);
    	
    	//mehrere Beispiele für alle kostenabschnitte testen
    	assertEquals(0.0,result.getMinDistributionCost(CostDistribution.PUBLIC_RELATIONS_COMMUNICATIONS),0);
    	assertEquals(0.0,result.getAvgDistributionCost(CostDistribution.PUBLIC_RELATIONS_COMMUNICATIONS),0);
    	assertEquals(0.0,result.getMaxDistributionCost(CostDistribution.PUBLIC_RELATIONS_COMMUNICATIONS),0);
        // assert getter Result
    }
}
