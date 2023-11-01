package racingcar.validate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceValidatorTest {

    @Test
    public void testValidateCarNames() {
        // Test valid car names
        String[] validCarNames = {"car1", "car2", "car3"};
        RaceValidator.validateCarNames(validCarNames);

        // Test car name length exceeding 5 characters
        String[] invalidCarNames = {"car1", "car2", "car3456"};
        assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateCarNames(invalidCarNames));

        // Test duplicate car names
        String[] duplicateCarNames = {"car1", "car2", "car1"};
        assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateCarNames(duplicateCarNames));
    }

    @Test
    public void testValidateTrials() {
        // Test valid trial input
        String validTrial = "5";
        int result = RaceValidator.validateTrials(validTrial);
        assertEquals(5, result);

        // Test invalid trial input (non-integer)
        String invalidTrial = "invalid";
        assertThrows(IllegalArgumentException.class, () -> RaceValidator.validateTrials(invalidTrial));
    }
}
