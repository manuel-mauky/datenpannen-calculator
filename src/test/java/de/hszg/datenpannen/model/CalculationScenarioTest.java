package de.hszg.datenpannen.model;

import static de.hszg.datenpannen.model.InfluencingFactor.CISO_APPOINTMENT;
import static de.hszg.datenpannen.model.InfluencingFactor.QUICK_NOTIFICATION;
import static de.hszg.datenpannen.model.InfluencingFactor.STRONG_SECURITY_POSTURE;
import static de.hszg.datenpannen.model.InfluencingFactor.THIRD_PARTY_ERROR;

import static de.hszg.datenpannen.model.CostDistribution.*;

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
    	
    	
    	/*
    	 * Die Basisdaten zur Berechnung der Werte kommen aus der Klasse BaseDataDummyProvider, da die festen Werte im 
    	 * Programmablauf nicht variabel sind.
    	*/
    	

    	
    	assertEquals(103936.00, result.getAvgCost(),0);
    	assertEquals(55546.91, result.getMinCost(),0);
    	assertEquals(171408.11, result.getMaxCost(),0);
    	
    	assertEquals(36.89,result.getMinDistributionCost(INVESTIGATIONS_AND_FORENSICS),0);
    	assertEquals(62.02,result.getAvgDistributionCost(INVESTIGATIONS_AND_FORENSICS),0);
    	assertEquals(113.83,result.getMaxDistributionCost(INVESTIGATIONS_AND_FORENSICS),0);
    	
    	assertEquals(31.46,result.getMinDistributionCost(LOST_CUSTOMER_BUSINESS),0);
    	assertEquals(58.87,result.getAvgDistributionCost(LOST_CUSTOMER_BUSINESS),0);
    	assertEquals(97.09,result.getMaxDistributionCost(LOST_CUSTOMER_BUSINESS),0);
    	
    	assertEquals(9.76, result.getMinDistributionCost(AUDIT_AND_CONSULTING_SERVICES),0);
    	assertEquals(18.27, result.getAvgDistributionCost(AUDIT_AND_CONSULTING_SERVICES),0);
    	assertEquals(30.13, result.getMaxDistributionCost(AUDIT_AND_CONSULTING_SERVICES),0);
    	
    	assertEquals(7.59, result.getMinDistributionCost(OUTBOUND_CONTACT_COSTS),0);
    	assertEquals(7.59, result.getAvgDistributionCost(OUTBOUND_CONTACT_COSTS),0);
    	assertEquals(23.43, result.getMaxDistributionCost(OUTBOUND_CONTACT_COSTS),0);
    	
    	assertEquals(5.42, result.getMinDistributionCost(LEGAL_SERVICES_COMPLIANCE),0);
    	assertEquals(10.15,result.getAvgDistributionCost(LEGAL_SERVICES_COMPLIANCE),0);
    	assertEquals(16.74, result.getMaxDistributionCost(LEGAL_SERVICES_COMPLIANCE),0);
    	
    	assertEquals(5.42, result.getMinDistributionCost(CUSTOMER_ACQUISITION_COST),0);
    	assertEquals(10.15,result.getAvgDistributionCost(CUSTOMER_ACQUISITION_COST),0);
    	assertEquals(16.74, result.getMaxDistributionCost(CUSTOMER_ACQUISITION_COST),0);
    	
    	assertEquals(4.34, result.getMinDistributionCost(INBOUND_CONTACT_COSTS),0);
    	assertEquals(8.12,result.getAvgDistributionCost(INBOUND_CONTACT_COSTS),0);
    	assertEquals(13.39, result.getMaxDistributionCost(INBOUND_CONTACT_COSTS),0);
    	
    	assertEquals(4.34, result.getMinDistributionCost(LEGAL_SERVICES_DEFENSE),0);
    	assertEquals(8.12,result.getAvgDistributionCost(LEGAL_SERVICES_DEFENSE),0);
    	assertEquals(13.39, result.getMaxDistributionCost(LEGAL_SERVICES_DEFENSE),0);
    	
    	assertEquals(2.17, result.getMinDistributionCost(FREE_OR_DISCOUNTED_SERVICES),0);
    	assertEquals(4.06, result.getAvgDistributionCost(FREE_OR_DISCOUNTED_SERVICES),0);
    	assertEquals(6.70, result.getMaxDistributionCost(FREE_OR_DISCOUNTED_SERVICES),0);
    	
    	assertEquals(1.08, result.getMinDistributionCost(IDENTITY_PROTECTION_SERVICES),0);
    	assertEquals(2.03, result.getAvgDistributionCost(IDENTITY_PROTECTION_SERVICES),0);
    	assertEquals(3.35, result.getMaxDistributionCost(IDENTITY_PROTECTION_SERVICES),0);
    	
    	assertEquals(0.0,result.getMinDistributionCost(PUBLIC_RELATIONS_COMMUNICATIONS),0);
    	assertEquals(0.0,result.getAvgDistributionCost(PUBLIC_RELATIONS_COMMUNICATIONS),0);
    	assertEquals(0.0,result.getMaxDistributionCost(PUBLIC_RELATIONS_COMMUNICATIONS),0);
    }
}
