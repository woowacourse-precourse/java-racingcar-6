package racingcar.utils.validator;

import org.junit.jupiter.api.Test;
import racingcar.config.GameConfig;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerRangeValidatorTest {
    private final int min = GameConfig.MIN_TRY_COUNT.getValue();
    private final int max = GameConfig.MAX_TRY_COUNT.getValue();
    @Test
    public void givenValidRangeInteger_whenValidated_thenTrue() {
        assertTrue(IntegerRangeValidator.validate("5", min, max));
    }

    @Test
    public void givenOutOfBoundInteger_whenValidated_thenFalse() {
        assertFalse(IntegerRangeValidator.validate("3000000000", min, max));
    }

    @Test
    public void givenBoundaryValues_whenValidated_thenExpectedResults() {
        assertTrue(IntegerRangeValidator.validate("1", min, max));
        assertTrue(IntegerRangeValidator.validate("2147483647", min, max));
    }

    @Test
    public void givenBoundaryValues_whenValidated_thenUnexpectedResults() {
        assertFalse(IntegerRangeValidator.validate("0", min, max));
        assertFalse(IntegerRangeValidator.validate("2147483648", min, max));
    }
}
