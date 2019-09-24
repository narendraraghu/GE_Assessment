package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE9x extends Engine{

    private static final Logger logger = LogManager.getLogger(GE9x.class);

    private static final String ENGINE_MODEL = GE9x.class.getSimpleName();
   
    private final String serialNumber;

    private double flightHours;
    private int numRebuilds;

    public GE9x(String serialNumber, double flightHours, int numRebuilds) {
    	super(5, 30_000, 15_505, 15_900, 100_000);
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }


    private GE9x(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    GE9x(String serialNumber) {
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
