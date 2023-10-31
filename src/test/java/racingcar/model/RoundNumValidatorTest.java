package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundNumValidatorTest {
    @Test
    public void testValidateWithValidInput() {
        assertDoesNotThrow(() -> new RoundNumValidator("3"));
    }

    @Test
    public void testValidateWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> new RoundNumValidator("abc"));
    }

    @Test
    public void testValidateWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> new RoundNumValidator("-2"));
    }

    @Test
    public void testValidateWithZeroInput() {
        assertThrows(IllegalArgumentException.class, () -> new RoundNumValidator("0"));
    }
}