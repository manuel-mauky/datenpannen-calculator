package de.hszg.datenpannen.dataloss.model;

import de.hszg.datenpannen.dataloss.model.DistributionChartModel;
import de.hszg.datenpannen.dataloss.model.Result;
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
