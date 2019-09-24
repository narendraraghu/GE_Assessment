package com.ge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExerciseVersion {

    private static final String VERSION_NUMBER = "1.0";
    private static final Logger logger = LogManager.getLogger(ExerciseVersion.class);

    static String getVersion() {
        logger.info("Exercise version " + VERSION_NUMBER);
        return VERSION_NUMBER;
    }
}
