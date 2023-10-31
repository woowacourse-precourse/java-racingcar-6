package racingcar.utils.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsIntegerValidatorTest {

    @Test
    public void givenValidIntegerString_whenValidated_thenTrue() {
        assertTrue(IsIntegerValidator.validate("12345"));
    }

    @Test
    public void givenInvalidIntegerString_whenValidated_thenFalse() {
        assertFalse(IsIntegerValidator.validate("12345a"));
    }

    @Test
    public void givenBoundaryValues_whenValidated_thenTrue() {
        assertTrue(IsIntegerValidator.validate(String.valueOf(Integer.MIN_VALUE)));
        assertTrue(IsIntegerValidator.validate(String.valueOf(Integer.MAX_VALUE)));
    }
}
