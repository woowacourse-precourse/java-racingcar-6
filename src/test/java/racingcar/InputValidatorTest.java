package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {
    @Test
    public void testValidCarNames() {
        String[] validCarNames = {"abc", "def", "ghi", "jklm", "nopqr"};
        assertTrue(InputValidator.carName(validCarNames));
    }

    @Test
    public void testInvalidCarNames() {
        String[] invalidCarNames = {"abcdef", "123", "a1b2c3", "abc-def", ""};
        assertFalse(InputValidator.carName(invalidCarNames));
    }
}
