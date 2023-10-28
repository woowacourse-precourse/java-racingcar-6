package racingcar.domain.inputhandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttemptNumberInputterTest {

    private AttemptNumberInputter inputter;

    @BeforeEach
    public void setUp() {
        inputter = new AttemptNumberInputter();
    }

    @Test
    public void isValidNumber_유요한_인수_true반환() {
        assertTrue(inputter.isValidNumber("123"));
    }

    @Test
    public void isValidNumber_유효하지_않은_인수_false반환() {
        assertFalse(inputter.isValidNumber("12a"));
        assertFalse(inputter.isValidNumber("12.5"));
    }

    @Test
    public void transformAttemptNumberToInt_withValidNumber_shouldReturnInteger() {
        assertEquals(123, inputter.transformAttemptNumberToInt("123"));
    }

    @Test
    public void transformAttemptNumberToInt_withInvalidNumber_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputter.transformAttemptNumberToInt("12a");
        });
    }
}
