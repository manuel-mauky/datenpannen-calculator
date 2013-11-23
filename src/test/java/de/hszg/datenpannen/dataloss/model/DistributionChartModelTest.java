package de.hszg.datenpannen.dataloss.model;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DistributionChartModelTest {

    private DistributionChartModel model;

    private DatalossResult resultMock;

    @Before
    public void setup(){
        resultMock = mock(DatalossResult.class);

        model = new DistributionChartModel(resultMock);
    }

    @Test
    public void testDistributionData(){

    }


}
