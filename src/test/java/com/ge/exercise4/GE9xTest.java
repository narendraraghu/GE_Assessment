package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE9xTest {

    GE9x testEngine;

    @Before
    public void setUp() {
        testEngine = new GE9x("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GE9x SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    
    @Test
	public void hoursLeftforrebuildTest() {
		testEngine.setFlightHours(10000);
		assertEquals(20000.0, testEngine.getFlightHoursBeforeRebuild(), 0.0);
	}
	
	@Test
	public void serviceLifeLeftTest() {
		testEngine.setFlightHours(10000);
		assertEquals(140000.0, testEngine.serviceLifeLeft(), 0.0);
	}

}