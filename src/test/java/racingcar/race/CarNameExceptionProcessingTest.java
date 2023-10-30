package racingcar.race;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarNameExceptionProcessingTest {


    @Test
    public void testCheckEmpty() {
        String validCarName = "Car";
        String invalidCarName = "";

        assertDoesNotThrow(() -> CarNameExceptionProcessing.checkEmpty(validCarName));
        assertThrows(IllegalArgumentException.class, () -> CarNameExceptionProcessing.checkEmpty(invalidCarName));
    }

    @Test
    public void testCheckEquals() {
        String validCarName = "Car";
        String invalidCarName = " ";

        assertDoesNotThrow(() -> CarNameExceptionProcessing.checkEquals(validCarName));
        assertThrows(IllegalArgumentException.class, () -> CarNameExceptionProcessing.checkEquals(invalidCarName));
    }
}

