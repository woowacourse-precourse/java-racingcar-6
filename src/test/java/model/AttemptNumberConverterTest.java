package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttemptNumberConverterTest {

    @Test
    void 시도횟수_String을_int로_반환() {
        String validAttemptNumber = "42";

        int result = AttemptNumberConverter.convertStringToInteger(validAttemptNumber);

        int expected = 42;
        assertEquals(expected, result);
    }
}