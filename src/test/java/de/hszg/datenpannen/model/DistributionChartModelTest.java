package de.hszg.datenpannen.model;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DistributionChartModelTest {

    private DistributionChartModel model;

    private Result resultMock;

    @Before
    public void setup(){
        resultMock = mock(Result.class);

        model = new DistributionChartModel(resultMock);
    }

    @Test
    public void testDistributionData(){

    }


}
