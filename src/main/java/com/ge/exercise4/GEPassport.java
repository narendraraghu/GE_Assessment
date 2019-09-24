package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GEPassport extends Engine{
    private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GEPassport.class.getSimpleName();
    private final String serialNumber;
    private double flightHours;
    private int numRebuilds;

    private GEPassport(String serialNumber, double flightHours, int numRebuilds) {
    	super(0, 50_000, 4_505, 5_230, 20_650);
        this.serialNumber = serialNumber;
        this.flightHours = flightHours;
        this.numRebuilds = numRebuilds;
    }
    private GEPassport(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    GEPassport(String serialNumber) {
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
    	if(maxNumRebuilds <= 0 && (maxNumRebuilds - numRebuilds) <= 0) {
    		return 0;
    	} else {
    		return ((maxNumRebuilds - numRebuilds)*flightHoursBeforeRebuild)-flightHours;
    	}
    }
    
    public String toString() {
        return ENGINE_MODEL + " SN: " + serialNumber;
    }

}
