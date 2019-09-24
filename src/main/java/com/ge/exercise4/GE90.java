package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 extends Engine {
	
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();
    private final String serialNumber;
    private double flightHours;
    private int numRebuilds;

    private GE90(String serialNumber, double flightHours, int numRebuilds) {
    	super(3, 25_000, 14_502, 15_100, 81_070);
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }

    private GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public double getFlightHours() {
        return flightHours;
    }

    void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    double getFlightHoursBeforeRebuild(){
    	return flightHoursBeforeRebuild-flightHours;
    }
    
    double serviceLifeLeft(){
    	return ((maxNumRebuilds - numRebuilds)*flightHoursBeforeRebuild)-flightHours;
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }

}
