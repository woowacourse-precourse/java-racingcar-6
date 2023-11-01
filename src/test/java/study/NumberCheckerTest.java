package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberCheckerTest {
    @Test
    public void testValidNumber() {
        String validNumber = "12345";
        Assertions.assertTrue(Application.checkNumber(validNumber));
    }

    @Test
    public void testInvalidNumber() {
        String invalidNumber = "abc123";
        assertFalse(Application.checkNumber(invalidNumber));

        invalidNumber = "  ";
        assertFalse(Application.checkNumber(invalidNumber));

        invalidNumber = "-1";
        assertFalse(Application.checkNumber(invalidNumber));

        invalidNumber = "h";
        assertFalse(Application.checkNumber(invalidNumber));
    }
}
