package de.hszg.datenpannen.model;

import org.junit.Before;
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
    @Test
    public void testScenario1(){

        // setter BaseDataModel
        // setter UserinputModel


        // assert getter Result
    }
}
