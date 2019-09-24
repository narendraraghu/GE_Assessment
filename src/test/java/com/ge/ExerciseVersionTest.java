package com.ge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExerciseVersionTest {

    @Test
    public void getVersionTest() {
        assertEquals("1.0", ExerciseVersion.getVersion());
    }
}