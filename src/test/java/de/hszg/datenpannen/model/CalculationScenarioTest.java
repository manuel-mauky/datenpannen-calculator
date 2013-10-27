package de.hszg.datenpannen.model;

import static de.hszg.datenpannen.model.InfluencingFactor.CISO_APPOINTMENT;
import static de.hszg.datenpannen.model.InfluencingFactor.QUICK_NOTIFICATION;
import static de.hszg.datenpannen.model.InfluencingFactor.STRONG_SECURITY_POSTURE;
import static de.hszg.datenpannen.model.InfluencingFactor.THIRD_PARTY_ERROR;

import static de.hszg.datenpannen.model.CostDistribution.*;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.data.Offset.offset;


import de.hszg.datenpannen.data.BaseDataDummyProvider;
import de.hszg.datenpannen.data.BaseDataProvider;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
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
    public void setup() {
        BaseDataDummyProvider baseDataProvider = new BaseDataDummyProvider();

        baseDataModel = new BaseDataModel(baseDataProvider);
        userinputModel = new UserinputModel();

        result = new Result(baseDataModel, userinputModel);
    }


    /**
     * TODO Umbenennen und vernünftige Testschritte ergänzen.
     */
    @Ignore
    @Test
    public void testScenarioKleinesEnergieunternehmen() {

        userinputModel.numberOfDatasets().set(512);
        userinputModel.sector().set(Sector.ENERGY);
        userinputModel.influencingFactors().add(THIRD_PARTY_ERROR);
        userinputModel.influencingFactors().add(QUICK_NOTIFICATION);
        userinputModel.influencingFactors().add(CISO_APPOINTMENT);
        userinputModel.influencingFactors().add(STRONG_SECURITY_POSTURE);


        assertThat(result.avgCostPerDataset().get()).isEqualTo(203);
        assertThat(result.minCostPerDataset().get()).isEqualTo(108.490066, offset(0.001));
        assertThat(result.maxCostPerDataset().get()).isEqualTo(334.781457, offset(0.001));

        assertThat(result.avgCostTotal().get()).isEqualTo(103936.00, offset(0.01));
        assertThat(result.minCostTotal().get()).isEqualTo(55546.91, offset(0.01));
        assertThat(result.maxCostTotal().get()).isEqualTo(171408.11, offset(0.01));

        assertDistribution(result, 36.89, 69.02, 113.83, INVESTIGATIONS_AND_FORENSICS);
        assertDistribution(result, 31.46, 58.87, 97.09, LOST_CUSTOMER_BUSINESS);
        assertDistribution(result, 9.76, 18.27, 30.13, AUDIT_AND_CONSULTING_SERVICES);
        assertDistribution(result, 7.59, 14.21, 23.43, OUTBOUND_CONTACT_COSTS);
        assertDistribution(result, 5.42, 10.15, 16.74, LEGAL_SERVICES_COMPLIANCE);
        assertDistribution(result, 5.42, 10.15, 16.74, CUSTOMER_ACQUISITION_COST);
        assertDistribution(result, 4.34, 8.12, 13.39, INBOUND_CONTACT_COSTS);
        assertDistribution(result, 4.34, 8.12, 13.39, LEGAL_SERVICES_DEFENSE);
        assertDistribution(result, 2.17, 4.06, 6.70, FREE_OR_DISCOUNTED_SERVICES);
        assertDistribution(result, 1.08, 2.03, 3.35, IDENTITY_PROTECTION_SERVICES);
        assertDistribution(result, 0.0, 0.0, 0.0, PUBLIC_RELATIONS_COMMUNICATIONS);
    }

    private void assertDistribution(Result result, double min, double avg, double max, CostDistribution distribution) {
        assertThat(result.getMinDistributionCost(distribution).get()).isEqualTo(min, offset(0.01));
        assertThat(result.getAvgDistributionCost(distribution).get()).isEqualTo(avg, offset(0.01));
        assertThat(result.getMaxDistributionCost(distribution).get()).isEqualTo(max, offset(0.01));
    }
}
