package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputNumberTest {

    @Test
    public void testInvalidStringInput() {
        String invalidNumber = "1a";
        assertThrows(IllegalArgumentException.class, () -> InputValidate.isValidNumber(invalidNumber));
    }

    @Test
    public void testNegativeInput() {
        String negativeNumber = "-5";
        assertThrows(IllegalArgumentException.class, () -> InputValidate.isValidNumber(negativeNumber));
    }
}